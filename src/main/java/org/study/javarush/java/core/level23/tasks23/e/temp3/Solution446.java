package org.study.javarush.java.core.level23.tasks23.e.temp3;

public class Solution446 {
    public static void main(String[] args) {

        Appliance homeAppliance = new Kettle();

        if (homeAppliance instanceof Kettle) {
            Kettle kettle = (Kettle) homeAppliance;
            kettle.boil();
        }
    }
}

abstract class Appliance {
    public abstract void turnOn();
}

class Kettle extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Чайник включён");
    }

    public void boil() {
        System.out.println("Вода закипела");
    }
}

class Toaster extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Тостер включён");
    }
}
