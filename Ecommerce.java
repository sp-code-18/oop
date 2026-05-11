import java.util.Scanner;

class Product {

    int productId;
    String productName;
    double price;
    int quantity;

    Product() {
        productId = 101;
        productName = "Keyboard";
        price = 800;
        quantity = 1;
    }

    Product(int id, String name, double p, int q) {
        productId = id;
        productName = name;
        price = p;
        quantity = q;
    }

    double calculateTotal() {
        return price * quantity;
    }
}

public class Ecommerce {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product p1 = new Product();

        Product p2 = new Product(102, "Mouse", 500, 2);

        System.out.println("Enter Product Details");

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Product p3 = new Product(id, name, price, quantity);

        double total1 = p1.calculateTotal();
        double total2 = p2.calculateTotal();
        double total3 = p3.calculateTotal();

        double grandTotal = total1 + total2 + total3;

        double discount = 0;

        if (grandTotal >= 5000) {
            discount = grandTotal * 0.10;
        }

        double finalAmount = grandTotal - discount;

        System.out.println("\n========== INVOICE ==========");

        System.out.println("\nProduct 1");
        System.out.println("ID: " + p1.productId);
        System.out.println("Name: " + p1.productName);
        System.out.println("Price: " + p1.price);
        System.out.println("Quantity: " + p1.quantity);
        System.out.println("Total: " + total1);

        System.out.println("\nProduct 2");
        System.out.println("ID: " + p2.productId);
        System.out.println("Name: " + p2.productName);
        System.out.println("Price: " + p2.price);
        System.out.println("Quantity: " + p2.quantity);
        System.out.println("Total: " + total2);

        System.out.println("\nProduct 3");
        System.out.println("ID: " + p3.productId);
        System.out.println("Name: " + p3.productName);
        System.out.println("Price: " + p3.price);
        System.out.println("Quantity: " + p3.quantity);
        System.out.println("Total: " + total3);

        System.out.println("\n-----------------------------");
        System.out.println("Grand Total : " + grandTotal);
        System.out.println("Discount    : " + discount);
        System.out.println("Final Amount: " + finalAmount);

        System.out.println("\nThank You for Shopping!");

        sc.close();
    }
}