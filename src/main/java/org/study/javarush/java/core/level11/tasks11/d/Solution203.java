package org.study.javarush.java.core.level11.tasks11.d;

public class Solution203 {
    public static void main(String[] args) {

        try {
            validateUserName("");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void validateUserName(String userName) {

        try {
            if (userName.isEmpty()) {
                throw new IllegalArgumentException("Регистрация отклонена: Имя пользователя не может быть пустым.");
            }
        } finally {
            System.out.println("Проверка имени пользователя завершена.");
        }
    }
}
