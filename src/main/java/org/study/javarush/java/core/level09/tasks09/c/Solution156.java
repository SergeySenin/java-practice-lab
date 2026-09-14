package org.study.javarush.java.core.level09.tasks09.c;

public class Solution156 {
    public static void main(String[] args) {

        String userName = "Анна";
        int userAge = 25;

        String userInfo = String.format(
                "Имя: %s, возраст: %d лет.",
                userName, userAge
        );

        System.out.println(userInfo);
    }
}
