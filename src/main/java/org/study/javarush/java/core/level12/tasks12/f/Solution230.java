package org.study.javarush.java.core.level12.tasks12.f;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution230 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create("https://catfact.ninja/fact");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        int status = response.statusCode();

        switch (status) {
            case 200:
                String responseBody = response.body();
                System.out.println(responseBody);
                break;
            case 404:
                System.out.println("Адрес не найден");
                break;
            case 429:
                System.out.println("Слишком много запросов");
                break;
            default:
                System.out.println("Ошибка: " + status);
        }
    }
}
