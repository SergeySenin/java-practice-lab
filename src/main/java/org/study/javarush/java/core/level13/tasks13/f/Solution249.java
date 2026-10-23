package org.study.javarush.java.core.level13.tasks13.f;

import java.time.LocalDate;

public class Solution249 {
    public static void main(String[] args) {

        LocalDate futureMilestone = LocalDate.of(2025, 1, 1);
        LocalDate today = LocalDate.now();

        if (!today.isBefore(futureMilestone)) {
            System.out.println("2025 уже наступил");
        } else {
            System.out.println("2025 еще не наступил");
        }
    }
}
