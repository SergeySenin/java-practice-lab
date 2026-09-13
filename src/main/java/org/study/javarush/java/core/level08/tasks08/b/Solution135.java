package org.study.javarush.java.core.level08.tasks08.b;

public class Solution135 {
    public static void main(String[] args) { // main не в MessageAmplifier → отклонение от условия задачи

        MessageAmplifier.amplifyAndDisplay("Ура!", 4);
    }

    public class MessageAmplifier {
        public static void amplifyAndDisplay(String messageText, int numberOfRepeats) {
            String amplifiedMessage = "";

            for (int repeatIndex = 0; repeatIndex < numberOfRepeats; repeatIndex++) {
                amplifiedMessage = amplifiedMessage + messageText;
            }

            System.out.println(amplifiedMessage);
        }
    }
}
