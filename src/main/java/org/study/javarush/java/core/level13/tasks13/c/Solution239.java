package org.study.javarush.java.core.level13.tasks13.c;

import java.time.LocalDateTime;

public class Solution239 {
    public static void main(String[] args) {

        LocalDateTime missionBriefing = LocalDateTime.of(2025, 6, 1, 14, 0);

        LocalDateTime finalMissionTime = missionBriefing
                .plusHours(2)
                .minusMinutes(30);

        System.out.println(finalMissionTime);
    }
}
