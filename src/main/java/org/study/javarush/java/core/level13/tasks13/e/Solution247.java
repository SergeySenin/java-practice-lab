package org.study.javarush.java.core.level13.tasks13.e;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution247 {
    public static void main(String[] args) {

        String orderTimestampString = "01.06.2025 14:30";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        LocalDateTime parsedOrderDateTime = LocalDateTime.parse(
                orderTimestampString,
                dateTimeFormatter
        );

        System.out.println(parsedOrderDateTime);
    }
}
