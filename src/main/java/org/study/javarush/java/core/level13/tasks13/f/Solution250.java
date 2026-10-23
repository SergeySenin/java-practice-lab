package org.study.javarush.java.core.level13.tasks13.f;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution250 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate projectDeadline = LocalDate.of(2025, 5, 15);

        long daysRemaining = ChronoUnit.DAYS.between(today, projectDeadline);

        System.out.println(daysRemaining);
    }
}
