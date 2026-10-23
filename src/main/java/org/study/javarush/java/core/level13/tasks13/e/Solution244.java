package org.study.javarush.java.core.level13.tasks13.e;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution244 {
    public static void main(String[] args) {

        LocalDate currentReportDate = LocalDate.now();

        String formattedReportDate = currentReportDate.format(
                DateTimeFormatter.ISO_LOCAL_DATE
        );

        System.out.println(formattedReportDate);
    }
}
