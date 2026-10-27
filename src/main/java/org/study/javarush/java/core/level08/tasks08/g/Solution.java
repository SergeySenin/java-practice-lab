package org.study.javarush.java.core.level08.tasks08.g;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Один общий счётчик класса: значение сохраняется между вызовами методов.
    private static int processedRequestCount = 0;

    // Возвращаем очищенный заголовок; исходная строка от trim() не изменяется.
    public static String normalizeTitle(String requestTitleInput) {
        return requestTitleInput.trim();
    }

    // Сначала проверяем критические условия, чтобы средний приоритет их не перекрыл.
    public static int calculatePriority(int severityLevel, int affectedUserCount, int waitingTimeMinutes) {
        if (severityLevel >= 4 || affectedUserCount >= 100) {
            return 3;
        } else if (severityLevel >= 2 || waitingTimeMinutes >= 60) {
            return 2;
        } else {
            return 1;
        }
    }

    public static boolean canAcceptRequest(String requestTitle, int priorityLevel) {
        return !requestTitle.isEmpty() && priorityLevel >= 1 && priorityLevel <= 3;
    }

    public static void printCriticalWarning(int priorityLevel, String requestTitle) {
        // В void-методе return без значения сразу завершает вызов.
        if (priorityLevel != 3) {
            return;
        }

        System.out.println("CRITICAL REQUEST: " + requestTitle);
    }

    public static void registerProcessedRequest(boolean isRequestAccepted) {
        // Отклонённое обращение не должно увеличивать общий счётчик.
        if (!isRequestAccepted) {
            return;
        }

        processedRequestCount++;
    }

    public static int getProcessedRequestCount() {
        return processedRequestCount;
    }

    public static int calculateTotalRequestCount(int[] historicalRequestCounts) {
        // Локальная сумма создаётся заново при каждом вызове этого метода.
        int sum = 0;

        for (int periodIndex = 0; periodIndex < historicalRequestCounts.length; periodIndex++) {
            sum += historicalRequestCounts[periodIndex];
        }

        return sum;
    }

    // Меняем элементы переданного массива: результат будет виден и в main.
    public static void reduceResponseTimes(int[] responseTimesInMinutes, int reductionMinutes) {
        for (
                int responseTimeIndex = 0;
                responseTimeIndex < responseTimesInMinutes.length;
                responseTimeIndex++
        ) {
            responseTimesInMinutes[responseTimeIndex] -= reductionMinutes;
        }
    }

    // Параметр хранит копию ссылки. Новое присваивание не заменяет переменную в main.
    public static void tryToReplaceResponseTimes(int[] responseTimesInMinutes) {
        responseTimesInMinutes = new int[] {5, 5, 5, 5};
    }

    // Чтобы заменить массив в main, возвращаем новый массив и присваиваем его там.
    public static int[] createReplacementResponseTimes() {
        return new int[] {15, 20, 25, 30};
    }

    // У int копируется само число: изменение параметра не меняет исходный лимит.
    public static void tryToChangeDailyRequestLimit(int dailyRequestLimit) {
        dailyRequestLimit = 999;
    }

    // Меняем поле существующего объекта, доступного и через ссылку в main.
    public static void updateRequestTitle(SupportRequest request, String newRequestTitle) {
        request.requestTitle = newRequestTitle;
    }

    // Новым объектом заменяется только локальная копия ссылки, как и в опыте с массивом.
    public static void tryToReplaceRequest(SupportRequest request) {
        request              = new SupportRequest();
        request.requestId    = 999;
        request.requestTitle = "Another request";
        request.setPriorityLevel(1);
    }

    // Сборка отчёта отделена от вывода: метод возвращает готовый текст.
    public static String buildRequestSummary(
            int     requestId,
            String  requestTitle,
            int     priorityLevel,
            boolean isRequestAccepted,
            int     totalHistoricalRequestCount,
            int     currentProcessedRequestCount,
            int     dailyRequestLimit
    ) {
        return
                  "Request ID:            " + requestId                    + "\n"
                + "Title:                 " + requestTitle                 + "\n"
                + "Priority:              " + priorityLevel                + "\n"
                + "Accepted:              " + isRequestAccepted            + "\n"
                + "Total historical load: " + totalHistoricalRequestCount  + "\n"
                + "Processed requests:    " + currentProcessedRequestCount + "\n"
                + "Daily request limit:   " + dailyRequestLimit;
    }

    public static void printRequestReport(String report) {
        System.out.println(report);
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // main задаёт порядок работы, а обработку данных поручает отдельным методам.
        // Сначала читаем заголовок целой строкой, затем числовые параметры обращения.
        String requestTitleInput = console.nextLine();
        int requestId            = console.nextInt();
        int severityLevel        = console.nextInt();
        int affectedUserCount    = console.nextInt();
        int waitingTimeMinutes   = console.nextInt();

        // Нормализация, приоритет и решение о принятии обращения.
        String  requestTitle      = normalizeTitle(requestTitleInput);
        int     priorityLevel     = calculatePriority(severityLevel, affectedUserCount, waitingTimeMinutes);
        boolean isRequestAccepted = canAcceptRequest(requestTitle, priorityLevel);

        printCriticalWarning(priorityLevel, requestTitle);

        registerProcessedRequest(isRequestAccepted);
        int currentProcessedRequestCount = getProcessedRequestCount();

        // Общая нагрузка за предыдущие периоды вычисляется внутри метода.
        int[] historicalRequestCounts = {3, 7, 2, 5};
        int totalHistoricalRequestCount = calculateTotalRequestCount(historicalRequestCounts);

        // Три опыта с массивом: изменение элементов, попытка замены и замена через return.
        int[] responseTimesInMinutes = {40, 55, 30, 70};
        reduceResponseTimes(responseTimesInMinutes, 5);

        System.out.println(Arrays.toString(responseTimesInMinutes));

        tryToReplaceResponseTimes(responseTimesInMinutes);
        System.out.println(Arrays.toString(responseTimesInMinutes));

        responseTimesInMinutes = createReplacementResponseTimes();
        System.out.println(Arrays.toString(responseTimesInMinutes));

        // После вызова исходный примитивный лимит по-прежнему равен 100.
        int dailyRequestLimit = 100;
        tryToChangeDailyRequestLimit(dailyRequestLimit);
        System.out.println(dailyRequestLimit);

        // Публичные поля заполняем напрямую, приватный приоритет — через метод объекта.
        SupportRequest request = new SupportRequest();
        request.requestId      = requestId;
        request.requestTitle   = requestTitle;
        // request.priorityLevel = 1; // Опыт: ошибка компиляции из-за private.
        request.setPriorityLevel(priorityLevel);
        request.printRequestProfile();

        // Обновление поля видно снаружи метода; попытка заменить объект ссылку в main не меняет.
        updateRequestTitle(request, requestTitle + " - verified");
        request.printRequestProfile();

        tryToReplaceRequest(request);
        request.printRequestProfile();

        // Сообщение существует только внутри этого блока и выводится для принятого обращения.
        if (isRequestAccepted) {
            String requestProcessingMessage = "Request accepted for processing";
            System.out.println(requestProcessingMessage);
        }
        // System.out.println(requestProcessingMessage); // Опыт: переменная вне области видимости.

        // Возвращённая строка сразу становится аргументом метода вывода.
        // Заголовок берём из обновлённого объекта; решение о принятии остаётся первоначальным.
        printRequestReport(
                buildRequestSummary(
                        request.requestId,
                        request.requestTitle,
                        request.getPriorityLevel(),
                        isRequestAccepted,
                        totalHistoricalRequestCount,
                        currentProcessedRequestCount,
                        dailyRequestLimit
                )
        );
    }
}
