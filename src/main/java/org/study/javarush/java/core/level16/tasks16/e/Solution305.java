package org.study.javarush.java.core.level16.tasks16.e;

public class Solution305 {
    public static void main(String[] args) {

        SecretKeeper keeper = new SecretKeeper();

        keeper.revealSecret();
    }
}

class SecretKeeper {
    private String hiddenSecret = "Java — круто!";

    public void revealSecret() {

        class TruthRevealer {

            public void printSecret() {
                System.out.println(hiddenSecret);
            }
        }

        TruthRevealer revealer = new TruthRevealer();
        revealer.printSecret();
    }
}
