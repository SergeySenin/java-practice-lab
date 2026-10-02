package org.study.javarush.java.core.level06.tasks06.g;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        byte protocolVersion = 6;
        short stationAltitude = 1847;
        int measurementCount = 3;
        long totalMeasurementCount = 12_500_000_000L;
        float legacySensorAccuracy = 98.5F;
        double calibrationFactor = legacySensorAccuracy;

        char stationCode = 'M';
        int stationUnicodeCode = stationCode;
        char restoredStationCode = (char) stationUnicodeCode;

        double firstTemperature = console.nextDouble();
        double secondTemperature = console.nextDouble();
        double thirdTemperature = console.nextDouble();
        double temperatureSum = firstTemperature + secondTemperature + thirdTemperature;
        double averageTemperature = temperatureSum / measurementCount;

        int totalRainfall = 7;
        int rainyDays = 2;
        double averageRainfall = (double) totalRainfall / rainyDays;

        int truncatedTemperature = (int) averageTemperature;
        long averageTemperatureRoundedToWholeNumber = Math.round(averageTemperature);
        double averageTemperatureRoundedDown = Math.floor(averageTemperature);
        double averageTemperatureRoundedUp = Math.ceil(averageTemperature);
        double averageTemperatureRintResult = Math.rint(averageTemperature);

        double averageTemperatureRoundedToTwoDecimals =
                Math.round(averageTemperature * 100.0) / 100.0;
        String formattedAverageTemperature =
                String.format(java.util.Locale.US, "%.2f", averageTemperature);

        double totalProcessedData = 12345678.9012;
        DecimalFormat processedDataNumberFormat = new DecimalFormat("#,##0.00");
        String formattedTotalProcessedData = processedDataNumberFormat.format(totalProcessedData);

        double actualCalibration = 0.1 + 0.2;
        double expectedCalibration = 0.3;
        double calibrationTolerance = 0.000001;
        boolean exactCalibrationMatch = actualCalibration == expectedCalibration;
        double calibrationDifference = Math.abs(actualCalibration - expectedCalibration);
        boolean calibrationWithinTolerance = calibrationDifference < calibrationTolerance;

        if (calibrationWithinTolerance) {
            System.out.println("Calibration status: ACCEPTED");
        } else {
            System.out.println("Calibration status: REJECTED");
        }

        double divisionByZeroResult = 1.0 / 0.0;
        System.out.println(divisionByZeroResult);
        boolean isDivisionByZeroInfinite = Double.isInfinite(divisionByZeroResult);

        double negativeSquareRootResult = Math.sqrt(-1);
        boolean isNegativeSquareRootNaN = Double.isNaN(negativeSquareRootResult);

        int extremeTemperature = 200;
        byte legacyControllerReading = (byte) extremeTemperature;
        System.out.println("Original value: "          + extremeTemperature);
        System.out.println("Value after int -> byte: " + legacyControllerReading);

        System.out.println("Protocol version: "       + protocolVersion);
        System.out.println("Station altitude: "       + stationAltitude + " m");
        System.out.println("Station code: "           + stationCode);
        System.out.println("Station Unicode code: "   + stationUnicodeCode);
        System.out.println("Restored station code: "  + restoredStationCode);
        System.out.println("Total measurements: "     + totalMeasurementCount);
        System.out.println("Legacy sensor accuracy: " + legacySensorAccuracy);
        System.out.println("Calibration factor: "     + calibrationFactor);

        System.out.println(
                "Measurement count: "             + measurementCount
        );
        System.out.println(
                "Temperature sum: "               + temperatureSum
        );
        System.out.println(
                "Average temperature: "           + averageTemperature
        );
        System.out.println(
                "Average temperature rounded: "   + averageTemperatureRoundedToTwoDecimals
        );
        System.out.println(
                "Average temperature formatted: " + formattedAverageTemperature
        );
        System.out.println(
                "Truncated temperature: "         + truncatedTemperature
        );
        System.out.println(
                "Rounded temperature: "           + averageTemperatureRoundedToWholeNumber
        );
        System.out.println(
                "Floor: "                         + averageTemperatureRoundedDown
        );
        System.out.println(
                "Ceil: "                          + averageTemperatureRoundedUp
        );
        System.out.println(
                "Rint: "                          + averageTemperatureRintResult
        );

        System.out.println("Average rainfall: " + averageRainfall);
        System.out.println("Processed data: "   + formattedTotalProcessedData);

        System.out.println("Exact calibration match: "      + exactCalibrationMatch);
        System.out.println("Calibration within tolerance: " + calibrationWithinTolerance);

        System.out.println("Infinity diagnostic: "       + divisionByZeroResult);
        System.out.println("Is infinite: "               + isDivisionByZeroInfinite);
        System.out.println("NaN diagnostic: "            + negativeSquareRootResult);
        System.out.println("Is NaN: "                    + isNegativeSquareRootNaN);
        System.out.println("Legacy controller reading: " + legacyControllerReading);
    }
}
