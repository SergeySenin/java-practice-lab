package org.study.javarush.java.core.level12.tasks12.d;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution220 {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of(
                "src/main/resources/generated/javarush/level12/short", "note.txt"
        );

        String noteText = "Сегодня отличный день!";

        Files.createDirectories(filePath.getParent());
        Files.writeString(filePath, noteText, StandardCharsets.UTF_8);
    }
}
