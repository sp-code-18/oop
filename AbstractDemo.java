abstract class Vehicle {

    abstract void start();

    void fuelType() {
        System.out.println("Vehicle uses fuel");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with key");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {

        Car c = new Car();

        c.start();
        c.fuelType();
    }
}