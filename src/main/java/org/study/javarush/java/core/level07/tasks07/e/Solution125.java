package org.study.javarush.java.core.level07.tasks07.e;

public class Solution125 {
    public static void main(String[] args) {

        String[][] guestLists = new String[3][];
        guestLists[0] = new String[2];
        guestLists[1] = new String[3];
        guestLists[2] = new String[1];

        guestLists[0][0] = "Анна";
        guestLists[0][1] = "Борис";
        guestLists[1][0] = "Сергей";
        guestLists[1][1] = "Эмилия";
        guestLists[1][2] = "Иван";
        guestLists[2][0] = "Вероника";

        for (String[] tableGuests : guestLists) {
            int guestIndex = 0;

            for (String guest : tableGuests) {
                System.out.print(guest);

                if (guestIndex < tableGuests.length - 1) {
                    System.out.print(" ");
                }

                guestIndex++;
            }

            System.out.println();
        }
    }
}
