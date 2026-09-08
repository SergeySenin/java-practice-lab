package org.study.javarush.java.core.level06.tasks06.d;

public class Solution101 {
    public static void main(String[] args) {

        double cosmicEvent = 1.0 / 0.0;

        System.out.println(cosmicEvent);
        System.out.println(Double.isInfinite(cosmicEvent));
    }
}
