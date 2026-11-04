package org.study.javarush.java.core.level20.tasks20.d.temp4;

public class Solution383 {
    public static void main(String[] args) {
        MediaDevice device = new MediaDevice();
        testDevice(device, device);
    }

    public static void testDevice(Player p, Recorder r) {
        p.play();
        r.record();
    }
}

interface Player {
    void play();
}

interface Recorder {
    void record();
}

class MediaDevice implements Player, Recorder {
    @Override
    public void play() {
        System.out.println("Воспроизведение");
    }

    @Override
    public void record() {
        System.out.println("Запись");
    }
}
