package org.study.javarush.java.core.level07.tasks07.b;

public class Solution115 {
    public static void main(String[] args) {

        int[] roundScores = new int[10];

        for (int roundIndex = 0; roundIndex < roundScores.length; roundIndex++) {
            roundScores[roundIndex] = roundIndex + 1;

            if (roundIndex > 0) {
                System.out.print(" ");
            }

            System.out.print(roundScores[roundIndex]);
        }
    }
}
