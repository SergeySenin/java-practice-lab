package org.study.javarush.java.core.level12.tasks12.d;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution222 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("letters.bin");

        byte[] originalBytes = {72, 73, 74};

        Files.write(filePath, originalBytes);

        byte[] restoredBytes = Files.readAllBytes(filePath);

        for (int index = 0; index < restoredBytes.length; index++) {
            if (index > 0) {
                System.out.print(" ");
            }

            System.out.print((char) restoredBytes[index]);
        }

        System.out.println();
    }
}
