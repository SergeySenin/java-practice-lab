package org.study.javarush.java.core.level12.tasks12.d;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution223 {
    public static void main(String[] args) throws IOException {

        Path sourceFilePath = Path.of(
                "src/main/resources/generated/javarush/level12/short", "letters.bin"
        );
        Path targetFilePath = Path.of(
                "src/main/resources/generated/javarush/level12/short", "letters_copy.bin"
        );

        byte[] fileBytes = Files.readAllBytes(sourceFilePath);

        Files.createDirectories(targetFilePath.getParent());
        Files.write(targetFilePath, fileBytes);
    }
}
