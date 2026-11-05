package org.study.javarush.java.core.level22.tasks22.d.temp2;

public class Solution421 {
    public static void main(String[] args) {

        Point first = new Point(5, 10);
        Point second = new Point(5, 10);

        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}

record Point(int x, int y) {
}
