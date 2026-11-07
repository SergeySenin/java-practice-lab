package org.study.javarush.java.core.level23.tasks23.e.temp2;

public class Solution445 {
    public static void main(String[] args) {

        Shape[] shapes = {new Circle(), new Square()};

        for (Shape shape : shapes) {
            shape.printType();
        }
    }
}

abstract class Shape {
    public abstract void printType();
}

class Circle extends Shape {
    @Override
    public void printType() {
        System.out.println("Круг");
    }
}

class Square extends Shape {
    @Override
    public void printType() {
        System.out.println("Квадрат");
    }
}
