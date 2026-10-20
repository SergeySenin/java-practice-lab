package org.study.javarush.java.core.level12.tasks12.e;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution226 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create("https://httpbin.org/image/webp");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<byte[]> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofByteArray()
        );

        int status = response.statusCode();

        if (status == 200) {
            Path filePath = Path.of("image03.webp");
            byte[] responseBytes = response.body();

            Files.write(filePath, responseBytes);
        } else {
            System.out.println("Ошибка загрузки: код ответа " + status);
        }
    }
}
