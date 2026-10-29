package org.study.javarush.java.core.level15.tasks15.g;

import java.util.ArrayList;

public class ApiClient {

    public static final int MAX_REQUEST_LIMIT = 1000;
    public static final int DEFAULT_REQUEST_LIMIT;

    private static int nextClientNumber = 1001;
    private static int registeredClientCount;

    private final String  clientId;
    private       String  displayName;
    private       int     requestLimit;
    private       int     usedRequestCount;
    private       boolean active;

    private final ArrayList<String> allowedServices = new ArrayList<>();

    static {
        DEFAULT_REQUEST_LIMIT = 100;
        System.out.println("CLIENT CONFIG INITIALIZED");
    }

    public ApiClient(String displayName, int requestLimit) {
        setDisplayName(displayName);
        setRequestLimit(requestLimit);

        clientId = "CLIENT-" + nextClientNumber;
        nextClientNumber++;
        registeredClientCount++;
    }

    public ApiClient(String displayName) {
        this(displayName, DEFAULT_REQUEST_LIMIT);
    }

    public ApiClient() {
        this("Unnamed Client");
    }

    public String getClientId() {
        return clientId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getRequestLimit() {
        return requestLimit;
    }

    public int getUsedRequestCount() {
        return usedRequestCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setDisplayName(String displayName) {
        if (displayName == null || displayName.trim().isEmpty()) {
            throw new IllegalArgumentException("Client name must not be blank.");
        }

        this.displayName = displayName.trim();
    }

    public void setRequestLimit(int requestLimit) {
        if (requestLimit < 1 || requestLimit > MAX_REQUEST_LIMIT) {
            throw new IllegalArgumentException("Request limit must be from 1 to 1000.");
        }

        if (requestLimit < usedRequestCount) {
            throw new IllegalArgumentException("Request limit below usage.");
        }

        this.requestLimit = requestLimit;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private void validateRequestCount(int requestCount) {
        if (requestCount <= 0) {
            throw new IllegalArgumentException("Request count must be positive.");
        }
    }

    public boolean tryConsumeRequests(int requestCount) {
        validateRequestCount(requestCount);

        if (!active || requestCount > requestLimit - usedRequestCount) {
            return false;
        }

        usedRequestCount += requestCount;
        return true;
    }

    public int getAvailableRequests() {
        return requestLimit - usedRequestCount;
    }

    public void addAllowedService(String serviceName) {
        if (serviceName == null || serviceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Service name must not be blank.");
        }

        serviceName = serviceName.trim();

        if (!allowedServices.contains(serviceName)) {
            allowedServices.add(serviceName);
        }
    }

    public ArrayList<String> getAllowedServices() {
        return new ArrayList<>(allowedServices);
    }

    public static int getRegisteredClientCount() {
        return registeredClientCount;
    }
}
