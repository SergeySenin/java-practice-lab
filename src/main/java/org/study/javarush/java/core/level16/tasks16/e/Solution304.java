package org.study.javarush.java.core.level16.tasks16.e;

public class Solution304 {
    public static void main(String[] args) {

        DisplayBoard board = new DisplayBoard();

        board.showTemporaryMessage();
    }
}

class DisplayBoard {

    public void showTemporaryMessage() {

        class GreetingDisplay {

            public void displayMessage() {
                System.out.println("Привет из локального класса!");
            }
        }

        GreetingDisplay display = new GreetingDisplay();
        display.displayMessage();
    }
}
