package org.study.javarush.java.core.level08.tasks08.d;

public class Solution140 {
    public static void main(String[] args) {

        String greetingMessage = generateGreetingMessage("Алиса");

        System.out.println(greetingMessage);
    }

    public static String generateGreetingMessage(String recipientName) {
        String greetingMessage = "Привет, " + recipientName + "!";

        return greetingMessage;
    }
}
