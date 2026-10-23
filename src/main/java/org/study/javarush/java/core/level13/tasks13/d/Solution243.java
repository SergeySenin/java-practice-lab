package org.study.javarush.java.core.level13.tasks13.d;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution243 {
    public static void main(String[] args) {

        LocalDateTime eventDateTime = LocalDateTime.of(2025, 6, 1, 12, 0);

        ZonedDateTime originalEventTime = eventDateTime.atZone(
                ZoneId.of("Europe/London")
        );

        Instant universalInstant = originalEventTime.toInstant();

        ZonedDateTime eventTimeTokyoZoned = universalInstant.atZone(
                ZoneId.of("Asia/Tokyo")
        );

        System.out.println(originalEventTime);
        System.out.println(universalInstant);
        System.out.println(eventTimeTokyoZoned);
    }
}
