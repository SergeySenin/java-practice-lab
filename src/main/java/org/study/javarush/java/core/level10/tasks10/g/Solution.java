package org.study.javarush.java.core.level10.tasks10.g;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Сначала читаем все настройки как текст; преобразования выполняем ниже.
        String deploymentEnvironmentInput = console.nextLine();
        String operatorCommandInput       = console.nextLine();
        String retryCountText             = console.nextLine();
        String dryRunText                 = console.nextLine();
        String cpuLimitPercentText        = console.nextLine();
        String manualPortText             = console.nextLine();
        String releaseCharacterInput      = console.nextLine();
        String monitoringValueText        = console.nextLine();

        // ROOT исключает влияние языка системы, а valueOf требует точного имени константы enum.
        var normalizedEnvironmentName = deploymentEnvironmentInput.trim().toUpperCase(Locale.ROOT);
        var normalizedCommand         = operatorCommandInput.trim().toLowerCase(Locale.ROOT);

        DeploymentEnvironment deploymentEnvironment =
                DeploymentEnvironment.valueOf(normalizedEnvironmentName);

        var availableEnvironments = DeploymentEnvironment.values();

        System.out.println("Available environments:");

        for (DeploymentEnvironment availableEnvironment : availableEnvironments) {
            System.out.println(availableEnvironment);
        }

        // name — имя константы; ordinal — её позиция в объявлении, начиная с нуля.
        String deploymentEnvironmentName = deploymentEnvironment.name();
        int deploymentEnvironmentOrdinal = deploymentEnvironment.ordinal();

        System.out.println(deploymentEnvironmentOrdinal);

        // Константы одного enum можно сравнивать через ==.
        boolean isProductionEnvironment =
                deploymentEnvironment == DeploymentEnvironment.PRODUCTION;

        System.out.println(isProductionEnvironment);

        // Явная упаковка int в Integer и распаковка обратно в int.
        int requestedRetryCount = Integer.parseInt(retryCountText);
        Integer boxedRetryCount = Integer.valueOf(requestedRetryCount);
        int unboxedRetryCount   = boxedRetryCount.intValue();

        // Те же преобразования автоматически, при присваивании.
        Integer autoBoxedRetryCount = requestedRetryCount;
        int autoUnboxedRetryCount   = autoBoxedRetryCount;

        int effectiveRetryCount = requestedRetryCount;

        if (requestedRetryCount > DeploymentSettings.MAX_RETRY_COUNT) {
            effectiveRetryCount = DeploymentSettings.MAX_RETRY_COUNT;
        }

        // parseBoolean и parseDouble возвращают примитивы; присваивание обёртке упаковывает их.
        Boolean dryRunSetting   = Boolean.parseBoolean(dryRunText);
        boolean isDryRunEnabled = dryRunSetting;

        Double cpuLimitPercent      = Double.parseDouble(cpuLimitPercentText);
        double cpuLimitPercentValue = cpuLimitPercent;

        // Текст "NaN" превращается в особое значение; проверяем его методом isNaN.
        double monitoringValue       = Double.parseDouble(monitoringValueText);
        boolean isMonitoringValueNaN = Double.isNaN(monitoringValue);

        // По условию строка непустая; Character.isDigit распознаёт также цифры Unicode.
        char releaseCharacter             = releaseCharacterInput.charAt(0);
        boolean isReleaseCharacterDigit   = Character.isDigit(releaseCharacter);
        Character wrappedReleaseCharacter = releaseCharacter;

        // null означает, что ручной порт не задан. Примитив int хранить null не может.
        Integer manualPort;

        if (manualPortText.equals("auto")) {
            manualPort = null;
        } else {
            manualPort = Integer.parseInt(manualPortText);
        }

        // switch-выражение возвращает порт. Из ветки с блоком значение передаёт yield.
        int automaticPort = switch (deploymentEnvironment) {
            case DEVELOPMENT, TESTING -> DeploymentSettings.DEFAULT_PORT;
            case STAGING              -> DeploymentSettings.STAGING_PORT;
            case PRODUCTION           -> {
                System.out.println("Production environment selected.");
                yield DeploymentSettings.PRODUCTION_PORT;
            }
        };

        // До распаковки Integer проверяем null; заданный вручную порт имеет приоритет.
        int effectivePort;

        if (manualPort != null) {
            effectivePort = manualPort;
        } else {
            effectivePort = automaticPort;
        }

        // var выводит тип из правой части: здесь String, ниже StringBuilder.
        final var deploymentId =
                DeploymentSettings.APPLICATION_NAME + "-" + deploymentEnvironmentName
                        + "-" + releaseCharacter;

        // final запрещает заменить ссылку, но содержимое StringBuilder можно дополнять.
        final var deploymentLog = new StringBuilder();

        deploymentLog.append("Deployment ID: ").append(deploymentId)              .append("\n");
        deploymentLog.append("Environment:   ").append(deploymentEnvironmentName) .append("\n");
        deploymentLog.append("Port:          ").append(effectivePort)             .append("\n");

        // build и test используют общий блок. break завершает switch после выбранного блока.
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

        // Вариант со стрелками сразу возвращает сообщение; перехода в соседнюю ветку нет.
        String commandMessage = switch (normalizedCommand) {
            case "build"  -> "Build process selected.";
            case "test"   -> "Test process selected.";
            case "deploy" -> "Deployment process selected.";
            case "status" -> "Status information requested.";
            default       -> "Unknown command.";
        };

        String executionMode = isDryRunEnabled ? "DRY_RUN" : "LIVE";

        // Все условия обязательны. Для NaN проверки диапазона CPU дают false.
        // Режим DRY_RUN не входит в эти проверки: он меняет только подпись режима.
        boolean isDeploymentAllowed =
                commandCategory.equals("DEPLOYMENT")
                        && isReleaseCharacterDigit
                        && effectiveRetryCount <= DeploymentSettings.MAX_RETRY_COUNT
                        && cpuLimitPercentValue > 0
                        && cpuLimitPercentValue <= 100;

        // Дополняем тот же журнал после обработки команды.
        deploymentLog.append("Command:            ").append(normalizedCommand)    .append("\n");
        deploymentLog.append("Command category:   ").append(commandCategory)      .append("\n");
        deploymentLog.append("Execution mode:     ").append(executionMode)        .append("\n");
        deploymentLog.append("Retry count:        ").append(effectiveRetryCount)  .append("\n");
        deploymentLog.append("CPU limit:          ").append(cpuLimitPercentValue) .append("\n");
        deploymentLog.append("Deployment allowed: ").append(isDeploymentAllowed)  .append("\n");

        System.out.print(deploymentLog);

        // Итоговый отчёт: окружение и команда.
        System.out.println("Application:                " + DeploymentSettings.APPLICATION_NAME);
        System.out.println("Deployment ID:              " + deploymentId);
        System.out.println("Environment:                " + deploymentEnvironmentName);
        System.out.println("Environment ordinal:        " + deploymentEnvironmentOrdinal);

        System.out.println("Command:                    " + normalizedCommand);
        System.out.println("Command category:           " + commandCategory);
        System.out.println("Command message:            " + commandMessage);
        System.out.println("Execution mode:             " + executionMode);

        // Числовые ограничения и выбор порта.
        System.out.println("Requested retries:          " + requestedRetryCount);
        System.out.println("Effective retries:          " + effectiveRetryCount);
        System.out.println("CPU limit:                  " + cpuLimitPercentValue);

        System.out.println("Manual port:                " + manualPort);
        System.out.println("Automatic port:             " + automaticPort);
        System.out.println("Effective port:             " + effectivePort);

        // Диагностика и окончательное решение.
        System.out.println("Release character:          " + releaseCharacter);
        System.out.println("Release character is digit: " + isReleaseCharacterDigit);

        System.out.println("Monitoring value:           " + monitoringValue);
        System.out.println("Monitoring value is NaN:    " + isMonitoringValueNaN);

        System.out.println("Deployment allowed:         " + isDeploymentAllowed);
    }
}
