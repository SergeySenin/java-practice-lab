package org.study.javarush.java.core.level12.tasks12.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class RemoteContentDemo {

    public static void downloadPngWithUrl() throws IOException {
        URL  sourceUrl  = URI.create("https://httpbin.org/image/png").toURL();
        Path targetPath = Path.of("product_preview.png");

        try (InputStream inputStream = sourceUrl.openStream()) {
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }

        System.out.println("PNG download completed: product_preview.png");
    }

    public static void downloadJpegWithTransfer() throws IOException {
        URL  sourceUrl  = URI.create("https://httpbin.org/image/jpeg").toURL();
        Path targetPath = Path.of("product_gallery.jpg");

        try (InputStream inputStream = sourceUrl.openStream();
             OutputStream outputStream = Files.newOutputStream(targetPath)) {

            inputStream.transferTo(outputStream);
        }

        System.out.println("JPEG download completed: product_gallery.jpg");
    }

    public static void downloadWebpWithHttpClient()
            throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/image/webp"))
                .GET()
                .build();

        HttpResponse<byte[]> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofByteArray()
        );

        int httpStatusCode = response.statusCode();

        if (httpStatusCode != 200) {
            System.out.println("WebP download failed: HTTP " + httpStatusCode);
            return;
        }

        String contentType = response.headers()
                .firstValue("Content-Type")
                .orElse("unknown");

        System.out.println("Content type: " + contentType);

        byte[] responseBytes       = response.body();
        int    downloadedByteCount = responseBytes.length;

        System.out.println("Downloaded bytes: " + downloadedByteCount);

        if (contentType.startsWith("image/")) {
            Path targetPath = Path.of("product_optimized.webp");

            Files.write(targetPath, responseBytes);

            System.out.println("WebP download completed: product_optimized.webp");
        } else {
            System.out.println("WebP download failed: content type is not image.");
        }
    }

    public static void inspectSampleApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/json"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        int httpStatusCode = response.statusCode();

        printApiResponse(httpStatusCode, response.body());
    }

    public static void printApiResponse(int httpStatusCode, String responseBody) {
        switch (httpStatusCode) {
            case 200:
                System.out.println(responseBody);
                break;

            case 404:
                System.out.println("API resource not found.");
                break;

            case 429:
                System.out.println("API rate limit exceeded.");
                break;

            default:
                System.out.println("API error: " + httpStatusCode);
        }
    }

    public static void main(String[] args) {
        try {
            downloadPngWithUrl();

        } catch (IOException exception) {
            System.out.println("Network operation failed: downloadPngWithUrl: "
                    + exception.getMessage());
        }

        try {
            downloadJpegWithTransfer();

        } catch (IOException exception) {
            System.out.println("Network operation failed: downloadJpegWithTransfer: "
                    + exception.getMessage());
        }

        try {
            downloadWebpWithHttpClient();

        } catch (IOException exception) {
            System.out.println("Network operation failed: downloadWebpWithHttpClient: "
                    + exception.getMessage());

        } catch (InterruptedException exception) {
            System.out.println("Network operation interrupted: downloadWebpWithHttpClient");
            Thread.currentThread().interrupt();
            return;
        }

        try {
            inspectSampleApi();

        } catch (IOException exception) {
            System.out.println("Network operation failed: inspectSampleApi: "
                    + exception.getMessage());

        } catch (InterruptedException exception) {
            System.out.println("Network operation interrupted: inspectSampleApi");
            Thread.currentThread().interrupt();
            return;
        }
    }
}
