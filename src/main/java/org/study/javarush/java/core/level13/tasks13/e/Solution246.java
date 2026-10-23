package org.study.javarush.java.core.level13.tasks13.e;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution246 {
    public static void main(String[] args) {

        LocalDate specificEventDate = LocalDate.of(2023, 3, 15);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String friendlyDisplayDateString = specificEventDate.format(dateFormatter);

        System.out.println(friendlyDisplayDateString);
    }
}
