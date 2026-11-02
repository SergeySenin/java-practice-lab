package org.study.javarush.java.core.level17.tasks17.b.temp3;

public class Solution314 {
    public static void main(String[] args) {

        Car car = new Car();
        car.vehicleModel = "Lada";

        car.start();
    }
}

class Vehicle {
    String vehicleModel;

    void start() {
        System.out.println(vehicleModel + " заводится.");
    }
}

class Car extends Vehicle {
}
