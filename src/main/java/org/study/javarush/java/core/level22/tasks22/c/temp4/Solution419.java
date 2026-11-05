package org.study.javarush.java.core.level22.tasks22.c.temp4;

public class Solution419 {
    public static void main(String[] args) {

        int[] values = {10, 20, 30};
        SensorData sensorData = new SensorData(values);

        values[0] = 99;

        System.out.println(sensorData.values()[0]);
    }
}

record SensorData(int[] values) {
}
