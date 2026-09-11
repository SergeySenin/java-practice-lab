package org.study.javarush.java.core.level07.tasks07.d;

public class Solution123 {
    public static void main(String[] args) {

        int[][] sensorData = new int[2][5];
        int value = 10;
        for (int i = 0; i < sensorData.length; i++) {
            for (int j = 0; j < sensorData[i].length; j++) {
                sensorData[i][j] = value;
                value++;
                System.out.print(sensorData[i][j]);
                if (j < sensorData[i].length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
