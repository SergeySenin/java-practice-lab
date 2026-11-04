package org.study.javarush.java.core.level16.tasks16.d;

public class Solution303 {
    public static void main(String[] args) {

        SecureLab lab = new SecureLab();

        lab.revealSecret();
    }
}

class SecureLab {
    private String classifiedSecret = "Секрет раскрыт!";

    public void revealSecret() {
        Runnable revealTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(classifiedSecret);
            }
        };

        revealTask.run();
    }
}
