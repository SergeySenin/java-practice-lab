package org.study.javarush.java.core.level17.tasks17.e.temp2;

public class Solution325 {
    public static void main(String[] args) {

        Car car = new Car();
        car.move();
        car.beep();
    }
}

class Vehicle {
    void move() {
        System.out.println("Транспорт движется.");
    }
}

class Car extends Vehicle {
    void beep() {
        System.out.println("Машина сигналит: Бип-бип!");
    }
}
