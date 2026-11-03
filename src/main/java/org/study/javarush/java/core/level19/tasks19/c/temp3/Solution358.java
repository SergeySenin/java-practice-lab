package org.study.javarush.java.core.level19.tasks19.c.temp3;

public class Solution358 {
    public static void main(String[] args) {

        Circle circle = new Circle("Круг", 2.0);
        System.out.println(circle.getName());
        System.out.println(circle.area());
    }
}

abstract class Shape {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double area();
}

class Circle extends Shape {
    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
