package org.study.javarush.java.core.level22.tasks22.b.temp1;

public class Solution412 {
    public static void main(String[] args) {

        Book book = new Book("Мастер и Маргарита", "Михаил Булгаков");

        System.out.println("Название: " + book.title());
        System.out.println("Автор: " + book.author());
    }
}

record Book(String title, String author) {
}
