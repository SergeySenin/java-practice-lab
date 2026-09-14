package org.study.javarush.java.core.level09.tasks09.d;

public class Solution163 {
    public static void main(String[] args) {

        String productName = "Example";

        if (productName.charAt(0) == 'E') {
            String abbreviatedName = productName.substring(0, 3);
            System.out.println(abbreviatedName);
        } else {
            System.out.println("Первая буква не E");
        }
    }
}
