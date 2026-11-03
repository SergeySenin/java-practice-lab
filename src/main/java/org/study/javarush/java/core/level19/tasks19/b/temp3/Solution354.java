package org.study.javarush.java.core.level19.tasks19.b.temp3;

import java.util.ArrayList;
import java.util.List;

public class Solution354 {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bicycle());

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}

abstract class Vehicle {
    public abstract void move();
}

class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Машина едет по дороге");
    }
}

class Bicycle extends Vehicle {
    @Override
    public void move() {
        System.out.println("Велосипед крутит педали");
    }
}
