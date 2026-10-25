package org.study.javarush.java.core.level14.tasks14.e;

public class Solution264 {
    public static void main(String[] args) {

        Book firstBook = new Book("Загадочный роман");
        Book secondBook = new Book("Путешествие по космосу", 500);

        System.out.println("Название: " + firstBook.bookTitle + ", страниц: " + firstBook.pageCount);

        System.out.println("Название: " + secondBook.bookTitle + ", страниц: " + secondBook.pageCount);
    }
}

class Book {
    String bookTitle;
    int pageCount;

    Book(String bookTitle, int pageCount) {
        this.bookTitle = bookTitle;
        this.pageCount = pageCount;
    }

    Book(String bookTitle) {
        this(bookTitle, 0);
    }
}
