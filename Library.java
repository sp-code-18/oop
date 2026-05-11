import java.util.Scanner;

class Book {
    int id;
    String name;
    boolean isIssued;

    static int totalBooks = 0; 

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
        totalBooks++;
    }

    void display() {
        System.out.println("Book ID: " + id);
        System.out.println("Book Name: " + name);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
    }

    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    static void showTotalBooks() {
        System.out.println("Total Books in Library: " + totalBooks);
    }
}

class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[100]; 
        int count = 0;

        while (true) {
            try {
                System.out.println("\n=== Library Menu ===");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Total Books");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); 

                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine();

                        books[count] = new Book(id, name);
                        count++;
                        System.out.println("Book added successfully.");
                        break;

                    case 2:
                        if (count == 0) {
                            System.out.println("No books available.");
                        } else {
                            for (int i = 0; i < count; i++) {
                                System.out.println("\n--- Book " + (i + 1) + " ---");
                                books[i].display();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Book ID to issue: ");
                        int issueId = sc.nextInt();
                        boolean foundIssue = false;

                        for (int i = 0; i < count; i++) {
                            if (books[i].id == issueId) {
                                books[i].issueBook();
                                foundIssue = true;
                                break;
                            }
                        }

                        if (!foundIssue) {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        int returnId = sc.nextInt();
                        boolean foundReturn = false;

                        for (int i = 0; i < count; i++) {
                            if (books[i].id == returnId) {
                                books[i].returnBook();
                                foundReturn = true;
                                break;
                            }
                        }

                        if (!foundReturn) {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 5:
                        Book.showTotalBooks(); 
                        break;

                    case 6:
                        System.out.println("Exiting system...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();             }
        }
    }
}