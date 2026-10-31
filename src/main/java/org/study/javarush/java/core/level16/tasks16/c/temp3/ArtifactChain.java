package org.study.javarush.java.core.level16.tasks16.c.temp3;

public class ArtifactChain {
    private Link head;

    private static class Link {
        int value;
        Link next;

        // Для способа 2:
        // включить вместе с альтернативным addArtifact().
        // Link(int artifactValue, Link head) {
        //     this.value = artifactValue;
        //     this.next = head;
        // }
    }

    // Способ 1: отдельные присваивания
    public void addArtifact(int artifactValue) {
        Link newLink = new Link();

        newLink.value = artifactValue;
        newLink.next = head;
        head = newLink;
    }

    // Способ 2: инициализация через конструктор
    // Включить конструктор Link выше и этот метод, отключив способ 1.
    // public void addArtifact(int artifactValue) {
    //     Link newLink = new Link(artifactValue, head);
    //     head = newLink;
    // }

    public void displayChain() {
        Link current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
