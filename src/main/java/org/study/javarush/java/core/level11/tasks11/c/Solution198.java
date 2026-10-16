package org.study.javarush.java.core.level11.tasks11.c;

public class Solution198 {
    public static void main(String[] args) {

        int totalScore = 50;
        int numberOfPlayers = 0;

        try {
            System.out.println(totalScore / numberOfPlayers);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
