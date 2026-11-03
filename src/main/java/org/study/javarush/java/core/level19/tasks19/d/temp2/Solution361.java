package org.study.javarush.java.core.level19.tasks19.d.temp2;

public class Solution361 {
    public static void main(String[] args) {

        Square square = new Square(4);
        Circle circle = new Circle(3);

        System.out.println(square.area());
        System.out.println(circle.area());
    }
}

abstract class Figure {
    public abstract double area();
}

class Square extends Figure {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Circle extends Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
