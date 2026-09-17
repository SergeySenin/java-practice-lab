package org.study.javarush.java.core.level10.tasks10.d;

import java.util.Scanner;

public class Solution180 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int day = console.nextInt();

        switch (day) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            default:
                System.out.println("Неизвестный день");
        }
    }
}
