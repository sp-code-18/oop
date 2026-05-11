import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "avcoe";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       try {

    	Class.forName("com.mysql.cj.jdbc.Driver");

    	Connection con = DriverManager.getConnection(URL, USER, PASS);;

        int choice;

            do {
                System.out.println("\n=== Employee Menu ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();

                        String insert = "INSERT INTO employee(name, salary) VALUES (?, ?)";
                        PreparedStatement ps1 = con.prepareStatement(insert);
                        ps1.setString(1, name);
                        ps1.setDouble(2, salary);

                        ps1.executeUpdate();
                        System.out.println("Employee added!");
                        break;

                    case 2:
                        String select = "SELECT * FROM employee";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(select);

                        System.out.println("\nID  Name   Salary");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + "  " +
                                rs.getString("name") + "  " +
                                rs.getDouble("salary")
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();

                        String update = "UPDATE employee SET salary=? WHERE id=?";
                        PreparedStatement ps2 = con.prepareStatement(update);
                        ps2.setDouble(1, newSalary);
                        ps2.setInt(2, uid);

                        int rows = ps2.executeUpdate();
                        if (rows > 0)
                            System.out.println("Updated successfully!");
                        else
                            System.out.println("Employee not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();

                        String delete = "DELETE FROM employee WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(delete);
                        ps3.setInt(1, did);

                        int drows = ps3.executeUpdate();
                        if (drows > 0)
                            System.out.println("Deleted successfully!");
                        else
                            System.out.println("Employee not found.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

      }
}


/*
javac -cp ".;mysql-connector-j-9.6.0.jar" EmployeeApp.java
java -cp ".;mysql-connector-j-9.6.0.jar" EmployeeApp
*/