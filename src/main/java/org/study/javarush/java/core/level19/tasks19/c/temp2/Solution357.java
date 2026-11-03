package org.study.javarush.java.core.level19.tasks19.c.temp2;

public class Solution357 {
    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.turnOn();
        phone.turnOff();
    }
}

abstract class Device {
    public abstract void turnOn();

    public void turnOff() {
        System.out.println("Устройство выключено");
    }
}

class Phone extends Device {
    @Override
    public void turnOn() {
        System.out.println("Телефон включен");
    }
}
