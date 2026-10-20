package org.study.javarush.java.core.level11.tasks11.e;

import java.io.FileReader;
import java.io.IOException;

public class Solution204 {
    public static void main(String[] args) {

    }

    public static void accessSecretDocument(String documentPath) throws IOException {

        try (FileReader fileReader = new FileReader(documentPath)) {
            // Документ открыт. При выходе из блока поток автоматически закроется.
        }
    }
}
