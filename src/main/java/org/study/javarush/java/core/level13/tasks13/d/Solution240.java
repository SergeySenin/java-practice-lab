package org.study.javarush.java.core.level13.tasks13.d;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution240 {
    public static void main(String[] args) {

        ZonedDateTime currentTimeInLondon = ZonedDateTime.now(ZoneId.of("Europe/London"));
        ZonedDateTime currentTimeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime currentTimeInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        System.out.println("Лондон: " + currentTimeInLondon);
        System.out.println("Нью-Йорк: " + currentTimeInNewYork);
        System.out.println("Токио: " + currentTimeInTokyo);
    }
}
