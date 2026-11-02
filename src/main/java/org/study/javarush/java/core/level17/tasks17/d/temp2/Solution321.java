package org.study.javarush.java.core.level17.tasks17.d.temp2;

public class Solution321 {
    public static void main(String[] args) {

        Car car = new Car("BMW", 2023);
    }
}

class Vehicle {
    Vehicle(String brandName) {
        System.out.println("Транспорт: " + brandName);
    }
}

class Car extends Vehicle {
    Car(String carBrand, int manufacturingYear) {
        super(carBrand);
        System.out.println("Машина " + carBrand + ", год: " + manufacturingYear);
    }
}
