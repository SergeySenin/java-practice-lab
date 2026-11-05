package org.study.javarush.java.core.level22.tasks22.f.temp3;

public class Solution430 {
    public static void main(String[] args) {

        Document document = new Document("Содержимое документа");

        document.print();
    }
}

interface Printable {
    void print();
}

record Document(String content) implements Printable {
    @Override
    public void print() {
        System.out.println("Документ: " + content);
    }
}
