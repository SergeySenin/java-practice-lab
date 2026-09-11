package org.study.javarush.java.core.level07.tasks07.b;

public class Solution114 {
    public static void main(String[] args) {

        double[] sensorReadings = new double[4];
        sensorReadings[2] = 3.14;
        for (int i = 0; i < sensorReadings.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(sensorReadings[i]);
        }
    }
}
