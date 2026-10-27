package org.study.javarush.java.core.level12.tasks12.g;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void printProductList(ArrayList<String> productNames) {
        for (int productIndex = 0; productIndex < productNames.size(); productIndex++) {
            System.out.println(productIndex + ": " + productNames.get(productIndex));
        }
    }

    public static int calculateTotalStock(ArrayList<String> productNames,
                                          HashMap<String, Integer> stockByProductName) {
        int totalStock = 0;

        for (String productName : productNames) {
            Integer stockCount = stockByProductName.get(productName);
            totalStock += stockCount;
        }

        return totalStock;
    }

    public static void printStockEntries(HashMap<String, Integer> stockByProductName) {
        for (Map.Entry<String, Integer> stockEntry : stockByProductName.entrySet()) {
            System.out.println(String.format(
                    "Product: %-20s Stock: %d",
                    stockEntry.getKey()  + ",",
                    stockEntry.getValue()
            ));
        }
    }

    public static String buildCatalogText(
            ArrayList<String> productNames,
            HashMap<String, Integer> stockByProductName
    ) {
        StringBuilder catalogBuilder = new StringBuilder();
        catalogBuilder.append("MARKETPLACE CATALOG\n");

        for (String productName : productNames) {
            Integer stockCount  = stockByProductName.get(productName);
            catalogBuilder.append(String.format("%-20s %d\n", productName + ";", stockCount));
        }

        catalogBuilder.append("PRODUCT COUNT:       ")
                .append(productNames.size())
                .append("\n");

        catalogBuilder.append("TOTAL STOCK:         ")
                .append(calculateTotalStock(productNames, stockByProductName))
                .append("\n");

        return catalogBuilder.toString();
    }

    public static String extractJsonTextField(String jsonText, String fieldName) {
        String fieldMarker = "\"" + fieldName + "\"";
        int    fieldIndex  = jsonText.indexOf(fieldMarker);

        if (fieldIndex == -1) {
            return null;
        }

        int colonIndex      = jsonText.indexOf(':', fieldIndex + fieldMarker.length());
        int valueStartIndex = jsonText.indexOf('"', colonIndex + 1) + 1;
        int valueEndIndex   = jsonText.indexOf('"', valueStartIndex);

        return jsonText.substring(valueStartIndex, valueEndIndex);
    }

    public static void main(String[] args) {

        ArrayList<String> productNames = new ArrayList<>();
        productNames.add("Mechanical Keyboard");
        productNames.add("Wireless Mouse");
        productNames.add("USB Hub");

        System.out.println("Initial product count: " + productNames.size());

        productNames.add("Webcam");

        String originalMouseName = productNames.get(1);
        productNames.set(1, "Gaming Mouse");
        productNames.remove(2);

        boolean hasGamingMouse = productNames.contains("Gaming Mouse");
        boolean hasUsbHub      = productNames.contains("USB Hub");

        printProductList(productNames);

        for (String productName : productNames) {
            System.out.println(productName);
        }

        HashMap<String, Integer> stockByProductName = new HashMap<>();

        stockByProductName.put("Mechanical Keyboard", 12);
        stockByProductName.put("Gaming Mouse"       , 7 );
        stockByProductName.put("Webcam"             , 5 );
        stockByProductName.put("USB Hub"            , 2 );

        stockByProductName.put("Gaming Mouse"       , 8 );
        stockByProductName.remove("USB Hub");

        boolean hasMouseStock       = stockByProductName.containsKey("Gaming Mouse");
        boolean hasUsbHubStock      = stockByProductName.containsKey("USB Hub");
        Integer removedProductStock = stockByProductName.get("USB Hub");

        System.out.println("Gaming Mouse stock:  " + stockByProductName.get("Gaming Mouse"));
        System.out.println("hasMouseStock:       " + hasMouseStock);
        System.out.println("hasUsbHubStock:      " + hasUsbHubStock);
        System.out.println("removedProductStock: " + removedProductStock);

        int totalStock = calculateTotalStock(productNames, stockByProductName);

        System.out.println("Total stock:         " + totalStock);

        printStockEntries(stockByProductName);

        String   searchLog   = "mouse keyboard mouse webcam mouse";
        String[] searchWords = searchLog.split(" ");

        HashMap<String, Integer> searchFrequency = new HashMap<>();

        for (String searchWord : searchWords) {
            Integer previousCount = searchFrequency.get(searchWord);

            if (previousCount == null) {
                searchFrequency.put(searchWord, 1);
            } else {
                searchFrequency.put(searchWord, previousCount + 1);
            }
        }

        System.out.println("mouse:    " + searchFrequency.get("mouse"));
        System.out.println("keyboard: " + searchFrequency.get("keyboard"));
        System.out.println("webcam:   " + searchFrequency.get("webcam"));

        Scanner console               = new Scanner(System.in);
        ArrayList<String> reviewTasks = new ArrayList<>();

        String reviewTask;

        while (!(reviewTask = console.nextLine()).isEmpty()) {
            reviewTasks.add(reviewTask);
        }

        for (int taskIndex = reviewTasks.size() - 1; taskIndex >= 0; taskIndex--) {
            System.out.println((taskIndex + 1) + ": " + reviewTasks.get(taskIndex));
        }

        Path outputDirectory = Path.of("src/main/resources/generated/javarush/level12/advanced12");
        Path catalogPath     = outputDirectory.resolve("catalog.txt");
        String catalogText   = buildCatalogText(productNames, stockByProductName);

        try {
            Files.createDirectories(outputDirectory);
            Files.writeString(catalogPath, catalogText, StandardCharsets.UTF_8);

            String savedCatalogText = Files.readString(catalogPath, StandardCharsets.UTF_8);

            boolean isCatalogTextMatching = catalogText.equals(savedCatalogText);
            boolean catalogFileExists     = Files.exists(catalogPath);
            long    catalogFileSize       = Files.size(catalogPath);

            System.out.println("Catalog file exists:   " + catalogFileExists);
            System.out.println("Catalog text matches:  " + isCatalogTextMatching);
            System.out.println("Catalog file size:     " + catalogFileSize + " bytes");

            byte[] catalogSignatureBytes = {77, 75, 84, 49};
            Path   signaturePath         = outputDirectory.resolve("catalog_signature.bin");

            Files.write(signaturePath, catalogSignatureBytes);

            byte[] savedSignatureBytes = Files.readAllBytes(signaturePath);

            String signatureSeparator = "";

            for (byte signatureByte : savedSignatureBytes) {
                System.out.print(signatureSeparator + (char) signatureByte);
                signatureSeparator = " ";
            }

            System.out.println();

            Path backupPath = outputDirectory.resolve("catalog_signature_backup.bin");

            byte[] sourceSignatureBytes = Files.readAllBytes(signaturePath);
            Files.write(backupPath, sourceSignatureBytes);

            byte[] backupSignatureBytes = Files.readAllBytes(backupPath);

            boolean isBackupMatching = Arrays.equals(
                    sourceSignatureBytes,
                    backupSignatureBytes
            );

            System.out.println("Binary backup matches: " + isBackupMatching);

            long backupFileSize = Files.size(backupPath);

        } catch (IOException exception) {
            System.out.println("Local file operation failed: " + exception.getMessage());
        }

        String supplierResponseText = "{\"product\":\"Gaming Mouse\",\"stock\":\"8\"}";

        String supplierProduct = extractJsonTextField(supplierResponseText, "product");
        String supplierStock   = extractJsonTextField(supplierResponseText, "stock");

        System.out.println("Supplier product: " + supplierProduct);
        System.out.println("Supplier stock:   " + supplierStock);
    }
}
