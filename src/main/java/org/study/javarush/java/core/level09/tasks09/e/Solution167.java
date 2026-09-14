package org.study.javarush.java.core.level09.tasks09.e;

public class Solution167 {
    public static void main(String[] args) {

        String emailOne = "User@Example.com";
        String emailTwo = "user@example.com";

        boolean emailsAreEqual = emailOne.equalsIgnoreCase(emailTwo);

        String registrationMessage = "user@example.com is registered";
        boolean containsExample = registrationMessage.contains("example");

        System.out.println(emailsAreEqual + " " + containsExample);
    }
}
