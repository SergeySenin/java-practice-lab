package org.study.javarush.java.core.level07.tasks07.e;

public class Solution126 {
    public static void main(String[] args) {

        int[][] miniGameScores = {
                {1, 2},
                {3, 4, 5},
                {6}
        };
        int x = 0;
        for (int i = 0; i < miniGameScores.length; i++) {
            for (int j = 0; j < miniGameScores[i].length; j++) {
                x += miniGameScores[i][j];
            }
        }
        System.out.println(x);
    }
}
