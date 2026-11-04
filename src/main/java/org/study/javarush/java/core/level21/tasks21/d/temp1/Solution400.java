package org.study.javarush.java.core.level21.tasks21.d.temp1;

public class Solution400 {
    public static void main(String[] args) {

        MyCounter counter = new MyCounter();

        counter.increment();
        counter.reset();
    }
}

interface Counter {
    void increment();

    default void reset() {
        System.out.println("Counter reset");
    }
}

class MyCounter implements Counter {
    @Override
    public void increment() {
        System.out.println("Counter incremented");
    }
}
