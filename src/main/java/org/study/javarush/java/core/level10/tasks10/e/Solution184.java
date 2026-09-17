package org.study.javarush.java.core.level10.tasks10.e;

public class Solution184 {
    public static void main(String[] args) {

        TrafficSignalState trafficSignalState = TrafficSignalState.RED;
        System.out.println(trafficSignalState);
    }
}

enum TrafficSignalState {
    RED,
    YELLOW,
    GREEN
}
