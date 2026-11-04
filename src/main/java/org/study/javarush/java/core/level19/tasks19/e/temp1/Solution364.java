package org.study.javarush.java.core.level19.tasks19.e.temp1;

public class Solution364 {
    public static void main(String[] args) {

        Circle circle = new Circle(2.0);

        System.out.println(circle.area());
    }
}

abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}
