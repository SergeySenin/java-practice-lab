package org.study.javarush.java.core.level14.tasks14.d;

public class Solution262 {
    public static void main(String[] args) {

        Car firstCar = new Car();
        firstCar.carBrand = "Toyota";
        firstCar.carYear = 2020;

        Car secondCar = new Car();
        secondCar.carBrand = "Lada";
        secondCar.carYear = 2010;

        System.out.println("Марка: " + firstCar.carBrand + ", год выпуска: " + firstCar.carYear);

        System.out.println("Марка: " + secondCar.carBrand + ", год выпуска: " + secondCar.carYear);
    }
}

class Car {
    String carBrand;
    int carYear;
}
