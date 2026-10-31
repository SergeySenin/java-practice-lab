package org.study.javarush.java.core.level16.tasks16.d.temp3;

public class ProductionCounter {

    public void startCountOperation() {
        Runnable counterTask = new Runnable() {

            @Override
            public void run() {
                System.out.println("Счётчик запущен");
            }
        };

        counterTask.run();
    }
}
