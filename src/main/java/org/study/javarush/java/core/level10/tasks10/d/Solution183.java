package org.study.javarush.java.core.level10.tasks10.d;

import java.util.Scanner;

public class Solution183 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int firstNumber = console.nextInt();
        int secondNumber = console.nextInt();
        char operation = console.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            case '/':
                System.out.println(firstNumber / secondNumber);
                break;
            default:
                System.out.println("Неизвестная операция");
        }
    }
}
