package org.study.javarush.java.core.level21.tasks21.e.temp4;

public class Solution407 {
    public static void main(String[] args) {

        Logger.info("Start");
        Logger.error("Failure");
    }
}

interface Logger {
    static void info(String message) {
        System.out.println(format("INFO", message));
    }

    static void error(String message) {
        System.out.println(format("ERROR", message));
    }

    private static String format(String level, String message) {
        return "[" + level + "] " + message;
    }
}
