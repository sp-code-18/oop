/*
CREATE DATABASE college;

USE college;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    marks DOUBLE
);
*/

import java.sql.*;
import java.util.Scanner;

class StudentManagement {

    static final String URL =
            "jdbc:mysql://localhost:3306/college";

    static final String USER = "root";
    static final String PASS = "avcoe";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            con.setAutoCommit(false);

            int choice;

            do {

                System.out.println("\n===== Student Management =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                try {

                    switch (choice) {

                        case 1:

                            sc.nextLine();

                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Marks: ");
                            double marks = sc.nextDouble();

                            String insertQuery =
                                    "INSERT INTO student(name, marks) VALUES(?, ?)";

                            PreparedStatement ps1 =
                                    con.prepareStatement(insertQuery);

                            ps1.setString(1, name);
                            ps1.setDouble(2, marks);

                            int insertRows = ps1.executeUpdate();

                            if (insertRows > 0) {

                                con.commit();
                                System.out.println("Student Added Successfully");
                            }
                            break;

                        case 2:

                            String selectQuery =
                                    "SELECT * FROM student";

                            PreparedStatement ps2 =
                                    con.prepareStatement(selectQuery);

                            ResultSet rs = ps2.executeQuery();

                            System.out.println("\nID\tNAME\tMARKS");
                            System.out.println("-------------------------");

                            while (rs.next()) {

                                System.out.println(
                                        rs.getInt("id") + "\t" +
                                        rs.getString("name") + "\t" +
                                        rs.getDouble("marks")
                                );
                            }
                            break;

                        case 3:

                            System.out.print("Enter Student ID: ");
                            int uid = sc.nextInt();

                            System.out.print("Enter New Marks: ");
                            double newMarks = sc.nextDouble();

                            String updateQuery =
                                    "UPDATE student SET marks=? WHERE id=?";

                            PreparedStatement ps3 =
                                    con.prepareStatement(updateQuery);

                            ps3.setDouble(1, newMarks);
                            ps3.setInt(2, uid);

                            int updateRows = ps3.executeUpdate();

                            if (updateRows > 0) {

                                con.commit();
                                System.out.println("Student Updated Successfully");

                            } else {

                                System.out.println("Student Not Found");
                            }
                            break;

                        case 4:

                            System.out.print("Enter Student ID: ");
                            int did = sc.nextInt();

                            String deleteQuery =
                                    "DELETE FROM student WHERE id=?";

                            PreparedStatement ps4 =
                                    con.prepareStatement(deleteQuery);

                            ps4.setInt(1, did);

                            int deleteRows = ps4.executeUpdate();

                            if (deleteRows > 0) {

                                con.commit();
                                System.out.println("Student Deleted Successfully");

                            } else {

                                System.out.println("Student Not Found");
                            }

                            break;

                        case 5:

                            System.out.println("Program Closed");
                            break;

                        default:
                            System.out.println("Invalid Choice");
                    }

                } catch (SQLException e) {

                    con.rollback();

                    System.out.println(
                            "Transaction Failed: " + e.getMessage()
                    );
                }

            } while (choice != 5);

            con.close();

        } catch (ClassNotFoundException e) {

            System.out.println("Driver Not Found");

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}


/*
javac -cp ".;mysql-connector-j-9.6.0.jar" StudentManagement.java
java -cp ".;mysql-connector-j-9.6.0.jar" StudentManagement
*/
