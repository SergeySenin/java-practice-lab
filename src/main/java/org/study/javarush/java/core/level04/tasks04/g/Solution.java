package org.study.javarush.java.core.level04.tasks04.g;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String missionNameInput = console.nextLine();
        String missionName = missionNameInput.trim();

        int batteryLevelPercent;

        do {
            batteryLevelPercent = console.nextInt();

            if (batteryLevelPercent < 20 || batteryLevelPercent > 100) {
                System.out.println("Invalid battery level.");
            }
        } while (batteryLevelPercent < 20 || batteryLevelPercent > 100);

        System.out.println("Battery accepted: " + batteryLevelPercent + "%");

        int checkpointCount = console.nextInt();
        int targetCheckpointNumber = console.nextInt();
        int mapSideLength = console.nextInt();
        int beaconRowIndex = console.nextInt();
        int beaconColumnIndex = console.nextInt();

        for (int launchCountdown = 3; launchCountdown >= 1; launchCountdown--) {
            System.out.println(launchCountdown);
        }

        System.out.println("LAUNCH");

        int sensorDistanceReading = console.nextInt();
        int sensorReadingCount = 0;
        int sensorDistanceSum = 0;
        int dangerousObjectCount = 0;

        while (sensorDistanceReading >= 0) {
            sensorReadingCount++;
            sensorDistanceSum += sensorDistanceReading;

            if (sensorDistanceReading <= 100) {
                dangerousObjectCount++;
            }

            sensorDistanceReading = console.nextInt();
        }

        System.out.println("Sensor readings: "   + sensorReadingCount);
        System.out.println("Sensor sum: "        + sensorDistanceSum);
        System.out.println("Dangerous objects: " + dangerousObjectCount);

        boolean isTargetFound = false;

        for (int checkpointNumber = 1; checkpointNumber <= checkpointCount; checkpointNumber++) {
            if (checkpointNumber % 4 == 0) {
                System.out.println("Checkpoint " + checkpointNumber + ": RESTRICTED");
                continue;
            }

            System.out.println("Checkpoint " + checkpointNumber + ": scanning");

            if (checkpointNumber == targetCheckpointNumber) {
                isTargetFound = true;
                System.out.println("TARGET FOUND AT CHECKPOINT " + checkpointNumber);
                break;
            }
        }

        String targetSearchStatus = isTargetFound ? "FOUND" : "NOT FOUND";

        System.out.println("Search status: " + targetSearchStatus);

        for (int mapRowIndex = 0; mapRowIndex < mapSideLength; mapRowIndex++) {
            for (int mapColumnIndex = 0; mapColumnIndex < mapSideLength; mapColumnIndex++) {

                if (mapRowIndex == beaconRowIndex && mapColumnIndex == beaconColumnIndex) {
                    System.out.print("B");
                } else {
                    System.out.print(".");
                }
            }

            System.out.println();
        }

        System.out.println("Mission: "           + missionName);
        System.out.println("Battery: "           + batteryLevelPercent      + "%");
        System.out.println("Sensor readings: "   + sensorReadingCount);
        System.out.println("Dangerous objects: " + dangerousObjectCount);
        System.out.println("Target checkpoint: " + targetCheckpointNumber);
        System.out.println("Search status: "     + targetSearchStatus);
        System.out.println("Map size: "          + mapSideLength            + "x" + mapSideLength);

        console.close();
    }
}
