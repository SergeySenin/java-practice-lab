package org.study.javarush.java.core.level16.tasks16.e;

public class Solution307 {
    public static void main(String[] args) {

        TextAnalyzer analyzer = new TextAnalyzer();

        analyzer.generateNameReport("Anna");
    }
}

class TextAnalyzer {
    public void generateNameReport(String customerName) {
        class NameStatistics {
            private String originalCustomerName;

            public NameStatistics(String customerName) {
                this.originalCustomerName = customerName;
            }

            public void printUpperCaseName() {
                System.out.println(originalCustomerName.toUpperCase());
            }

            public void printNameLength() {
                System.out.println(originalCustomerName.length());
            }
        }

        NameStatistics statistics = new NameStatistics(customerName);

        statistics.printUpperCaseName();
        statistics.printNameLength();
    }
}
