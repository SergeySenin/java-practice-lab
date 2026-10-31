package org.study.javarush.java.core.level16.tasks16.f;

public class Solution309 {
    public static void main(String[] args) {

        SmartBox<Integer> box = new SmartBox<>();

        box.store(42);

        Integer content = box.getContents();

        System.out.println(content);
    }
}

class SmartBox<T> {
    private T content;

    public void store(T item) {
        this.content = item;
    }

    public T getContents() {
        return content;
    }
}
