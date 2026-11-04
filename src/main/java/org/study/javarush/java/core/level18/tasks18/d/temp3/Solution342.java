package org.study.javarush.java.core.level18.tasks18.d.temp3;

public class Solution342 {
    public static void main(String[] args) {

        Shape shape = new Circle();

        shape.draw();
    }
}

class Shape {
    void draw() {
        System.out.println("Рисуем фигуру");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Рисуем круг");
    }
}
