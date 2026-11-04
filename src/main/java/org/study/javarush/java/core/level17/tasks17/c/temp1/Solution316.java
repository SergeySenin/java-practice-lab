package org.study.javarush.java.core.level17.tasks17.c.temp1;

public class Solution316 {
    public static void main(String[] args) {

        Circle circle = new Circle();

        circle.draw();
    }
}

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
