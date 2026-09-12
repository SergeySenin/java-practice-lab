package org.study.javarush.java.core.level07.tasks07.e;

public class Solution124 {
    public static void main(String[] args) {

        int[][] playerAchievements = new int[3][];
        playerAchievements[0] = new int[2];
        playerAchievements[1] = new int[4];
        playerAchievements[2] = new int[1];

        int achievementId = 101;

        for (int levelIndex = 0; levelIndex < playerAchievements.length; levelIndex++) {
            for (int achievementIndex = 0;
                 achievementIndex < playerAchievements[levelIndex].length;
                 achievementIndex++) {

                playerAchievements[levelIndex][achievementIndex] = achievementId;
                achievementId++;

                System.out.print(playerAchievements[levelIndex][achievementIndex]);

                if (achievementIndex < playerAchievements[levelIndex].length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
