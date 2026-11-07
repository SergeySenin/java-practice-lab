package org.study.javarush.java.core.level23.tasks23.b.temp2;

public class Solution433 {
    public static void main(String[] args) {

        Book libraryBook = null;

        System.out.println(libraryBook.getTitle());
    }
}

class Book {
    public String getTitle() {
        return "Пример книги";
    }
}
