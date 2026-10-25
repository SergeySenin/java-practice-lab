package org.study.javarush.java.core.level14.tasks14.d;

public class Book {
    private String bookTitle;
    private int numberOfPages;

    public Book() {
        this.bookTitle = "Без названия";
        this.numberOfPages = 0;
    }

    public Book(String bookTitle, int numberOfPages) {
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
