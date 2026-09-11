package org.study.javarush.java.core.level07.tasks07.e;

public class Solution124 {
    public static void main(String[] args) {

        int[][] playerAchievements = new int[3][];
        playerAchievements[0] = new int[2];
        playerAchievements[1] = new int[4];
        playerAchievements[2] = new int[1];
        int value = 101;
        for (int i = 0; i < playerAchievements.length; i++) {
            for (int j = 0; j < playerAchievements[i].length; j++) {
                playerAchievements[i][j] = value;
                value++;
                System.out.print(playerAchievements[i][j]);
                if (j < playerAchievements[i].length) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
