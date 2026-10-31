package org.study.javarush.java.core.level16.tasks16.f;

public class Solution310 {
    public static void main(String[] args) {

        DataPair<String> pair = new DataPair<>("Hello", "World");

        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }
}

class DataPair<T> {
    private T firstElement;
    private T secondElement;

    public DataPair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirst() {
        return firstElement;
    }

    public T getSecond() {
        return secondElement;
    }
}
