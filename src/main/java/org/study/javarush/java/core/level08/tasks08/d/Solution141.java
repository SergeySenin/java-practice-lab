package org.study.javarush.java.core.level08.tasks08.d;

public class Solution141 {
    public static void main(String[] args) {

        boolean isEven = checkIfEven(18);

        if (isEven) {
            System.out.println("Это число чётное!");
        } else {
            System.out.println("Это число нечётное!");
        }
    }

    public static boolean checkIfEven(int inputNumber) {
        boolean isEven = inputNumber % 2 == 0;

        return isEven;
    }
}
