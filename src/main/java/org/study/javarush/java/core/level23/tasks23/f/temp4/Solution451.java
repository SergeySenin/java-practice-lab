package org.study.javarush.java.core.level23.tasks23.f.temp4;

public class Solution451 {
    public static void main(String[] args) {

        Product product = new Product("Банан");

        System.out.println(product.getProductName());
    }
}

class Product {
    private static int totalProductCount;

    private String productName;

    public Product(String productName) {
        this.productName = productName;
        totalProductCount++;
    }

    public String getProductName() {
        return productName;
    }
}
