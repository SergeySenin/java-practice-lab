package org.study.javarush.java.core.level12.tasks12.f;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution228 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create(
                "https://api.open-meteo.com/v1/forecast?latitude=50.45&longitude=30.52&current_weather=true"
        );

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        String responseBody = response.body();
        System.out.println(responseBody);
    }
}
