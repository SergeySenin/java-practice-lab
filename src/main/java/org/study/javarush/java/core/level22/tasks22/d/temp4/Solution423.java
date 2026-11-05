package org.study.javarush.java.core.level22.tasks22.d.temp4;

import java.util.Objects;

public class Solution423 {
    public static void main(String[] args) {

        Product first = new Product("Ноутбук", 50000.0);
        Product second = new Product("Ноутбук", 45000.0);

        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}

record Product(String name, double price) {
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product product)) {
            return false;
        }
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
