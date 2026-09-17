package org.study.javarush.java.core.level10.tasks10.f;

public class Solution188 {
    public static void main(String[] args) {

        int httpStatusCode = 200;

        String responseMessage = switch (httpStatusCode) {
            case 200      -> "OK";
            case 400, 404 -> "Ошибка клиента";
            case 500      -> "Ошибка сервера";
            default       -> "Неизвестный код";
        };

        System.out.println(responseMessage);
    }
}
