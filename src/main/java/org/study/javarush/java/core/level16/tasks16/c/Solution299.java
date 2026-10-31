package org.study.javarush.java.core.level16.tasks16.c;

public class Solution299 {
    public static void main(String[] args) {

        // Способ 1: цепочка вызовов
        Book book = new Book.Builder()
                .setTitle("Java Basics")
                .setPages(500)
                .build();

        // Способ 2: отдельные вызовы
        // Book.Builder builder = new Book.Builder();
        // builder.setTitle("Java Basics");
        // builder.setPages(500);
        // Book book = builder.build();

        System.out.println("Book: " + book.getBookTitle() + ", " + book.getPageCount() + " pages.");
    }
}

class Book {
    private String bookTitle;
    private int pageCount;

    private Book(Builder builder) {
        this.bookTitle = builder.bookTitle;
        this.pageCount = builder.pageCount;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getPageCount() {
        return pageCount;
    }

    public static class Builder {
        private String bookTitle;
        private int pageCount;

        public Builder setTitle(String title) {
            this.bookTitle = title;
            return this;
        }

        public Builder setPages(int pages) {
            this.pageCount = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
