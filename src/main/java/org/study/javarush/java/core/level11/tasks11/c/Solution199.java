package org.study.javarush.java.core.level11.tasks11.c;

public class Solution199 {
    public static void main(String[] args) {

        int primaryValue = 10;
        int secondaryValue = 0;

        try {
            System.out.println(primaryValue / secondaryValue);
        } catch (ArithmeticException exception) {
            System.out.println("Ошибка деления. Продолжаем работу системы.");
        }

        System.out.println("Миссия завершена. Программа завершена.");
    }
}
