package org.study.javarush.java.core.level19.tasks19.e.temp3;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Lada"));
        vehicles.add(new Bicycle("Stels"));

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}

abstract class Vehicle {
    protected final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Машина " + model + " едет");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Велосипед " + model + " едет");
    }
}
