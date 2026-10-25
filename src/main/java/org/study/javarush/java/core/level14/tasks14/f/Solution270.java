package org.study.javarush.java.core.level14.tasks14.f;

public class Solution270 {
    public static void main(String[] args) {

        Car newCar = new Car();
    }
}

class Car {
    String carModel = "Неизвестно";

    {
        System.out.println("Создаётся объект Car, model = " + carModel);
    }
}
