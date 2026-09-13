package org.study.javarush.java.core.level08.tasks08.f;

public class Solution150 {
    public static void main(String[] args) {

        FactoryBox productBox = new FactoryBox();

        productBox.setDimensions(10);

        System.out.println(productBox.boxSize);
    }
}

class FactoryBox {
    public int boxSize;

    public void setDimensions(int boxSize) {
        this.boxSize = boxSize;
    }
}
