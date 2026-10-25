package org.study.javarush.java.core.level14.tasks14.e;

public class Solution266 {
    public static void main(String[] args) {

        Car firstCar = new Car("Toyota", "Corolla", 2020);
        Car secondCar = new Car("Lada", "Vesta");
        Car thirdCar = new Car();

        System.out.println(
                "Марка: "
                + firstCar.carBrand
                + ", модель: "
                + firstCar.carModel
                + ", год выпуска: "
                + firstCar.productionYear
        );

        System.out.println(
                "Марка: "
                + secondCar.carBrand
                + ", модель: "
                + secondCar.carModel
                + ", год выпуска: "
                + secondCar.productionYear
        );

        System.out.println(
                "Марка: "
                + thirdCar.carBrand
                + ", модель: "
                + thirdCar.carModel
                + ", год выпуска: "
                + thirdCar.productionYear
        );
    }
}

class Car {
    String carBrand;
    String carModel;
    int productionYear;

    Car(String carBrand, String carModel, int productionYear) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.productionYear = productionYear;
    }

    Car(String carBrand, String carModel) {
        this(carBrand, carModel, 2024);
    }

    Car() {
        this("Unknown", "Unknown");
    }
}
