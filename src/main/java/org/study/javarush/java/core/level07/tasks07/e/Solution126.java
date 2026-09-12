package org.study.javarush.java.core.level07.tasks07.e;

public class Solution126 {
    public static void main(String[] args) {

        int[][] miniGameScores = {
                {1, 2},
                {3, 4, 5},
                {6}
        };

        int totalScore = 0;

        for (int miniGameIndex = 0; miniGameIndex < miniGameScores.length; miniGameIndex++) {
            for (int scoreIndex = 0;
                 scoreIndex < miniGameScores[miniGameIndex].length;
                 scoreIndex++) {

                totalScore += miniGameScores[miniGameIndex][scoreIndex];
            }
        }

        System.out.println(totalScore);
    }
}
