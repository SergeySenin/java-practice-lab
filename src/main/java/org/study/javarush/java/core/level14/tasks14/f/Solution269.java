package org.study.javarush.java.core.level14.tasks14.f;

public class Solution269 {
    public static void main(String[] args) {

        Book standardBook = new Book();

        System.out.println(standardBook.bookTitle);
        System.out.println(standardBook.pageCount);
    }
}

class Book {
    String bookTitle = "Без названия";
    int pageCount = 100;
}
