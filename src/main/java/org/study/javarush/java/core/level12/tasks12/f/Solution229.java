package org.study.javarush.java.core.level12.tasks12.f;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution229 {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        URI resourceUri = URI.create("http://api.open-notify.org/iss-now.json");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(resourceUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<Void> response = client.send(
                request,
                HttpResponse.BodyHandlers.discarding()
        );

        int status = response.statusCode();
        System.out.println(status);
    }
}
