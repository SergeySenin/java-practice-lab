package org.study.javarush.java.core.level15.tasks15.f;

public class Solution290 {
    public static void main(String[] args) {

        SystemComponent firstComponent = new SystemComponent();
        SystemComponent secondComponent = new SystemComponent();
    }
}

class SystemComponent {

    static {
        System.out.println("Глобальная инициализация: Шаг 1");
    }

    static {
        System.out.println("Глобальная инициализация: Шаг 2");
    }

    {
        System.out.println("Инициализация компонента: Шаг А");
    }

    {
        System.out.println("Инициализация компонента: Шаг Б");
    }

    public SystemComponent() {
        System.out.println("Компонент полностью настроен и готов!");
    }
}
