package org.study.javarush.java.core.level18.tasks18.b.temp4;

public class Solution335 {
    public static void main(String[] args) {

        Vehicle[] vehicles = {new Car(), new Bicycle(), new Scooter()};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}

class Vehicle {
    void move() {
        System.out.println("Транспорт движется.");
    }
}

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("Машина едет.");
    }
}

class Bicycle extends Vehicle {
    @Override
    void move() {
        System.out.println("Велосипед едет.");
    }
}

class Scooter extends Vehicle {
    @Override
    void move() {
        System.out.println("Самокат едет.");
    }
}
