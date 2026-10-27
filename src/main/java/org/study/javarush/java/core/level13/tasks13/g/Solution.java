package org.study.javarush.java.core.level13.tasks13.g;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Solution {

    public static LocalDateTime parseReleaseStart(
            String releaseStartInput,
            DateTimeFormatter dateTimeFormatter
    ) {
        return LocalDateTime.parse(releaseStartInput, dateTimeFormatter);
    }

    public static LocalDate parsePlanningStart(
            String planningStartInput,
            DateTimeFormatter dateFormatter
    ) {
        return LocalDate.parse(planningStartInput, dateFormatter);
    }

    public static LocalDateTime calculateAdjustedReleaseStart(
            LocalDateTime originalReleaseStart
    ) {
        LocalDateTime adjustedReleaseStart = originalReleaseStart
                .plusHours(2)
                .minusMinutes(30);
        return adjustedReleaseStart;
    }

    public static ZonedDateTime attachTimeZone(
            LocalDateTime localDateTime,
            ZoneId zoneId
    ) {
        return localDateTime.atZone(zoneId);
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String  releaseStartInput  = console.nextLine();
        String  planningStartInput = console.nextLine();
        releaseStartInput  = releaseStartInput.trim();
        planningStartInput = planningStartInput.trim();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("dd.MM.uuuu HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("dd.MM.uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDateTime originalReleaseStart;
        LocalDate     planningStartDate;

        try {
            originalReleaseStart = parseReleaseStart(
                    releaseStartInput,
                    dateTimeFormatter
            );
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid release date-time: " + releaseStartInput);
            return;
        }

        try {
            planningStartDate = parsePlanningStart(
                    planningStartInput,
                    dateFormatter
            );
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid planning date: " + planningStartInput);
            return;
        }

        LocalDate releaseDate           = originalReleaseStart.toLocalDate();
        LocalTime originalReleaseTime   = originalReleaseStart.toLocalTime();
        int       releaseYear           = releaseDate.getYear();
        int       releaseMonth          = releaseDate.getMonthValue();
        int       releaseDay            = releaseDate.getDayOfMonth();
        DayOfWeek releaseDayOfWeek      = releaseDate.getDayOfWeek();
        int       originalReleaseHour   = originalReleaseTime.getHour();
        int       originalReleaseMinute = originalReleaseTime.getMinute();

        LocalDateTime adjustedReleaseStart =
                calculateAdjustedReleaseStart(originalReleaseStart);

        LocalTime workingDayStart     = LocalTime.of(9, 0);
        LocalTime workingDayEnd       = LocalTime.of(18, 0);
        LocalTime adjustedReleaseTime = adjustedReleaseStart.toLocalTime();

        boolean isStartWithinWorkingHours =
                !adjustedReleaseTime.isBefore(workingDayStart)
                        && !adjustedReleaseTime.isAfter(workingDayEnd);

        ZoneId londonZone  = ZoneId.of("Europe/London");
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZoneId tokyoZone   = ZoneId.of("Asia/Tokyo");

        ZonedDateTime originalReleaseLondon = attachTimeZone(originalReleaseStart, londonZone);
        ZonedDateTime adjustedReleaseLondon = attachTimeZone(adjustedReleaseStart, londonZone);

        Instant releaseStartInstant = adjustedReleaseLondon.toInstant();

        ZonedDateTime releaseStartNewYork = adjustedReleaseLondon.withZoneSameInstant(newYorkZone);
        ZonedDateTime releaseStartTokyo   = adjustedReleaseLondon.withZoneSameInstant(tokyoZone);

        boolean isSameInstantInNewYork = adjustedReleaseLondon.isEqual(releaseStartNewYork);

        Duration      releaseDuration   = Duration.ofMinutes(75);
        ZonedDateTime releaseEndLondon  = adjustedReleaseLondon.plus(releaseDuration);
        Instant       releaseEndInstant = releaseEndLondon.toInstant();

        ZonedDateTime releaseEndNewYork = releaseEndLondon.withZoneSameInstant(newYorkZone);
        ZonedDateTime releaseEndTokyo   = releaseEndLondon.withZoneSameInstant(tokyoZone);

        LocalTime releaseEndTime = releaseEndLondon.toLocalTime();

        boolean isEndWithinWorkingHours =
                !releaseEndTime.isBefore(workingDayStart)
                        && !releaseEndTime.isAfter(workingDayEnd);

        Duration scheduleShiftDuration
                = Duration.between(
                        originalReleaseLondon.toInstant(), releaseStartInstant
        );
        long scheduleShiftMinutes
                = scheduleShiftDuration.toMinutes();

        long releaseDurationMinutes
                = Duration.between(
                        releaseStartInstant, releaseEndInstant
        ).toMinutes();

        boolean isReleaseEndAfterStart = releaseEndInstant.isAfter(releaseStartInstant);

        LocalDate codeFreezeDate          = releaseDate.minusDays(3);
        long      freezeDaysBeforeRelease = ChronoUnit.DAYS.between(codeFreezeDate, releaseDate);
        long      planningDurationDays    = ChronoUnit.DAYS.between(planningStartDate, releaseDate);

        Period planningPeriod = Period.between(planningStartDate, releaseDate);
        int    planningYears  = planningPeriod.getYears();
        int    planningMonths = planningPeriod.getMonths();
        int    planningDays   = planningPeriod.getDays();

        String releaseDateIsoText         = releaseDate          .format(DateTimeFormatter.ISO_LOCAL_DATE);
        String planningStartDisplayText   = planningStartDate    .format(dateFormatter);
        String originalReleaseDisplayText = originalReleaseStart .format(dateTimeFormatter);
        String londonStartDisplayText     = adjustedReleaseLondon.format(dateTimeFormatter);
        String newYorkStartDisplayText    = releaseStartNewYork  .format(dateTimeFormatter);
        String tokyoStartDisplayText      = releaseStartTokyo    .format(dateTimeFormatter);
        String londonEndDisplayText       = releaseEndLondon     .format(dateTimeFormatter);
        String tokyoEndDisplayText        = releaseEndTokyo      .format(dateTimeFormatter);
        String codeFreezeDisplayText      = codeFreezeDate       .format(dateFormatter);

        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append(
                "Planning start:             "
                )
                .append(planningStartDisplayText)
                .append('\n');

        reportBuilder.append(
                "Original start (London):    "
                )
                .append(originalReleaseDisplayText)
                .append('\n');

        reportBuilder.append(
                "Adjusted start (London):    "
                )
                .append(londonStartDisplayText)
                .append('\n');

        reportBuilder.append(
                "Release date ISO:           "
                )
                .append(releaseDateIsoText)
                .append('\n');

        reportBuilder.append(
                "Release day:                "
                )
                .append(releaseDayOfWeek)
                .append('\n');


        reportBuilder.append(
                "London start:               "
                )
                .append(londonStartDisplayText)
                .append('\n');

        reportBuilder.append(
                "New York start:             "
                )
                .append(newYorkStartDisplayText)
                .append('\n');

        reportBuilder.append(
                "Tokyo start:                "
                )
                .append(tokyoStartDisplayText)
                .append('\n');

        reportBuilder.append(
                "London end:                 "
                )
                .append(londonEndDisplayText)
                .append('\n');

        reportBuilder.append(
                "Tokyo end:                  "
                )
                .append(tokyoEndDisplayText)
                .append('\n');


        reportBuilder.append(
                "Start instant:              "
                )
                .append(releaseStartInstant)
                .append('\n');

        reportBuilder.append(
                "End instant:                "
                )
                .append(releaseEndInstant)
                .append('\n');

        reportBuilder.append(
                "Schedule shift:             "
                )
                .append(scheduleShiftMinutes)
                .append(" minutes\n");

        reportBuilder.append(
                "Release duration:           "
                )
                .append(releaseDurationMinutes)
                .append(" minutes\n");


        reportBuilder.append(
                "Code freeze:                "
                )
                .append(codeFreezeDisplayText)
                .append('\n');

        reportBuilder.append(
                "Freeze interval:            "
                )
                .append(freezeDaysBeforeRelease)
                .append(" days\n");

        reportBuilder.append(
                "Planning duration:          "
                )
                .append(planningDurationDays)
                .append(" days\n");

        reportBuilder.append(
                "Planning period:            "
                )
                .append(planningYears) .append(" years, ")
                .append(planningMonths).append(" months, ")
                .append(planningDays)  .append(" days\n");


        reportBuilder.append(
                "Start within working hours: "
                )
                .append(isStartWithinWorkingHours)
                .append('\n');

        reportBuilder.append(
                "End within working hours:   "
                )
                .append(isEndWithinWorkingHours)
                .append('\n');

        reportBuilder.append(
                "End after start:            "
                )
                .append(isReleaseEndAfterStart)
                .append('\n');

        reportBuilder.append(
                "Same instant in New York:   "
                )
                .append(isSameInstantInNewYork)
                .append('\n');

        String reportText = reportBuilder.toString();
        System.out.print(reportText);
    }
}
