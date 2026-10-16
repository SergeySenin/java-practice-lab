package org.study.javarush.java.core.level11.tasks11.e;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution206 {
    public static void main(String[] args) {

    }

    public static void extractFirstLineFromData(String dataFile)
            throws FileNotFoundException, IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile))) {
            bufferedReader.readLine();
        }
    }
}
