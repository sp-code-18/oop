class Vehicle {
    String brand = "BMW";

    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {

    void drive() {
        System.out.println("Car is driving");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {

        Car c = new Car();

        c.start();

        System.out.println("Brand: " + c.brand);

        c.drive();
    }
}