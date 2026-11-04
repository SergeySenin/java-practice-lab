package org.study.javarush.java.core.level20.tasks20.c.temp1;

public class Solution376 {
    public static void main(String[] args) {

        Car car = new Car();

        car.move();
    }
}

interface Movable {
    void move();
}

class Car implements Movable {
    @Override
    public void move() {
        System.out.println("Машина едет");
    }
}
