package org.study.javarush.java.core.level07.tasks07.c;

public class Solution119 {
    public static void main(String[] args) {

        int[] hourlyTemperatures = {3, 11, 7, 4, 15, 2};
        int max = hourlyTemperatures[0];
        for (int i = 1; i < hourlyTemperatures.length; i++) {
            if (hourlyTemperatures[i] > max) {
                max = hourlyTemperatures[i];
            }
        }
        System.out.println(max);
    }
}
