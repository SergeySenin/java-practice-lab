package org.study.javarush.java.core.level23.tasks23.e.temp1;

public class Solution444 {
    public static void main(String[] args) {

        playMedia(new AudioFile());
        playMedia(new VideoFile());
    }

    public static void playMedia(MediaFile mediaFile) {
        mediaFile.play();
    }
}

abstract class MediaFile {
    public abstract void play();
}

class AudioFile extends MediaFile {
    @Override
    public void play() {
        System.out.println("Играет аудио");
    }
}

class VideoFile extends MediaFile {
    @Override
    public void play() {
        System.out.println("Играет видео");
    }
}
