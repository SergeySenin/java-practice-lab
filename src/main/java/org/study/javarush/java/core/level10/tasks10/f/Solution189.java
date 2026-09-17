package org.study.javarush.java.core.level10.tasks10.f;

public class Solution189 {
    public static void main(String[] args) {

        String droneCommand = "pause";

        String droneStatusMessage = switch (droneCommand) {
            case "start" -> "Запуск!";
            case "stop"  -> "Остановка!";
            case "pause" -> "Пауза...";
            default      -> "Неизвестная команда";
        };

        System.out.println(droneStatusMessage);
    }
}
