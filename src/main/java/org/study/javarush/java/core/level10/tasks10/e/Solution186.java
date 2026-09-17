package org.study.javarush.java.core.level10.tasks10.e;

public class Solution186 {
    public static void main(String[] args) {

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
    }
}

enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
