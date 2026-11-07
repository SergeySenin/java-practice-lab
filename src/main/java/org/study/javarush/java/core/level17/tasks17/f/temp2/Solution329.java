package org.study.javarush.java.core.level17.tasks17.f.temp2;

public class Solution329 {
    public static void main(String[] args) {

        Child child = new Child();

        child.printSecret();
        child.demonstrateAccess();
    }
}

class Parent {
    private int familySecret = 42;

    public void printSecret() {
        System.out.println(familySecret);
    }
}

class Child extends Parent {
    void demonstrateAccess() {
        // System.out.println(familySecret);
    }
}
