package org.study.javarush.java.core.level13.tasks13.d;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution241 {
    public static void main(String[] args) {

        LocalDateTime conferenceStartLocal = LocalDateTime.of(2025, 6, 1, 14, 0);

        ZonedDateTime conferenceStartLondonZoned = conferenceStartLocal.atZone(
                ZoneId.of("Europe/London")
        );

        System.out.println(conferenceStartLondonZoned);
    }
}
