package org.study.javarush.java.core.level12.tasks12.e;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution227 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create("https://httpbin.org/image/png");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<byte[]> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofByteArray()
        );

        String contentType = response.headers()
                .firstValue("Content-Type")
                .orElse("неизвестно");

        byte[] responseBytes = response.body();
        int imageSize = responseBytes.length;

        System.out.println("Тип: " + contentType + ", Размер: " + imageSize + " байт");

        Path filePath = Path.of(
                "src/main/resources/generated/javarush/level12/short", "image04.png"
        );
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, responseBytes);
    }
}
