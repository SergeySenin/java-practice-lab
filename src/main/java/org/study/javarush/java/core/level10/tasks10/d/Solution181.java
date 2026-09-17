package org.study.javarush.java.core.level10.tasks10.d;

import java.util.Scanner;

public class Solution181 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String command = console.nextLine();

        switch (command) {
            case "start":
                System.out.println("Запуск!");
                break;
            case "stop":
                System.out.println("Остановка");
                break;
            case "exit":
                System.out.println("Выход");
                break;
            default:
                System.out.println("Неизвестная команда");
        }
    }
}
