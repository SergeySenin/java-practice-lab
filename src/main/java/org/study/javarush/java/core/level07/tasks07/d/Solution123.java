package org.study.javarush.java.core.level07.tasks07.d;

public class Solution123 {
    public static void main(String[] args) {

        int[][] sensorData = new int[2][5];
        int sensorReading = 10;

        for (int rowIndex = 0; rowIndex < sensorData.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < sensorData[rowIndex].length; columnIndex++) {
                sensorData[rowIndex][columnIndex] = sensorReading;
                sensorReading++;

                System.out.print(sensorData[rowIndex][columnIndex]);

                if (columnIndex < sensorData[rowIndex].length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
