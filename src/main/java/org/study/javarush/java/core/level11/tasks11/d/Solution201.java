package org.study.javarush.java.core.level11.tasks11.d;

public class Solution201 {
    public static void main(String[] args) {

        displayPositiveScore(50);

        try {
            displayPositiveScore(-5);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void displayPositiveScore(int currentScore) {
        if (currentScore <= 0) {
            throw new IllegalArgumentException("Счёт должен быть положительным.");
        }

        System.out.println(currentScore);
    }
}
