package org.study.javarush.java.core.level08.tasks08.c;

public class Solution139 {
    public static void main(String[] args) { // main не в ShapeDesigner → отклонение от условия задачи

        ShapeDesigner.printRectangleSpecs(5, 10);
        ShapeDesigner.printRectangleSpecs(3, 7);
        ShapeDesigner.printRectangleSpecs(12, 4);
    }

    public class ShapeDesigner {
        public static void printRectangleSpecs(int rectangleWidth, int rectangleHeight) {
            System.out.println(
                    "Характеристики прямоугольника: ширина = " + rectangleWidth + ", высота = " + rectangleHeight
            );
        }
    }
}
