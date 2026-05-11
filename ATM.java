import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 1000; 
        int choice = 0;

        do {
            try {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0) {
                            throw new IllegalArgumentException("Invalid amount!");
                        }

                        balance = balance + deposit;
                        System.out.println("Amount deposited successfully.");
                        break;

                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw > balance) {
                            throw new InsufficientBalanceException("Not enough balance!");
                        }

                        if (withdraw <= 0) {
                            throw new IllegalArgumentException("Invalid amount!");
                        }

                        balance = balance - withdraw;
                        System.out.println("Please collect your cash.");
                        break;

                    case 4:
                        System.out.println("Thank you for using ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) 
		{
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); 
                choice = 0;            
		}

        } while (choice != 4);

      }
}