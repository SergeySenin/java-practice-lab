package org.study.javarush.java.core.level17.tasks17.b.temp4;

public class Solution315 {
    public static void main(String[] args) {

        Apple apple = new Apple();
        apple.fruitColor = "красный";

        Banana banana = new Banana();
        banana.fruitColor = "жёлтый";

        apple.printColor();
        banana.printColor();
    }
}

class Fruit {
    String fruitColor;

    void printColor() {
        System.out.println("Цвет: " + fruitColor);
    }
}

class Apple extends Fruit {
}

class Banana extends Fruit {
}
