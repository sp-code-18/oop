import java.util.Scanner;

public class HotelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rooms[][] = new int[3][3];

        int choice, floor, room;

        do {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) 
		{
                case 1:
                    System.out.println("\nRoom Status");
                    System.out.println("0 = Available");
                    System.out.println("1 = Booked\n");
                    for (int i = 0; i < 3; i++) 
			{
                        System.out.print("Floor " + (i + 1) + ": ");

                        for (int j = 0; j < 3; j++) 
			{
                            System.out.print(rooms[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Enter Floor Number (1-3): ");
                    floor = sc.nextInt();

                    System.out.print("Enter Room Number (1-3): ");
                    room = sc.nextInt();

                    if (rooms[floor - 1][room - 1] == 0) 
			{
                        rooms[floor - 1][room - 1] = 1;
                        System.out.println("Room Booked Successfully");
                    	} 
			else 
			{
                        System.out.println("Room Already Booked");
                	}
                    break;

                case 3:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while (choice != 3);

        sc.close();
    }
}