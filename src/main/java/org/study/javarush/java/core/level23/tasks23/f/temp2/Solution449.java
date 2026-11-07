package org.study.javarush.java.core.level23.tasks23.f.temp2;

public class Solution449 {
    public static void main(String[] args) {

        MessageDisplay display = new MessageDisplay();

        display.displayMessage();
    }
}

class MessageDisplay {
    private int count = 10;
    private String message = "Привет";

    public void displayMessage() {
        System.out.println(message + " " + count);
    }
}
