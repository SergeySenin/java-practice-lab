package org.study.javarush.java.core.level14.tasks14.g;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static int calculateTotalCpuCores(ArrayList<ManagedServer> registeredServers) {
        int totalCpuCores = 0;

        for (ManagedServer server : registeredServers) {
            totalCpuCores += server.getCpuCoreCount();
        }

        return totalCpuCores;
    }

    public static int countOnlineServers(ArrayList<ManagedServer> registeredServers) {
        int onlineServerCount = 0;

        for (ManagedServer server : registeredServers) {
            if (server.isOnline()) {
                onlineServerCount++;
            }
        }

        return onlineServerCount;
    }

    public static int calculateTotalRestarts(ArrayList<ManagedServer> registeredServers) {
        int totalRestartCount = 0;

        for (ManagedServer server : registeredServers) {
            totalRestartCount += server.getRestartCount();
        }

        return totalRestartCount;
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String primaryServerNameInput   = console.nextLine();
        String primaryCpuCoreCountInput = console.nextLine();

        primaryServerNameInput   = primaryServerNameInput.trim();
        primaryCpuCoreCountInput = primaryCpuCoreCountInput.trim();

        int primaryCpuCoreCount = Integer.parseInt(primaryCpuCoreCountInput);

        ManagedServer primaryServer   = new ManagedServer(primaryServerNameInput, primaryCpuCoreCount);
        ManagedServer secondaryServer = new ManagedServer("billing-service");
        ManagedServer reserveServer   = new ManagedServer();

        primaryServer  .startServer();
        secondaryServer.startServer();

        boolean firstPrimaryRestartSucceeded  = primaryServer.restartServer();
        boolean secondPrimaryRestartSucceeded = primaryServer.restartServer();
        boolean secondaryRestartSucceeded     = secondaryServer.restartServer();
        boolean reserveRestartSucceeded       = reserveServer.restartServer();

        secondaryServer.stopServer();

        ManagedServer primaryServerAlias = primaryServer;
        primaryServerAlias.renameServer("auth-service-v2");

        boolean isSameServerReference = primaryServer == primaryServerAlias;
        boolean areServersDifferent   = primaryServer != secondaryServer;

        ArrayList<ManagedServer> registeredServers = new ArrayList<>();
        registeredServers.add(primaryServer);
        registeredServers.add(secondaryServer);
        registeredServers.add(reserveServer);

        int totalCpuCores     = calculateTotalCpuCores(registeredServers);
        int onlineServerCount = countOnlineServers(registeredServers);
        int totalRestartCount = calculateTotalRestarts(registeredServers);

        for (ManagedServer server : registeredServers) {
            server.printInfo();
        }

        System.out.println("Primary restart 1:   " + firstPrimaryRestartSucceeded);
        System.out.println("Primary restart 2:   " + secondPrimaryRestartSucceeded);
        System.out.println("Secondary restart:   " + secondaryRestartSucceeded);
        System.out.println("Reserve restart:     " + reserveRestartSucceeded);
        System.out.println("Primary server name: " + primaryServer                .getServerName());
        System.out.println("Alias server name:   " + primaryServerAlias           .getServerName());
        System.out.println("Same reference:      " + isSameServerReference);
        System.out.println("Different servers:   " + areServersDifferent);
        System.out.println("Registered servers:  " + registeredServers            .size());
        System.out.println("Total CPU cores:     " + totalCpuCores);
        System.out.println("Online servers:      " + onlineServerCount);
        System.out.println("Total restarts:      " + totalRestartCount);

        InitializationProbe initializationProbe = new InitializationProbe();

        System.out.println("Default counter: " + initializationProbe.getDefaultCounter());
        System.out.println("Default label:   " + initializationProbe.getDefaultLabel());
        System.out.println("Final stage:     " + initializationProbe.getInitializationStage());
    }
}
