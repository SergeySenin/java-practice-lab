package org.study.javarush.java.core.level07.tasks07.e;

public class Solution127 {
    public static void main(String[] args) {

        int[][] zoneTemperatures = new int[][] {
                new int[] {22, 25, 20},
                new int[] {25, 25},
                new int[] {22, 20, 22, 20}
        };

        int maxTemperature = zoneTemperatures[0][0];

        for (int zoneIndex = 0; zoneIndex < zoneTemperatures.length; zoneIndex++) {
            for (int temperatureIndex = 0;
                 temperatureIndex < zoneTemperatures[zoneIndex].length;
                 temperatureIndex++) {

                if (zoneTemperatures[zoneIndex][temperatureIndex] > maxTemperature) {
                    maxTemperature = zoneTemperatures[zoneIndex][temperatureIndex];
                }
            }
        }

        System.out.println(maxTemperature);
    }
}
