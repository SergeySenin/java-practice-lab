package org.study.javarush.java.core.level15.tasks15.b;

public class Solution275 {
    public static void main(String[] args) {

        Product product = new Product(101, "Молоко");

        System.out.println("ID: " + product.getProductID());
        System.out.println("Название: " + product.getProductName());

        /*
        Прямое изменение приватных полей запрещено:
        product.productID = 102;
        product.productName = "Хлеб";

        Сеттеров также нет:
        product.setProductName("Хлеб");
        */
    }
}

class Product {
    private int productID;
    private String productName;

    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }
}
