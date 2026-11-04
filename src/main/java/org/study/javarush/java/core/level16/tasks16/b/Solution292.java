package org.study.javarush.java.core.level16.tasks16.b;

public class Solution292 {
    public static void main(String[] args) {

        Box box = new Box();
        Box.Label label = box.new Label();

        label.printLabel();
    }
}

class Box {
    class Label {
        public void printLabel() {
            System.out.println("Box label");
        }
    }
}
