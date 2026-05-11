import java.util.Scanner;

class Calculator{

	 public static void main(String args[]){
	 int num1,num2,res;
	 int ch;
	 char choice;

	 Scanner sc = new Scanner(System.in);

	 do{
	   System.out.println("=== Java calculator ===");
	   System.out.println("1.Addition");
	   System.out.println("2.Substraction");
	   System.out.println("3.Multiplication");
	   System.out.println("4.Division");
	   System.out.println("Enter your choice");
	   ch = sc.nextInt();

	   System.out.println("Enter first number");
	   num1= sc.nextInt();
	   
	   System.out.println("Enter second number");
	   num2= sc.nextInt();


	   try{
		switch(ch)
		{
			case 1:
			res = num1 + num2;
			System.out.println("Addition"+res);
			break;

			case 2:
			res = num1 - num2;
			System.out.println("sub"+res);
			break;

			case 3:
			res = num1 * num2;
			System.out.println("mul"+res);
			break;

			case 4:
			if (num2 == 0)
			{
			  throw new ArithmeticException("Can't divide by 0");
			}
			res = num1 / num2;
			System.out.println("div "+res);
			break;

			default:
			System.out.println("Invalid input");

		}

	   }
	   catch(ArithmeticException e){
		System.out.println("Error "+e.getMessage());
	   }
	   catch(Exception e){
		System.out.println("Invalid user input");	
	   }
	 System.out.println("do you want to continue..? (y/n)/(Y/N) ");
	 choice = sc.next().charAt(0);
	 }
	 while(choice == 'Y' || choice == 'y');
	 System.out.println("closed");
	 sc.close();
	}
}