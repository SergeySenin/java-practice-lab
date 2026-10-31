package org.study.javarush.java.core.level16.tasks16.f;

public class Solution308 {
    public static void main(String[] args) {

        StorageBox box = new StorageBox();

        box.put("Привет из прошлого!");

        Object content = box.retrieve();

        System.out.println(content);
    }
}

class StorageBox {
    private Object content;

    public void put(Object item) {
        this.content = item;
    }

    public Object retrieve() {
        return content;
    }
}
