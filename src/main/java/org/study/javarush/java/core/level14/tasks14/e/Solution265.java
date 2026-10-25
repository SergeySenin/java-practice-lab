package org.study.javarush.java.core.level14.tasks14.e;

public class Solution265 {
    public static void main(String[] args) {

        User firstUser = new User();
        User secondUser = new User("Алиса");

        System.out.println("Имя: " + firstUser.userName + ", возраст: " + firstUser.userAge);

        System.out.println("Имя: " + secondUser.userName + ", возраст: " + secondUser.userAge);
    }
}
