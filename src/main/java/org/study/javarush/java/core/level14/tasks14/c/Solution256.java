package org.study.javarush.java.core.level14.tasks14.c;

public class Solution256 {
    public static void main(String[] args) {

        Car car = new Car("Toyota", 2020);

        car.displayDetails();
    }
}

class Car {
    String carBrand;
    int productionYear;

    Car(String carBrand, int productionYear) {
        this.carBrand = carBrand;
        this.productionYear = productionYear;
    }

    void displayDetails() {
        System.out.println("Марка: " + carBrand + ", год выпуска: " + productionYear);
    }
}
