package org.study.javarush.java.core.level06.tasks06.f;

public class Solution111 {
    public static void main(String[] args) {

        int quizScore = 4;
        double projectScore = 2.7;

        double exactCourseAverage = (quizScore + projectScore) / 2;
        int roundedCourseAverage = (int) exactCourseAverage;

        System.out.println(exactCourseAverage);
        System.out.println(roundedCourseAverage);
    }
}
