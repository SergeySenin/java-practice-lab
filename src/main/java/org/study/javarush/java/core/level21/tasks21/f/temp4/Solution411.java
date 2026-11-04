package org.study.javarush.java.core.level21.tasks21.f.temp4;

public class Solution411 {
    public static void main(String[] args) {

        try (DemoResource resource = new DemoResource()) {
            System.out.println("Работа с ресурсом");
        }
    }
}

class DemoResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Ресурс закрыт");
    }
}
