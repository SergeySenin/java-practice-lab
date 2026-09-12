package org.study.javarush.java.core.level07.tasks07.c;

public class Solution119 {
    public static void main(String[] args) {

        int[] hourlyTemperatures = {3, 11, 7, 4, 15, 2};
        int maxTemperature = hourlyTemperatures[0];

        for (int temperatureIndex = 1; temperatureIndex < hourlyTemperatures.length; temperatureIndex++) {
            if (hourlyTemperatures[temperatureIndex] > maxTemperature) {
                maxTemperature = hourlyTemperatures[temperatureIndex];
            }
        }

        System.out.println(maxTemperature);
    }
}
