package org.study.javarush.java.core.level14.tasks14.d.temp4;

public class Solution263 {
    public static void main(String[] args) {

        Book firstBook = new Book();
        Book secondBook = new Book("Java для начинающих", 350);

        System.out.println("Книга: " + firstBook.getBookTitle() + ", страниц: " + firstBook.getNumberOfPages());

        System.out.println("Книга: " + secondBook.getBookTitle() + ", страниц: " + secondBook.getNumberOfPages());
    }
}
