package org.study.javarush.java.core.level13.tasks13.f;

import java.time.LocalDate;

public class Solution248 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate holidayCountdownStart = today.plusDays(10);

        System.out.println(holidayCountdownStart);
    }
}
