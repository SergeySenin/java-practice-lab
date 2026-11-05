package org.study.javarush.java.core.level22.tasks22.f.temp2;

public class Solution429 {
    public static void main(String[] args) {

        Point first = new Point(3, 7);
        Point second = new Point(3, 7);

        System.out.println(first.equals(second));
    }
}

record Point(int horizontal, int vertical) {
}
