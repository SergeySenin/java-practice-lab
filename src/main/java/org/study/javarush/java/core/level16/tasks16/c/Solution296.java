package org.study.javarush.java.core.level16.tasks16.c;

public class Solution296 {
    public static void main(String[] args) {

        Spellbook.BasicCharm charm = new Spellbook.BasicCharm();

        charm.castSpell();
    }
}

class Spellbook {
    static class BasicCharm {
        public void castSpell() {
            System.out.println("Hello from static basic charm!");
        }
    }
}
