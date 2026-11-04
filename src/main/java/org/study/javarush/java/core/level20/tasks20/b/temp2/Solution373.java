package org.study.javarush.java.core.level20.tasks20.b.temp2;

public class Solution373 {
    public static void main(String[] args) {

        Drawable drawable = new Circle();

        drawable.draw();
    }
}

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
