package org.study.javarush.java.core.level15.tasks15.c;

public class Solution279 {
    public static void main(String[] args) {

        DigitalLibraryManager manager = new DigitalLibraryManager();

        manager.announceOpening();
        manager.conductStaffMeeting();
        manager.manageBookInventory();

        // Ошибка компиляции при раскомментировании:
        // manager.handleFinancialAudits();
    }
}

class DigitalLibraryManager {

    public void announceOpening() {
        System.out.println("Библиотека открыта для посетителей!");
    }

    protected void conductStaffMeeting() {
        System.out.println("Проведено собрание персонала библиотеки.");
    }

    void manageBookInventory() {
        System.out.println("Инвентаризация книг завершена.");
    }

    private void handleFinancialAudits() {
        System.out.println("Финансовый аудит успешно завершён.");
    }
}
