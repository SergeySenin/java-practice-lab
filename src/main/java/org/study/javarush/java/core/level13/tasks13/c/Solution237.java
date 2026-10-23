package org.study.javarush.java.core.level13.tasks13.c;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Solution237 {
    public static void main(String[] args) {

        LocalDate userBirthDate = LocalDate.of(1990, 12, 15);

        DayOfWeek dayOfWeek = userBirthDate.getDayOfWeek();

        System.out.println(dayOfWeek);
    }
}
