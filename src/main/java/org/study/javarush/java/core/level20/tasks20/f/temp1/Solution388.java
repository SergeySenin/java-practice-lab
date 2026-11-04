package org.study.javarush.java.core.level20.tasks20.f.temp1;

public class Solution388 {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();

        consoleLogger.log("Тестовое сообщение");
        fileLogger.log("Тестовое сообщение");
    }
}

interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Лог записан в файл: " + message);
    }
}
