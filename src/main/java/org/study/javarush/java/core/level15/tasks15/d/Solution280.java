package org.study.javarush.java.core.level15.tasks15.d;

public class Solution280 {
    public static void main(String[] args) {

        Product product = new Product("Старый товар");

        product.setProductName("Новый товар");

        System.out.println(product.getProductName());
    }
}

class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }
}
