package org.study.javarush.java.core.level12.tasks12.e;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution224 {
    public static void main(String[] args) throws IOException {

        URL imageUrl = new URL("https://httpbin.org/image/png");
        Path filePath = Path.of(
                "src/main/resources/generated/javarush/level12/short", "image01.png"
        );

        Files.createDirectories(filePath.getParent());

        try (InputStream inputStream = imageUrl.openStream()) {
            Files.copy(inputStream, filePath);
        }
    }
}
