package org.study.javarush.java.core.level22.tasks22.d.temp1;

public class Solution420 {
    public static void main(String[] args) {

        Book book = new Book("Чистый код", "Роберт Мартин");

        System.out.println(book);
    }
}

record Book(String title, String author) {
}
