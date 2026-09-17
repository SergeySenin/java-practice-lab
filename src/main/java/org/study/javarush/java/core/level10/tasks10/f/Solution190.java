package org.study.javarush.java.core.level10.tasks10.f;

public class Solution190 {
    public static void main(String[] args) {

        int dayNumber = 2;

        String dayNameString = switch (dayNumber) {
            case 1  -> "Понедельник";
            case 2  -> "Вторник";
            case 3  -> "Среда";
            default -> "Неизвестный день";
        };

        System.out.println(dayNameString);
    }
}
