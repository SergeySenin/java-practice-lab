package org.study.javarush.java.core.level10.tasks10.g;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String deploymentEnvironmentInput = console.nextLine();
        String operatorCommandInput = console.nextLine();
        String retryCountText = console.nextLine();
        String dryRunText = console.nextLine();
        String cpuLimitPercentText = console.nextLine();
        String manualPortText = console.nextLine();
        String releaseCharacterInput = console.nextLine();
        String monitoringValueText = console.nextLine();

        var normalizedEnvironmentName = deploymentEnvironmentInput.trim().toUpperCase(Locale.ROOT);
        var normalizedCommand = operatorCommandInput.trim().toLowerCase(Locale.ROOT);
        DeploymentEnvironment deploymentEnvironment =
                DeploymentEnvironment.valueOf(normalizedEnvironmentName);
        var availableEnvironments = DeploymentEnvironment.values();
        System.out.println("Available environments:");
        for (DeploymentEnvironment availableEnvironment : availableEnvironments) {
            System.out.println(availableEnvironment);
        }

        String deploymentEnvironmentName = deploymentEnvironment.name();
        int deploymentEnvironmentOrdinal = deploymentEnvironment.ordinal();
        System.out.println(deploymentEnvironmentOrdinal);
        boolean isProductionEnvironment =
                deploymentEnvironment == DeploymentEnvironment.PRODUCTION;
        System.out.println(isProductionEnvironment);

        int requestedRetryCount = Integer.parseInt(retryCountText);
        Integer boxedRetryCount = Integer.valueOf(requestedRetryCount);
        int unboxedRetryCount = boxedRetryCount.intValue();
        Integer autoBoxedRetryCount = requestedRetryCount;
        int autoUnboxedRetryCount = autoBoxedRetryCount;
        int effectiveRetryCount = requestedRetryCount;
        if (requestedRetryCount > DeploymentSettings.MAX_RETRY_COUNT) {
            effectiveRetryCount = DeploymentSettings.MAX_RETRY_COUNT;
        }

        Boolean dryRunSetting = Boolean.parseBoolean(dryRunText);
        boolean isDryRunEnabled = dryRunSetting;
        Double cpuLimitPercent = Double.parseDouble(cpuLimitPercentText);
        double cpuLimitPercentValue = cpuLimitPercent;
        double monitoringValue = Double.parseDouble(monitoringValueText);
        boolean isMonitoringValueNaN = Double.isNaN(monitoringValue);

        char releaseCharacter = releaseCharacterInput.charAt(0);
        boolean isReleaseCharacterDigit = Character.isDigit(releaseCharacter);
        Character wrappedReleaseCharacter = releaseCharacter;

        Integer manualPort;
        if (manualPortText.equals("auto")) {
            manualPort = null;
        } else {
            manualPort = Integer.parseInt(manualPortText);
        }

        int automaticPort = switch (deploymentEnvironment) {
            case DEVELOPMENT, TESTING -> DeploymentSettings.DEFAULT_PORT;
            case STAGING -> DeploymentSettings.STAGING_PORT;
            case PRODUCTION -> {
                System.out.println("Production environment selected.");
                yield DeploymentSettings.PRODUCTION_PORT;
            }
        };

        int effectivePort;
        if (manualPort != null) {
            effectivePort = manualPort;
        } else {
            effectivePort = automaticPort;
        }

        final var deploymentId = DeploymentSettings.APPLICATION_NAME
                + "-" + deploymentEnvironmentName + "-" + releaseCharacter;
        final var deploymentLog = new StringBuilder();
        deploymentLog.append("Deployment ID: ").append(deploymentId).append("\n");
        deploymentLog.append("Environment:   ").append(deploymentEnvironmentName).append("\n");
        deploymentLog.append("Port:          ").append(effectivePort).append("\n");

        String commandCategory;
        switch (normalizedCommand) {
            case "build":
            case "test":
                commandCategory = "PREPARATION";
                break;
            case "deploy":
                commandCategory = "DEPLOYMENT";
                break;
            case "status":
                commandCategory = "INFORMATION";
                break;
            default:
                commandCategory = "UNKNOWN";
                break;
        }

        String commandMessage = switch (normalizedCommand) {
            case "build" -> "Build process selected.";
            case "test" -> "Test process selected.";
            case "deploy" -> "Deployment process selected.";
            case "status" -> "Status information requested.";
            default -> "Unknown command.";
        };
        String executionMode = isDryRunEnabled ? "DRY_RUN" : "LIVE";
        boolean isDeploymentAllowed = commandCategory.equals("DEPLOYMENT")
                && isReleaseCharacterDigit
                && effectiveRetryCount <= DeploymentSettings.MAX_RETRY_COUNT
                && cpuLimitPercentValue > 0
                && cpuLimitPercentValue <= 100;

        deploymentLog.append("Command:            ").append(normalizedCommand).append("\n");
        deploymentLog.append("Command category:   ").append(commandCategory).append("\n");
        deploymentLog.append("Execution mode:     ").append(executionMode).append("\n");
        deploymentLog.append("Retry count:        ").append(effectiveRetryCount).append("\n");
        deploymentLog.append("CPU limit:          ").append(cpuLimitPercentValue).append("\n");
        deploymentLog.append("Deployment allowed: ").append(isDeploymentAllowed).append("\n");
        System.out.print(deploymentLog);

        System.out.println("Application:                " + DeploymentSettings.APPLICATION_NAME);
        System.out.println("Deployment ID:              " + deploymentId);
        System.out.println("Environment:                " + deploymentEnvironmentName);
        System.out.println("Environment ordinal:        " + deploymentEnvironmentOrdinal);
        System.out.println("Command:                    " + normalizedCommand);
        System.out.println("Command category:           " + commandCategory);
        System.out.println("Command message:            " + commandMessage);
        System.out.println("Execution mode:             " + executionMode);
        System.out.println("Requested retries:          " + requestedRetryCount);
        System.out.println("Effective retries:          " + effectiveRetryCount);
        System.out.println("CPU limit:                  " + cpuLimitPercentValue);
        System.out.println("Manual port:                " + manualPort);
        System.out.println("Automatic port:             " + automaticPort);
        System.out.println("Effective port:             " + effectivePort);
        System.out.println("Release character:          " + releaseCharacter);
        System.out.println("Release character is digit: " + isReleaseCharacterDigit);
        System.out.println("Monitoring value:           " + monitoringValue);
        System.out.println("Monitoring value is NaN:    " + isMonitoringValueNaN);
        System.out.println("Deployment allowed:         " + isDeploymentAllowed);
    }
}
