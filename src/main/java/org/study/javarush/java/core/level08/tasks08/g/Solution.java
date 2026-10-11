package org.study.javarush.java.core.level08.tasks08.g;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int processedRequestCount = 0;

    public static String normalizeTitle(String requestTitleInput) {
        return requestTitleInput.trim();
    }

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
        if (priorityLevel != 3) {
            return;
        }
        System.out.println("CRITICAL REQUEST: " + requestTitle);
    }

    public static void registerProcessedRequest(boolean isRequestAccepted) {
        if (!isRequestAccepted) {
            return;
        }
        processedRequestCount++;
    }

    public static int getProcessedRequestCount() {
        return processedRequestCount;
    }

    public static int calculateTotalRequestCount(int[] historicalRequestCounts) {
        int sum = 0;
        for (int i = 0; i < historicalRequestCounts.length; i++) {
            sum += historicalRequestCounts[i];
        }
        return sum;
    }

    public static void reduceResponseTimes(int[] responseTimesInMinutes, int reductionMinutes) {
        for (int i = 0; i < responseTimesInMinutes.length; i++) {
            responseTimesInMinutes[i] -= reductionMinutes;
        }
    }

    public static void tryToReplaceResponseTimes(int[] responseTimesInMinutes) {
        responseTimesInMinutes = new int[] {5, 5, 5, 5};
    }

    public static int[] createReplacementResponseTimes() {
        return new int[] {15, 20, 25, 30};
    }

    public static void tryToChangeDailyRequestLimit(int dailyRequestLimit) {
        dailyRequestLimit = 999;
    }

    public static void updateRequestTitle(SupportRequest request, String newRequestTitle) {
        request.requestTitle = newRequestTitle;
    }

    public static void tryToReplaceRequest(SupportRequest request) {
        request = new SupportRequest();
        request.requestId = 999;
        request.requestTitle = "Another request";
        request.setPriorityLevel(1);
    }

    public static String buildRequestSummary(
            int requestId,
            String requestTitle,
            int priorityLevel,
            boolean isRequestAccepted,
            int totalHistoricalRequestCount,
            int currentProcessedRequestCount,
            int dailyRequestLimit
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

        String requestTitleInput = console.nextLine();
        int requestId = console.nextInt();
        int severityLevel = console.nextInt();
        int affectedUserCount = console.nextInt();
        int waitingTimeMinutes = console.nextInt();

        String requestTitle = normalizeTitle(requestTitleInput);
        int priorityLevel = calculatePriority(severityLevel, affectedUserCount, waitingTimeMinutes);
        boolean isRequestAccepted = canAcceptRequest(requestTitle, priorityLevel);
        printCriticalWarning(priorityLevel, requestTitle);

        registerProcessedRequest(isRequestAccepted);
        int currentProcessedRequestCount = getProcessedRequestCount();

        int[] historicalRequestCounts = {3, 7, 2, 5};
        int totalHistoricalRequestCount = calculateTotalRequestCount(historicalRequestCounts);

        int[] responseTimesInMinutes = {40, 55, 30, 70};
        reduceResponseTimes(responseTimesInMinutes, 5);

        System.out.println(Arrays.toString(responseTimesInMinutes));
        tryToReplaceResponseTimes(responseTimesInMinutes);
        System.out.println(Arrays.toString(responseTimesInMinutes));

        responseTimesInMinutes = createReplacementResponseTimes();
        System.out.println(Arrays.toString(responseTimesInMinutes));

        int dailyRequestLimit = 100;
        tryToChangeDailyRequestLimit(dailyRequestLimit);
        System.out.println(dailyRequestLimit);

        SupportRequest request = new SupportRequest();
        request.requestId = requestId;
        request.requestTitle = requestTitle;
//      request.priorityLevel = 1;
        request.setPriorityLevel(priorityLevel);
        request.printRequestProfile();

        updateRequestTitle(request, requestTitle + " - verified");
        request.printRequestProfile();

        tryToReplaceRequest(request);
        request.printRequestProfile();

        if (isRequestAccepted) {
            String requestProcessingMessage = "Request accepted for processing";
            System.out.println(requestProcessingMessage);
        }
//      System.out.println(requestProcessingMessage);

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
