package org.study.javarush.java.core.level21.tasks21.f.temp3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution410 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Телевизор", 50000));
        products.add(new Product("Телефон", 25000));
        products.add(new Product("Ноутбук", 80000));

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product first, Product second) {
                return first.getName().compareTo(second.getName());
            }
        });

        for (Product product : products) {
            System.out.println(product);
        }
    }
}

class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
