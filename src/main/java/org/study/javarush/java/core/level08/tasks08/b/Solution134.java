package org.study.javarush.java.core.level08.tasks08.b;

public class Solution134 {
    public static void main(String[] args) { // main не в GameScore → отклонение от условия задачи

        GameScore.collectCoin();
        GameScore.collectCoin();
        GameScore.collectCoin();

        GameScore.displayCurrentScore();
    }

    public class GameScore {
        private static int totalGameScore = 0;

        public static void collectCoin() {
            totalGameScore++;
        }

        public static void displayCurrentScore() {
            System.out.println(totalGameScore);
        }
    }
}
