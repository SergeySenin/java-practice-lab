package org.study.javarush.java.core.level20.tasks20.c.temp4;

public class Solution379 {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();
        phone.turnOn();
        phone.work();
        phone.charge();
    }
}

abstract class Appliance {
    public void turnOn() {
        System.out.println("Устройство включено");
    }

    public abstract void work();
}

interface Chargeable {
    void charge();
}

class SmartPhone extends Appliance implements Chargeable {
    @Override
    public void work() {
        System.out.println("Смартфон работает");
    }

    @Override
    public void charge() {
        System.out.println("Смартфон заряжается");
    }
}
