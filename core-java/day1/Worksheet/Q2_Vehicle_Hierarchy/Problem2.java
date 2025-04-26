package Worksheet.Q2_Vehicle_Hierarchy;

/*
Design a class `Vehicle` with fields like `speed` and `fuelCapacity`. Extend it with `Car` and `Truck`
classes. Add specific methods like `getMileage()` in each subclass that calculate mileage based on
different formulas.
*/

class Vehicle {
    int speed;
    double fuelCapacity;

    public Vehicle(int speed, double fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    public Vehicle() {
        speed = 0;
        fuelCapacity = 0.0;
    }
}

class Car extends Vehicle {
    public Car(int speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Sample formula: mileage = (speed * 0.8) / fuelCapacity
    public double getMileage() {
        return (speed * 0.8) / fuelCapacity;
    }
}

class Truck extends Vehicle {
    public Truck(int speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Sample formula: mileage = (speed * 0.6) / fuelCapacity
    public double getMileage() {
        return (speed * 0.6) / fuelCapacity;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Car myCar = new Car(100, 50.0);
        Truck myTruck = new Truck(80, 120.0);

        System.out.println("Car Mileage: " + myCar.getMileage());
        System.out.println("Truck Mileage: " + myTruck.getMileage());
    }
}
