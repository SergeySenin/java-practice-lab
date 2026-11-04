package org.study.javarush.java.core.level21.tasks21.d.temp4;

public class Solution403 {
    public static void main(String[] args) {

        C object = new C();

        object.show();
    }
}

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {
    @Override
    public void show() {
        A.super.show();
        B.super.show();
    }
}
