package org.study.javarush.java.core.level19.tasks19.d.temp1;

public class Solution360 {
    public static void main(String[] args) {

        Car car = new Car();

        car.move();
    }
}

abstract class Vehicle {
    public abstract void move();
}

class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Машина едет");
    }
}
