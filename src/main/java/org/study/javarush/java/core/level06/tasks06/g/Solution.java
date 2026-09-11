package org.study.javarush.java.core.level06.tasks06.g;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        byte protocolVersion = 6;
        short stationAltitude = 1847;
        int measurementCount = 3;
        long totalMeasurements = 12_500_000_000L;
        float legacySensorAccuracy = 98.5F;
        double calibrationFactor = legacySensorAccuracy;

        char stationCode = 'M';
        int stationUnicodeCode = stationCode;
        char restoredStationCode = (char) stationUnicodeCode;

        double temperatureOne = console.nextDouble();
        double temperatureTwo = console.nextDouble();
        double temperatureThree = console.nextDouble();
        double temperatureSum = temperatureOne + temperatureTwo + temperatureThree;
        double averageTemperature = temperatureSum / measurementCount;

        int totalRainfall = 7;
        int rainyDays = 2;
        double averageRainfall = (double) totalRainfall / rainyDays;

        int truncatedTemperature = (int) averageTemperature;
        long roundedTemperature = Math.round(averageTemperature);
        double temperatureFloor = Math.floor(averageTemperature);
        double temperatureCeil = Math.ceil(averageTemperature);
        double temperatureRint = Math.rint(averageTemperature);

        double roundedAverageTemperature = Math.round(averageTemperature * 100.0) / 100.0;
        String formattedTemperature =
                String.format(java.util.Locale.US, "%.2f", averageTemperature);

        double totalProcessedData = 12345678.9012;
        DecimalFormat largeNumberFormat = new DecimalFormat("#,##0.00");
        String formattedProcessedData = largeNumberFormat.format(totalProcessedData);

        double actualCalibration = 0.1 + 0.2;
        double expectedCalibration = 0.3;
        double epsilon = 0.000001;
        boolean exactCalibrationMatch = actualCalibration == expectedCalibration;
        double calibrationDifference = Math.abs(actualCalibration - expectedCalibration);
        boolean calibrationWithinTolerance = calibrationDifference < epsilon;

        if (calibrationWithinTolerance) {
            System.out.println("Calibration status: ACCEPTED");
        } else {
            System.out.println("Calibration status: REJECTED");
        }

        double infinityDiagnostic = 1.0 / 0.0;
        System.out.println(infinityDiagnostic);
        boolean isInfiniteResult = Double.isInfinite(infinityDiagnostic);

        double nanDiagnostic = Math.sqrt(-1);
        boolean isNaNResult = Double.isNaN(nanDiagnostic);

        int extremeTemperature = 200;
        byte legacyControllerReading = (byte) extremeTemperature;
        System.out.println("Original value: "          + extremeTemperature);
        System.out.println("Value after int -> byte: " + legacyControllerReading);

        System.out.println("Protocol version: "       + protocolVersion);
        System.out.println("Station altitude: "       + stationAltitude + " m");
        System.out.println("Station code: "           + stationCode);
        System.out.println("Station Unicode code: "   + stationUnicodeCode);
        System.out.println("Restored station code: "  + restoredStationCode);
        System.out.println("Total measurements: "     + totalMeasurements);
        System.out.println("Legacy sensor accuracy: " + legacySensorAccuracy);
        System.out.println("Calibration factor: "     + calibrationFactor);

        System.out.println("Measurement count: "             + measurementCount);
        System.out.println("Temperature sum: "               + temperatureSum);
        System.out.println("Average temperature: "           + averageTemperature);
        System.out.println("Average temperature rounded: "   + roundedAverageTemperature);
        System.out.println("Average temperature formatted: " + formattedTemperature);
        System.out.println("Truncated temperature: "         + truncatedTemperature);
        System.out.println("Rounded temperature: "           + roundedTemperature);
        System.out.println("Floor: "                         + temperatureFloor);
        System.out.println("Ceil: "                          + temperatureCeil);
        System.out.println("Rint: "                          + temperatureRint);

        System.out.println("Average rainfall: " + averageRainfall);
        System.out.println("Processed data: "   + formattedProcessedData);

        System.out.println("Exact calibration match: "      + exactCalibrationMatch);
        System.out.println("Calibration within tolerance: " + calibrationWithinTolerance);

        System.out.println("Infinity diagnostic: "       + infinityDiagnostic);
        System.out.println("Is infinite: "               + isInfiniteResult);
        System.out.println("NaN diagnostic: "            + nanDiagnostic);
        System.out.println("Is NaN: "                    + isNaNResult);
        System.out.println("Legacy controller reading: " + legacyControllerReading);
    }
}
