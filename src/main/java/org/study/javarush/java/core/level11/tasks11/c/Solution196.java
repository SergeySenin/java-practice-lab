package org.study.javarush.java.core.level11.tasks11.c;

public class Solution196 {
    public static void main(String[] args) {

        int totalDistance = 100;
        int stepsPerUnit = 0;

        try {
            System.out.println(totalDistance / stepsPerUnit);
        } catch (ArithmeticException exception) {
            System.out.println("Робот сообщает: Деление на ноль невозможно! Пожалуйста, проверьте сенсоры.");
        }
    }
}
