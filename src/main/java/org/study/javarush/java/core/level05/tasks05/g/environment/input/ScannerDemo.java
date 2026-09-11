package org.study.javarush.java.core.level05.tasks05.g.environment.input;

public class ScannerDemo {
    public static void main(String[] args) {

        java.util.Scanner console = new java.util.Scanner(System.in);
        String fullyQualifiedInput = console.nextLine();
        System.out.println("Fully qualified Scanner input: " + fullyQualifiedInput);
    }
}
