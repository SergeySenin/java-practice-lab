package org.study.javarush.java.core.level09.tasks09.c;

import java.util.Locale;

public class Solution159 {
    public static void main(String[] args) {

        String studentName = "Анна";
        int correctAnswers = 45;
        int totalQuestions = 50;

        double correctAnswerPercentage =
                (double) correctAnswers / totalQuestions * 100;

        String formattedResult = String.format(
                Locale.GERMANY,
                "%s: %.1f%% правильных ответов",
                studentName,
                correctAnswerPercentage
        );

        System.out.println(formattedResult);
    }
}
