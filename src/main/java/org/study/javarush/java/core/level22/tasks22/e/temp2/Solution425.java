package org.study.javarush.java.core.level22.tasks22.e.temp2;

public class Solution425 {
    public static void main(String[] args) {

        Email validEmail = new Email("user@example.com");

        System.out.println(validEmail);

        new Email("invalid-email"); // Ожидаемое исключение IllegalArgumentException.
    }
}

record Email(String address) {
    public Email {
        if (address == null || address.isEmpty() || !address.contains("@")) {
            throw new IllegalArgumentException("Некорректный адрес электронной почты: " + address);
        }
    }
}
