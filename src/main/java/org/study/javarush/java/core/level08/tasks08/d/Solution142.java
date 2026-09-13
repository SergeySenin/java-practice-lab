package org.study.javarush.java.core.level08.tasks08.d;

public class Solution142 {
    public static void main(String[] args) {

        int playerOneScore = 10;
        int playerTwoScore = 25;

        int championsScore = getHigherScore(playerOneScore, playerTwoScore);

        System.out.println("Наивысший балл: " + championsScore);
    }

    public static int getHigherScore(int playerOneScore, int playerTwoScore) {
        int higherScore = playerOneScore >= playerTwoScore ? playerOneScore : playerTwoScore;

        return higherScore;
    }
}
