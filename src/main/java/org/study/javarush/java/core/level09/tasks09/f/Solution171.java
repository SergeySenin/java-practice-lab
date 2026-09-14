package org.study.javarush.java.core.level09.tasks09.f;

public class Solution171 {
    public static void main(String[] args) {

        StringBuilder messageBuilder = new StringBuilder("Я люблю Java!");

        messageBuilder.delete(2, 8);
        messageBuilder.replace(2, 6, "программирование");

        System.out.println(messageBuilder);
    }
}
