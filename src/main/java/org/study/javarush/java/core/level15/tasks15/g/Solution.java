package org.study.javarush.java.core.level15.tasks15.g;

import org.study.javarush.java.core.level15.tasks15.g.external.ExternalVisibilityDemo;

import java.util.ArrayList;

public class Solution {

    public static int calculateTotalUsedRequests(ArrayList<ApiClient> registeredClients) {
        int totalUsedRequests = 0;

        for (ApiClient client : registeredClients) {
            totalUsedRequests += client.getUsedRequestCount();
        }

        return totalUsedRequests;
    }

    public static int countActiveClients(ArrayList<ApiClient> registeredClients) {
        int activeClientCount = 0;

        for (ApiClient client : registeredClients) {
            if (client.isActive()) {
                activeClientCount++;
            }
        }

        return activeClientCount;
    }

    public static void main(String[] args) {

        ApiClient paymentClient   = new ApiClient("Payment Gateway", 300);
        ApiClient analyticsClient = new ApiClient("Analytics Worker");
        ApiClient backupClient    = new ApiClient();

        paymentClient.setActive(true);
        analyticsClient.setActive(true);

        paymentClient.addAllowedService("billing");
        paymentClient.addAllowedService("orders");
        analyticsClient.addAllowedService("analytics");
        backupClient.addAllowedService("backup");

        boolean firstPaymentRequestSucceeded  = paymentClient.tryConsumeRequests(120);
        boolean secondPaymentRequestSucceeded = paymentClient.tryConsumeRequests(250);
        boolean thirdPaymentRequestSucceeded  = paymentClient.tryConsumeRequests(80);
        boolean analyticsRequestSucceeded     = analyticsClient.tryConsumeRequests(60);
        boolean backupRequestSucceeded        = backupClient.tryConsumeRequests(10);

        String rejectedLimitMessage   = "";
        String rejectedNameMessage    = "";
        String rejectedRequestMessage = "";

        try {
            paymentClient.setRequestLimit(180);
        } catch (IllegalArgumentException exception) {
            rejectedLimitMessage = "Rejected limit:             " + exception.getMessage();
        }

        paymentClient.setRequestLimit(500);

        try {
            paymentClient.setDisplayName("   ");
        } catch (IllegalArgumentException exception) {
            rejectedNameMessage = "Rejected name:              " + exception.getMessage();
        }

        paymentClient.setDisplayName("   Payment API   ");

        try {
            paymentClient.tryConsumeRequests(0);
        } catch (IllegalArgumentException exception) {
            rejectedRequestMessage = "Rejected request:           " + exception.getMessage();
        }

        ArrayList<String> exposedServices = paymentClient.getAllowedServices();
        exposedServices.add("admin");

        ArrayList<String> internalServices = paymentClient.getAllowedServices();

        boolean isInternalServiceListProtected = internalServices.size() == 2
                && internalServices.get(0).equals("billing")
                && internalServices.get(1).equals("orders");

        ArrayList<ApiClient> registeredClients = new ArrayList<>();
        registeredClients.add(paymentClient);
        registeredClients.add(analyticsClient);
        registeredClients.add(backupClient);

        int totalUsedRequests = calculateTotalUsedRequests(registeredClients);
        int activeClientCount = countActiveClients(registeredClients);

        for (ApiClient client : registeredClients) {
            System.out.println(String.format(
                    "Client: %s | %-16s | limit=%-3d | used=%-3d | active=%s",
                    client.getClientId(), client.getDisplayName(), client.getRequestLimit(),
                    client.getUsedRequestCount(), client.isActive()
            ));
        }

        System.out.println("Payment request 120:        " + firstPaymentRequestSucceeded);
        System.out.println("Payment request 250:        " + secondPaymentRequestSucceeded);
        System.out.println("Payment request 80:         " + thirdPaymentRequestSucceeded);
        System.out.println("Analytics request 60:       " + analyticsRequestSucceeded);
        System.out.println("Backup request 10:          " + backupRequestSucceeded);
        System.out.println(rejectedLimitMessage);
        System.out.println(rejectedNameMessage);
        System.out.println(rejectedRequestMessage);
        System.out.println("Modified copy:              " + exposedServices);
        System.out.println("Internal services:          " + internalServices);
        System.out.println("Internal list protected:    " + isInternalServiceListProtected);
        System.out.println("Available payment requests: " + paymentClient.getAvailableRequests());
        System.out.println("Registered clients:         " + ApiClient.getRegisteredClientCount());
        System.out.println("Active clients:             " + activeClientCount);
        System.out.println("Total used requests:        " + totalUsedRequests);
        System.out.println("Default request limit:      " + ApiClient.DEFAULT_REQUEST_LIMIT);
        System.out.println("Maximum request limit:      " + ApiClient.MAX_REQUEST_LIMIT);

        VisibilityProbe visibilityProbe = new VisibilityProbe();
        visibilityProbe.showPublicMarker();
        visibilityProbe.showProtectedMarker();
        visibilityProbe.showPackageMarker();
        visibilityProbe.runInternalCheck();

        ExternalVisibilityDemo.run(visibilityProbe);

        InitializationProbe firstInitializationProbe  = new InitializationProbe();
        InitializationProbe secondInitializationProbe = new InitializationProbe();

        System.out.println("Created probes:   " + InitializationProbe.getCreatedProbeCount());
        System.out.println("Default language: " + InitializationProbe.DEFAULT_LANGUAGE);
    }
}
