package org.study.javarush.java.core.level13.tasks13.d;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution242 {
    public static void main(String[] args) {

        LocalDateTime teleportScheduledLocal = LocalDateTime.of(2025, 6, 1, 18, 0);

        ZoneId londonZone = ZoneId.of("Europe/London");

        ZonedDateTime teleportTimeLondonZoned = teleportScheduledLocal.atZone(londonZone);

        ZonedDateTime teleportTimeNewYorkZoned = teleportTimeLondonZoned.withZoneSameInstant(
                ZoneId.of("America/New_York")
        );

        System.out.println(teleportTimeLondonZoned);
        System.out.println(teleportTimeNewYorkZoned);
    }
}
