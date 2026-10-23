package org.study.javarush.java.core.level13.tasks13.b;

import java.time.LocalDate;

public class Solution233 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate yesterday = today.minusDays(1);

        System.out.println(yesterday);
    }
}
