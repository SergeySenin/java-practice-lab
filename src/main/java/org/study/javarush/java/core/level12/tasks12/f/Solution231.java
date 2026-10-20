package org.study.javarush.java.core.level12.tasks12.f;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution231 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create("http://api.open-notify.org/iss-now.json");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        String responseBody = response.body();

        String latitude = extractJsonStringValue(responseBody, "latitude");
        String longitude = extractJsonStringValue(responseBody, "longitude");

        System.out.println("Текущие координаты МКС: широта = " + latitude + ", долгота = " + longitude);
    }

    private static String extractJsonStringValue(String jsonText, String propertyName) {

        String valuePrefix = "\"" + propertyName + "\": \"";

        int valueStartIndex = jsonText.indexOf(valuePrefix) + valuePrefix.length();
        int valueEndIndex = jsonText.indexOf('"', valueStartIndex);

        return jsonText.substring(valueStartIndex, valueEndIndex);
    }
}
