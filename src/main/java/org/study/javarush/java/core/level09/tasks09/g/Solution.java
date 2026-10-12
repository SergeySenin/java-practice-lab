package org.study.javarush.java.core.level09.tasks09.g;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

    // Собираем отчёт в изменяемом StringBuilder, а наружу возвращаем готовую строку.
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

        // Заменяем только PENDING: начальная граница включается, конечная — нет.
        int statusStartIndex = "STATUS:        ".length();
        int statusEndIndex   = statusStartIndex + "PENDING".length();

        String validationStatus =
                passedValidationCheckCount == totalValidationCheckCount
                        ? "VALIDATED"
                        : "REVIEW";

        reportBuilder.replace(statusStartIndex, statusEndIndex, validationStatus);

        reportBuilder.append("Incident:      ").append(incidentCode)    .append("\n");
        reportBuilder.append("Level:         ").append(eventLevel)      .append("\n");
        reportBuilder.append("Service:       ").append(serviceName)     .append("\n");
        reportBuilder.append("Email:         ").append(maskedEmail)     .append("\n");
        reportBuilder.append("Domain:        ").append(emailDomain)     .append("\n");
        reportBuilder.append("File:          ").append(logFileName)     .append("\n");
        reportBuilder.append("Message:       ").append(incidentMessage) .append("\n");

        reportBuilder.append(String.format("Code digits:   %d\n", incidentCodeDigitCount));
        reportBuilder.append("Service order: ").append(serviceNameOrder).append("\n");
        reportBuilder.append(String.format(Locale.GERMANY, "Validation:    %.1f%%\n", validationPercent));

        // Вставка в позицию 0 добавляет предупреждение перед уже собранным отчётом.
        if (isErrorEvent) {
            reportBuilder.insert(0, warningSymbol + " [CRITICAL]\n");
        }

        // Учебный опыт с delete: временная строка удаляется и в результат не попадает.
        int temporaryLineStartIndex = reportBuilder.length();

        reportBuilder.append("TEMPORARY LINE\n");
        reportBuilder.delete(temporaryLineStartIndex, reportBuilder.length());

        return reportBuilder.toString();
    }

    // Разворачиваем отдельный StringBuilder; исходный incidentCode не меняется.
    public static String reverseIncidentCode(String incidentCode) {
        StringBuilder reversedCodeBuilder = new StringBuilder(incidentCode);

        reversedCodeBuilder.reverse();

        return reversedCodeBuilder.toString();
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Структуру записи проверяем до обращения к полям по индексам.
        String logEntryInput = console.nextLine();

        // split принимает регулярное выражение: \| означает буквальный разделитель.
        // Значение -1 сохраняет пустое последнее поле, например отсутствующее сообщение.
        String[] logFields               = logEntryInput.split("\\|", -1);
        boolean hasExpectedLogFieldCount = logFields.length == 6;

        if (!hasExpectedLogFieldCount) {
            System.out.println("Invalid log structure.");
            return;
        }

        // String неизменяем: результаты очистки сохраняем в отдельных переменных.
        // strip удаляет также пробельные символы Unicode, которые trim может оставить.
        String incidentCode    = logFields[0].trim();
        String eventLevel      = logFields[1].trim();
        String serviceName     = logFields[2].trim();
        String email           = logFields[3].trim();
        String logFilePath     = logFields[4].trim();
        String incidentMessage = logFields[5].strip();

        // ROOT делает изменение регистра независимым от языковых настроек компьютера.
        eventLevel = eventLevel.toUpperCase(Locale.ROOT);

        int incidentCodeLength    = incidentCode.length();
        int incidentMessageLength = incidentMessage.length();

        // У пустой строки нет символа с индексом 0: завершаем main до charAt.
        if (incidentCode.isEmpty()) {
            System.out.println("Invalid incident code.");
            return;
        }

        char firstCodeCharacter        = incidentCode.charAt(0);
        boolean hasValidIncidentPrefix = incidentCode.startsWith("INC-");

        // По условию считаем только цифры от '0' до '9'.
        char[] incidentCodeCharacters = incidentCode.toCharArray();
        int incidentCodeDigitCount    = 0;

        for (char codeCharacter : incidentCodeCharacters) {
            if (codeCharacter >= '0' && codeCharacter <= '9') {
                incidentCodeDigitCount++;
            }
        }

        // indexOf возвращает -1, если @ нет; домен начинается после найденного символа.
        int emailAtSignIndex = email.indexOf('@');
        String emailDomain;

        if (emailAtSignIndex != -1) {
            emailDomain = email.substring(emailAtSignIndex + 1).toLowerCase(Locale.ROOT);
        } else {
            emailDomain = "";
        }

        String registeredEmail    = "user@example.com";
        boolean isRegisteredEmail = email.equalsIgnoreCase(registeredEmail);
        boolean isErrorEvent      = eventLevel.equals("ERROR");

        String lowerCaseIncidentMessage = incidentMessage.toLowerCase(Locale.ROOT);
        boolean hasPasswordKeyword      = lowerCaseIncidentMessage.contains("password");

        // Проверяем текст пути; существование файла на диске здесь не проверяется.
        String expectedLogDirectory          = "C:\\Logs\\";
        boolean isLogFileInExpectedDirectory = logFilePath.startsWith(expectedLogDirectory);
        boolean hasLogFileExtension          = logFilePath.endsWith(".log");

        // Имя берём после последнего обратного слеша; без него используем весь путь.
        int lastPathSeparatorIndex = logFilePath.lastIndexOf('\\');
        String logFileName;

        if (lastPathSeparatorIndex != -1) {
            logFileName = logFilePath.substring(lastPathSeparatorIndex + 1);
        } else {
            logFileName = logFilePath;
        }

        String maskedEmail = email.replace("@", "[at]");

        // Для compareTo важен знак результата: он не обязан быть строго -1 или 1.
        String referenceServiceName = "billing-service";
        int serviceNameComparison   = serviceName.compareTo(referenceServiceName);
        String serviceNameOrder;

        if (serviceNameComparison < 0) {
            serviceNameOrder = "BEFORE";
        } else if (serviceNameComparison == 0) {
            serviceNameOrder = "SAME";
        } else {
            serviceNameOrder = "AFTER";
        }

        // Пять независимых проверок: несколько условий могут одновременно дать по одному баллу.
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

        // Приведение выполняется до деления, чтобы не потерять дробную часть.
        double validationPercent =
                (double) passedValidationCheckCount / totalValidationCheckCount * 100;

        // GERMANY задаёт десятичную запятую; %% печатает один знак процента.
        String formattedValidationResult =
                String.format(Locale.GERMANY, "Validation: %.1f%%", validationPercent);

        // Ширина столбцов задаёт минимум: длинное имя сервиса не обрезается.
        String formattedServiceTable =
                  String.format("%-15s | %-7s | %s\n", "Service", "Level", "File")
                + String.format("%-15s | %-7s | %s\n", serviceName, eventLevel, logFileName);

        String escapedDiagnosticMessage =
                  "Source:\t\"" + logFilePath
                + "\"\nLevel:\t\"" + eventLevel + "\"";

        String warningSymbol = "\u26A0";
        String reportBanner = """
                System Log Processing Report
                """;

        String reversedIncidentCode = reverseIncidentCode(incidentCode);

        // У StringBuilder equals не сравнивает текст; для этого получаем две строки.
        StringBuilder builderOne       = new StringBuilder("INCIDENT");
        StringBuilder builderTwo       = new StringBuilder("INCIDENT");
        boolean hasEqualBuilderContent = builderOne.toString().equals(builderTwo.toString());

        // Готовые строки уже содержат переводы строк: print не добавляет лишний.
        System.out.print(reportBanner);
        System.out.print(formattedServiceTable);
        System.out.println(escapedDiagnosticMessage);

        System.out.print(
                buildIncidentReport(
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
                )
        );

        System.out.println(reversedIncidentCode);
    }
}
