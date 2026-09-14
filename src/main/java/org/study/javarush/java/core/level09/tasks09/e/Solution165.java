package org.study.javarush.java.core.level09.tasks09.e;

public class Solution165 {
    public static void main(String[] args) {

        String fileName = "document.pdf";

        boolean startsWithDoc = fileName.startsWith("doc");
        boolean endsWithPdf = fileName.endsWith(".pdf");

        System.out.println(startsWithDoc + " " + endsWithPdf);
    }
}
