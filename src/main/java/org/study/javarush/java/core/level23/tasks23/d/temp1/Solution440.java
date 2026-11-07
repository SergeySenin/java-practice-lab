package org.study.javarush.java.core.level23.tasks23.d.temp1;

public class Solution440 {
    public static void main(String[] args) {

        Car car = new Car();
        car.carBrand = "Toyota";
        car.productionYear = 2022;

        System.out.println("Марка: " + car.carBrand);
        System.out.println("Год выпуска: " + car.productionYear);
    }
}

class Car {
    public String carBrand;
    public int productionYear;
}
