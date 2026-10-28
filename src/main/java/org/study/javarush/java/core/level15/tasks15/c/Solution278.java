package org.study.javarush.java.core.level15.tasks15.c;

public class Solution278 {
    public static void main(String[] args) {

        ModuleMain moduleMain = new ModuleMain();

        moduleMain.run();
    }
}

class ModuleMain {

    void run() {
        ModuleHelper helper = new ModuleHelper();

        helper.provideInternalAssistance();
    }
}

class ModuleHelper {

    void provideInternalAssistance() {
        System.out.println("Предоставляю внутреннюю помощь модуля!");
    }
}
