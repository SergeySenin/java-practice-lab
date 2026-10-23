package org.study.javarush.java.core.level13.tasks13.b;

import java.time.LocalDate;

public class Solution234 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate tomorrow = today.plusDays(1);

        System.out.println(tomorrow);
    }
}
