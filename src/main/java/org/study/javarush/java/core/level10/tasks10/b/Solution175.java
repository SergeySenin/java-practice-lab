package org.study.javarush.java.core.level10.tasks10.b;

public class Solution175 {
    public static void main(String[] args) {

        String sensorReadingText = "NaN";
        double parsedSensorData = Double.parseDouble(sensorReadingText);
        boolean isNotANumber = Double.isNaN(parsedSensorData);

        System.out.println(isNotANumber);
    }
}
