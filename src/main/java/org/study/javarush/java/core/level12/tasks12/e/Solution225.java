package org.study.javarush.java.core.level12.tasks12.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution225 {
    public static void main(String[] args) throws IOException {

        URL imageUrl = new URL("https://httpbin.org/image/jpeg");
        Path filePath = Path.of("image02.jpg");

        try (
                InputStream inputStream = imageUrl.openStream();
                OutputStream outputStream = Files.newOutputStream(filePath)
        ) {
            inputStream.transferTo(outputStream);
        }
    }
}
