package org.study.javarush.java.core.level15.tasks15.d;

public class Solution282 {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp();

        lamp.setCurrentlyOn(true);

        System.out.println(lamp.isCurrentlyOn());
    }
}

class SmartLamp {
    private boolean isCurrentlyOn;

    public SmartLamp() {
        this.isCurrentlyOn = false;
    }

    public boolean isCurrentlyOn() {
        return isCurrentlyOn;
    }

    public void setCurrentlyOn(boolean newState) {
        this.isCurrentlyOn = newState;
    }
}
