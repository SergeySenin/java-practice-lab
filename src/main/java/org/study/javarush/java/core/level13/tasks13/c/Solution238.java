package org.study.javarush.java.core.level13.tasks13.c;

import java.time.LocalTime;

public class Solution238 {
    public static void main(String[] args) {

        LocalTime morningMeeting = LocalTime.of(8, 0);
        LocalTime afternoonPresentation = LocalTime.of(14, 30);

        boolean isMorningMeetingEarlier = morningMeeting.isBefore(afternoonPresentation);

        if (isMorningMeetingEarlier) {
            System.out.println("8:00 раньше 14:30");
        } else {
            System.out.println("8:00 не раньше 14:30");
        }
    }
}
