package org.study.javarush.java.core.level20.tasks20.d.temp3;

public class Solution382 {
    public static void main(String[] args) {
        MultiAction action = new MultiAction();
        action.doAction();
    }
}

interface InterfaceA {
    void doAction();
}

interface InterfaceB {
    void doAction();
}

class MultiAction implements InterfaceA, InterfaceB {
    @Override
    public void doAction() {
        System.out.println("Выполнено действие для обоих интерфейсов");
    }
}
