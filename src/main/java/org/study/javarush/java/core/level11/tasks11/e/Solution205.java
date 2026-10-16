package org.study.javarush.java.core.level11.tasks11.e;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution205 {
    public static void main(String[] args) {

        try {
            analyzeSystemLog("non_existent_log.txt");
        } catch (IOException exception) {
            System.out.println(
                    "Произошла ошибка при попытке прочитать файл системных логов. Ошибка чтения файла."
            );
        }
    }

    public static void analyzeSystemLog(String logFileName) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logFileName))) {
            bufferedReader.readLine();
        }
    }
}
