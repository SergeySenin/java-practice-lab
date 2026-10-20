package org.study.javarush.java.core.level12.tasks12.d;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution221 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("note.txt");

        String noteText = Files.readString(filePath);

        System.out.println(noteText);
    }
}
