package org.study.javarush.java.core.level13.tasks13.g;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class TimeDiagnostics {

    public static void main(String[] args) {

        LocalDate     currentDate     = LocalDate.now();
        LocalTime     currentTime     = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant       currentInstant  = Instant.now();

        LocalDate yesterday    = currentDate.minusDays(1);
        LocalDate tomorrow     = currentDate.plusDays(1);
        LocalDate tenDaysLater = currentDate.plusDays(10);

        int currentHour   = currentTime.getHour();
        int currentMinute = currentTime.getMinute();
        int currentSecond = currentTime.getSecond();

        System.out.println("Current date:      " + currentDate);
        System.out.println("Yesterday:         " + yesterday);
        System.out.println("Tomorrow:          " + tomorrow);
        System.out.println("Ten days later:    " + tenDaysLater);
        System.out.println("Current time:      " + currentTime);
        System.out.println("Current hour:      " + currentHour);
        System.out.println("Current minute:    " + currentMinute);
        System.out.println("Current second:    " + currentSecond);
        System.out.println("Current date-time: " + currentDateTime);
        System.out.println("Current instant:   " + currentInstant);

        ZoneId londonZone  = ZoneId.of("Europe/London");
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZoneId tokyoZone   = ZoneId.of("Asia/Tokyo");

        ZonedDateTime currentTimeInLondon  = ZonedDateTime.now(londonZone);
        ZonedDateTime currentTimeInNewYork = ZonedDateTime.now(newYorkZone);
        ZonedDateTime currentTimeInTokyo   = ZonedDateTime.now(tokyoZone);

        System.out.println("London:   " + currentTimeInLondon);
        System.out.println("New York: " + currentTimeInNewYork);
        System.out.println("Tokyo:    " + currentTimeInTokyo);

        Instant originalInstant = Instant.parse("2026-06-15T15:00:00Z");
        Date    legacyDate      = Date.from(originalInstant);
        Instant restoredInstant = legacyDate.toInstant();

        boolean isLegacyConversionPreserved = originalInstant.equals(restoredInstant);

        System.out.println("Legacy conversion preserved instant: " + isLegacyConversionPreserved);

        LocalDate leapDate     = LocalDate.of(2024, 2, 29);
        boolean   isLeapYear   = leapDate.isLeapYear();
        LocalDate oneYearLater = leapDate.plusYears(1);

        System.out.println("Leap year:          " + isLeapYear);
        System.out.println("Original leap date: " + leapDate);
        System.out.println("One year later:     " + oneYearLater);

        LocalDate localizationDate = LocalDate.of(2026, 6, 15);
        Locale    russianLocale    = Locale.forLanguageTag("ru");

        DateTimeFormatter localizedDateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", russianLocale);

        String localizedReleaseDate = localizationDate.format(localizedDateFormatter);

        System.out.println(localizedReleaseDate);
    }
}
