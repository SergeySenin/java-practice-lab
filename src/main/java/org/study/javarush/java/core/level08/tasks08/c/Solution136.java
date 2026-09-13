package org.study.javarush.java.core.level08.tasks08.c;

public class Solution136 {
    public static void main(String[] args) { // main не в PersonalGreeter → отклонение от условия задачи

        PersonalGreeter.welcomeNewUser("Аня");
    }

    public class PersonalGreeter {
        public static void welcomeNewUser(String userName) {
            System.out.println("Приветствуем тебя, " + userName);
        }
    }
}
