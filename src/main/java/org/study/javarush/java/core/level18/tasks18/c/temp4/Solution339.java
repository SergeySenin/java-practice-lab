package org.study.javarush.java.core.level18.tasks18.c.temp4;

public class Solution339 {
    public static void main(String[] args) {

        Rectangle square = new Rectangle(5);
        Rectangle rectangle = new Rectangle(10, 7);

        System.out.println(square.width + " " + square.height);
        System.out.println(rectangle.width + " " + rectangle.height);
    }
}

class Rectangle {
    int width;
    int height;

    Rectangle(int width) {
        this(width, width);
    }

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
