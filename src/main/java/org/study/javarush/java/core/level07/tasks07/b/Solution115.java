package org.study.javarush.java.core.level07.tasks07.b;

public class Solution115 {
    public static void main(String[] args) {

        int[] roundScores = new int[10];
        for (int i = 0; i < roundScores.length; i++) {
            roundScores[i] = i + 1;
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(roundScores[i]);
        }
    }
}
