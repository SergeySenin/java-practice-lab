package org.study.javarush.java.core.level08.tasks08.d;

public class Solution143 {
    public static void main(String[] args) {

        int[] currentGrades = {5, 4, 3, 5, 4};

        int finalTotalPoints = calculateTotalGrades(currentGrades);

        System.out.println("Сумма всех оценок: " + finalTotalPoints);
    }

    public static int calculateTotalGrades(int[] studentExamResults) {
        int totalPoints = 0;

        for (int examResult : studentExamResults) {
            totalPoints += examResult;
        }

        return totalPoints;
    }
}
