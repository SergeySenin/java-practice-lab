package org.study.javarush.java.core.level09.tasks09.g;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static String buildIncidentReport(
            String incidentCode,
            String eventLevel,
            String serviceName,
            String maskedEmail,
            String emailDomain,
            String logFileName,
            String incidentMessage,
            int incidentCodeDigitCount,
            String serviceNameOrder,
            double validationPercent,
            int passedValidationCheckCount,
            int totalValidationCheckCount,
            boolean isErrorEvent,
            String warningSymbol
    ) {
        StringBuilder reportBuilder = new StringBuilder("STATUS:        PENDING\n");
        int statusStartIndex = "STATUS:        ".length();
        int statusEndIndex = statusStartIndex + "PENDING".length();
        String validationStatus = passedValidationCheckCount == totalValidationCheckCount
                ? "VALIDATED" : "REVIEW";
        reportBuilder.replace(statusStartIndex, statusEndIndex, validationStatus);

        reportBuilder.append("Incident:      ").append(incidentCode).append("\n");
        reportBuilder.append("Level:         ").append(eventLevel).append("\n");
        reportBuilder.append("Service:       ").append(serviceName).append("\n");
        reportBuilder.append("Email:         ").append(maskedEmail).append("\n");
        reportBuilder.append("Domain:        ").append(emailDomain).append("\n");
        reportBuilder.append("File:          ").append(logFileName).append("\n");
        reportBuilder.append("Message:       ").append(incidentMessage).append("\n");
        reportBuilder.append(String.format("Code digits:   %d\n", incidentCodeDigitCount));
        reportBuilder.append("Service order: ").append(serviceNameOrder).append("\n");
        reportBuilder.append(
                String.format(Locale.GERMANY, "Validation:    %.1f%%\n", validationPercent)
        );

        if (isErrorEvent) {
            reportBuilder.insert(0, warningSymbol + " [CRITICAL]\n");
        }

        int temporaryLineStartIndex = reportBuilder.length();
        reportBuilder.append("TEMPORARY LINE\n");
        reportBuilder.delete(temporaryLineStartIndex, reportBuilder.length());
        return reportBuilder.toString();
    }

    public static String reverseIncidentCode(String incidentCode) {
        StringBuilder reversedCodeBuilder = new StringBuilder(incidentCode);
        reversedCodeBuilder.reverse();
        return reversedCodeBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String logEntryInput = console.nextLine();
        String[] logFields = logEntryInput.split("\\|", -1);
        boolean hasExpectedLogFieldCount = logFields.length == 6;
        if (!hasExpectedLogFieldCount) {
            System.out.println("Invalid log structure.");
            return;
        }

        String incidentCode = logFields[0].trim();
        String eventLevel = logFields[1].trim();
        String serviceName = logFields[2].trim();
        String email = logFields[3].trim();
        String logFilePath = logFields[4].trim();
        String incidentMessage = logFields[5].strip();

        eventLevel = eventLevel.toUpperCase(Locale.ROOT);
        int incidentCodeLength = incidentCode.length();
        int incidentMessageLength = incidentMessage.length();

        if (incidentCode.isEmpty()) {
            System.out.println("Invalid incident code.");
            return;
        }
        char firstCodeCharacter = incidentCode.charAt(0);
        boolean hasValidIncidentPrefix = incidentCode.startsWith("INC-");

        char[] incidentCodeCharacters = incidentCode.toCharArray();
        int incidentCodeDigitCount = 0;
        for (char codeCharacter : incidentCodeCharacters) {
            if (codeCharacter >= '0' && codeCharacter <= '9') {
                incidentCodeDigitCount++;
            }
        }

        int emailAtSignIndex = email.indexOf('@');
        String emailDomain;
        if (emailAtSignIndex != -1) {
            emailDomain = email.substring(emailAtSignIndex + 1).toLowerCase(Locale.ROOT);
        } else {
            emailDomain = "";
        }

        String registeredEmail = "user@example.com";
        boolean isRegisteredEmail = email.equalsIgnoreCase(registeredEmail);
        boolean isErrorEvent = eventLevel.equals("ERROR");
        String lowerCaseIncidentMessage = incidentMessage.toLowerCase(Locale.ROOT);
        boolean hasPasswordKeyword = lowerCaseIncidentMessage.contains("password");

        String expectedLogDirectory = "C:\\Logs\\";
        boolean isLogFileInExpectedDirectory = logFilePath.startsWith(expectedLogDirectory);
        boolean hasLogFileExtension = logFilePath.endsWith(".log");
        int lastPathSeparatorIndex = logFilePath.lastIndexOf('\\');
        String logFileName;
        if (lastPathSeparatorIndex != -1) {
            logFileName = logFilePath.substring(lastPathSeparatorIndex + 1);
        } else {
            logFileName = logFilePath;
        }

        String maskedEmail = email.replace("@", "[at]");
        String referenceServiceName = "billing-service";
        int serviceNameComparison = serviceName.compareTo(referenceServiceName);
        String serviceNameOrder;
        if (serviceNameComparison < 0) {
            serviceNameOrder = "BEFORE";
        } else if (serviceNameComparison == 0) {
            serviceNameOrder = "SAME";
        } else {
            serviceNameOrder = "AFTER";
        }

        int passedValidationCheckCount = 0;
        if (hasValidIncidentPrefix) {
            passedValidationCheckCount++;
        }
        if (isRegisteredEmail) {
            passedValidationCheckCount++;
        }
        if (isErrorEvent) {
            passedValidationCheckCount++;
        }
        if (isLogFileInExpectedDirectory && hasLogFileExtension) {
            passedValidationCheckCount++;
        }
        if (hasPasswordKeyword) {
            passedValidationCheckCount++;
        }
        int totalValidationCheckCount = 5;
        double validationPercent = (double) passedValidationCheckCount
                / totalValidationCheckCount * 100;
        String formattedValidationResult =
                String.format(Locale.GERMANY, "Validation: %.1f%%", validationPercent);

        String formattedServiceTable =
                String.format("%-15s | %-7s | %s\n", "Service", "Level", "File")
                + String.format("%-15s | %-7s | %s\n", serviceName, eventLevel, logFileName);
        String escapedDiagnosticMessage = "Source:\t\"" + logFilePath
                + "\"\nLevel:\t\"" + eventLevel + "\"";
        String warningSymbol = "\u26A0";
        String reportBanner = """
                System Log Processing Report
                """;

        String reversedIncidentCode = reverseIncidentCode(incidentCode);
        StringBuilder builderOne = new StringBuilder("INCIDENT");
        StringBuilder builderTwo = new StringBuilder("INCIDENT");
        boolean hasEqualBuilderContent = builderOne.toString().equals(builderTwo.toString());

        System.out.print(reportBanner);
        System.out.print(formattedServiceTable);
        System.out.println(escapedDiagnosticMessage);
        System.out.print(buildIncidentReport(
                incidentCode,
                eventLevel,
                serviceName,
                maskedEmail,
                emailDomain,
                logFileName,
                incidentMessage,
                incidentCodeDigitCount,
                serviceNameOrder,
                validationPercent,
                passedValidationCheckCount,
                totalValidationCheckCount,
                isErrorEvent,
                warningSymbol
        ));
        System.out.println(reversedIncidentCode);
    }
}
