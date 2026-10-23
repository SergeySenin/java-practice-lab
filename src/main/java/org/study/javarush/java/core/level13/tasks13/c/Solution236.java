package org.study.javarush.java.core.level13.tasks13.c;

import java.time.LocalTime;

public class Solution236 {
    public static void main(String[] args) {

        LocalTime currentTime = LocalTime.now();

        int displayHours = currentTime.getHour();
        int displayMinutes = currentTime.getMinute();
        int displaySeconds = currentTime.getSecond();

        System.out.println(
                "Часы: " + displayHours
                        + ", минуты: " + displayMinutes
                        + ", секунды: " + displaySeconds
        );
    }
}
