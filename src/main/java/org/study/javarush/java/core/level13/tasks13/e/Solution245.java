package org.study.javarush.java.core.level13.tasks13.e;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution245 {
    public static void main(String[] args) {

        String inputDateString = "2024-12-31";

        LocalDate parsedLocalDate = LocalDate.parse(
                inputDateString,
                DateTimeFormatter.ISO_LOCAL_DATE
        );

        System.out.println(parsedLocalDate);
    }
}
