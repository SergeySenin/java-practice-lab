package org.study.javarush.java.core.level16.tasks16.b;

public class Solution294 {
    public static void main(String[] args) {

        Library library = new Library();
        Library.Scroll scroll = library.new Scroll("Ancient Runes");

        scroll.revealTitle();
    }
}

class Library {
    public void addScroll(String scrollTitle) {
    }

    class Scroll {
        private String scrollTitle;

        public Scroll(String scrollTitle) {
            this.scrollTitle = scrollTitle;
        }

        public void revealTitle() {
            System.out.println(scrollTitle);
        }
    }
}
