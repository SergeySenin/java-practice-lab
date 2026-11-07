package org.study.javarush.java.core.level23.tasks23.d.temp2;

public class Solution441 {
    public static void main(String[] args) {

        Product product = new Product();
        product.setPrice(49.99);

        System.out.println(product.getPrice());
    }
}

class Product {
    private double productPrice;

    public double getPrice() {
        return productPrice;
    }

    public void setPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
