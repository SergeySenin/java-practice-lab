package org.study.javarush.java.core.level10.tasks10.d;

import java.util.Scanner;

public class Solution182 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int month = console.nextInt();

        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Некорректный номер месяца");
        }
    }
}
