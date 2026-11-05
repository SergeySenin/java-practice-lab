package org.study.javarush.java.core.level22.tasks22.c.temp3;

public class Solution418 {
    public static void main(String[] args) {

        Point initialPoint = new Point(3, 7);
        Point movedPoint = new Point(initialPoint.horizontal() + 2, initialPoint.vertical());

        System.out.println(initialPoint);
        System.out.println(movedPoint);
    }
}

record Point(int horizontal, int vertical) {
}
