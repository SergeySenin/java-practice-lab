Задание 10. Система управления развёртыванием приложения (Deployment Control System)

Программа читает конфигурацию как текст, преобразует значения, выбирает окружение и порт,
обрабатывает команду оператора и выводит отчёт. Команды моделируются строками:
запускать внешние процессы или действительно развёртывать приложение не требуется.

Задание закрепляет обёртки, упаковку и распаковку, `null`, `var`, `final`,
константы, перечисления и два вида `switch`. Используйте Java 17 или Java 21.

## 1. Структура проекта

Создайте три файла в одном пакете задания:

* `Solution.java`              — публичный класс «решение» (`Solution`);
* `DeploymentEnvironment.java` — публичное перечисление
  «окружение развёртывания» (`DeploymentEnvironment`);
* `DeploymentSettings.java`    — публичный класс «настройки развёртывания» (`DeploymentSettings`).

В `Solution` создайте `public static void main(String[] args)`;
`args` — аргументы командной строки типа `String[]`.
Подключите `java.util.Scanner` и `java.util.Locale`.

Выводите через `System.out.println`, а готовый журнал с переводами строк — через `System.out.print`.
Данные в образцах заменяйте значениями переменных и констант, сохраняя пробелы в подписях.

## 2. Этап 1. Перечисление окружений

В `DeploymentEnvironment` объявите значения в указанном порядке:

* `DEVELOPMENT` — разработка;
* `TESTING`     — тестирование;
* `STAGING`     — предварительное окружение перед выпуском;
* `PRODUCTION`  — рабочее окружение.

Имена записывайте заглавными буквами. После преобразования ввода используйте этот отдельный тип,
а не произвольные строки или числовые коды окружений.

## 3. Этап 2. Класс системных констант

В `DeploymentSettings` объявите следующие поля с модификаторами `public static final`:

| Константа          | Тип      | Значение        |
|--------------------|----------|-----------------|
| `APPLICATION_NAME` | `String` | `"JavaService"` |
| `MAX_RETRY_COUNT`  | `int`    | `5`             |
| `DEFAULT_PORT`     | `int`    | `8080`          |
| `STAGING_PORT`     | `int`    | `8443`          |
| `PRODUCTION_PORT`  | `int`    | `443`           |

`APPLICATION_NAME` — название приложения; `MAX_RETRY_COUNT`         — максимум повторных попыток;
`DEFAULT_PORT`     — порт разработки и тестирования; `STAGING_PORT` — предварительный порт;
`PRODUCTION_PORT`  — рабочий порт. Сохраняйте стиль имён `UPPER_SNAKE_CASE`.

## 4. Этап 3. Использование констант через имя класса

Обращайтесь к константам как `DeploymentSettings.APPLICATION_NAME`,
`DeploymentSettings.MAX_RETRY_COUNT` и аналогично для портов.
Объект `new DeploymentSettings()` для чтения констант не создавайте.

`static` означает принадлежность классу; `final` запрещает переназначение поля.
Общая константа класса отличается от локальной `final`-переменной отдельного вызова `main`.

## 5. Этап 4. Ввод конфигурации

Создайте «консоль» (`console`) типа `Scanner` с источником `System.in`.
Через `nextLine()` последовательно получите восемь переменных типа `String`:

1. «окружение развёртывания» (`deploymentEnvironmentInput`);
2. «команда оператора» (`operatorCommandInput`);
3. «количество попыток текстом» (`retryCountText`);
4. «режим проверки текстом» (`dryRunText`);
5. «ограничение процессора текстом» (`cpuLimitPercentText`);
6. «ручной порт текстом» (`manualPortText`);
7. «символ номера выпуска» (`releaseCharacterInput`);
8. «диагностическое значение мониторинга» (`monitoringValueText`).

Основной ввод:

```text
production
deploy
3
true
75.5
auto
7
NaN
```

Числовые строки считаются корректными для соответствующего преобразования,
строка символа выпуска — непустой. Обрабатывать ошибки ввода чисел пока не требуется.
Слово `auto` вводится именно в нижнем регистре; окружение и команда нормализуются далее.

## 6. Этап 5. Использование `var`

Через `var` объявляйте локальные переменные «нормализованное имя окружения»
(`normalizedEnvironmentName`), «нормализованная команда» (`normalizedCommand`)
и «доступные окружения» (`availableEnvironments`).
Инициализируйте их сразу на этапах 6 и 8; не объявляйте повторно.

Тип выводится из правой части: первые две переменные получат `String`,
третья — `DeploymentEnvironment[]`. После объявления тип фиксирован.
`var` нельзя применять к полю, параметру метода, объявлению без значения или только с `null`.

## 7. Этап 6. Нормализация пользовательского ввода

Для `normalizedEnvironmentName` очистите `deploymentEnvironmentInput` через `trim()`
и примените `toUpperCase(Locale.ROOT)`.

Для `normalizedCommand` очистите `operatorCommandInput` через `trim()`
и примените `toLowerCase(Locale.ROOT)`.

`Locale.ROOT` делает преобразование технических имён независимым от языка компьютера.
Ожидаются `PRODUCTION` и `deploy` соответственно.

## 8. Этап 7. Преобразование строки в `enum`

Создайте «целевое окружение» (`deploymentEnvironment`) типа `DeploymentEnvironment`
через `DeploymentEnvironment.valueOf(normalizedEnvironmentName)`.

Для основного ввода получится `DeploymentEnvironment.PRODUCTION`.
Предполагается существующее имя окружения; обработка `IllegalArgumentException` не требуется.

## 9. Этап 8. `values`

В `availableEnvironments` через `var` сохраните `DeploymentEnvironment.values()`.
Не создавайте отдельный массив вручную.

Циклом `for-each` выведите элементы: «доступное окружение» (`availableEnvironment`)
имеет тип `DeploymentEnvironment`. Перед циклом выведите заголовок:

```text
Available environments:
DEVELOPMENT
TESTING
STAGING
PRODUCTION
```

## 10. Этап 9. `name`

Создайте «имя окружения развёртывания» (`deploymentEnvironmentName`) типа `String`
через `deploymentEnvironment.name()`. Для основного теста ожидается `PRODUCTION`.

## 11. Этап 10. `ordinal` и сравнение перечислений

Создайте «порядковый номер окружения» (`deploymentEnvironmentOrdinal`) типа `int`
через `deploymentEnvironment.ordinal()` и выведите его для диагностики.
При указанном порядке `PRODUCTION` имеет номер `3`.

Создайте «выбрано рабочее окружение» (`isProductionEnvironment`) типа `boolean`,
сравнив `deploymentEnvironment == DeploymentEnvironment.PRODUCTION`,
и также выведите результат. Для основного теста он равен `true`.

`==` подходит для сравнения значений `enum`.
`ordinal` используется только для наблюдения:
не выбирайте по его числу порт, разрешение развёртывания или другие правила.

## 12. Этап 11. Преобразование количества попыток

Через `Integer.parseInt(retryCountText)` получите «запрошенное количество попыток»
(`requestedRetryCount`) типа `int`. Для основного теста ожидается `3`.

## 13. Этап 12. Ручная упаковка `Integer`

Создайте «упакованное количество попыток» (`boxedRetryCount`) типа `Integer`
через `Integer.valueOf(requestedRetryCount)`.
Это явная упаковка (boxing): примитив `int` превращается в объект-обёртку.

## 14. Этап 13. Ручная распаковка `Integer`

Создайте «распакованное количество попыток» (`unboxedRetryCount`) типа `int`
через `boxedRetryCount.intValue()`. Это явная распаковка (unboxing), результат — `3`.

## 15. Этап 14. Автоупаковка и автораспаковка `Integer`

Создайте «автоматически упакованное количество попыток» (`autoBoxedRetryCount`)
типа `Integer` и присвойте ей непосредственно `requestedRetryCount`.

Создайте «автоматически распакованное количество попыток» (`autoUnboxedRetryCount`)
типа `int` и присвойте ей `autoBoxedRetryCount`.

Здесь не вызывайте `valueOf` и `intValue` явно: преобразования `int → Integer → int`
добавляет компилятор. Обе пары переменных должны присутствовать в программе.

## 16. Этап 15. Применение максимального количества попыток

Создайте «фактическое количество попыток» (`effectiveRetryCount`) типа `int`,
первоначально равное `requestedRetryCount`.
Если запрос превышает `DeploymentSettings.MAX_RETRY_COUNT`, используйте значение константы.

Для запроса `9` получится `5`. Не подставляйте число `5` вместо константы в условие.
Здесь задаётся только верхняя граница; дополнительные ограничения количества попыток не вводите.

## 17. Этап 16. `Boolean.parseBoolean`

Создайте «настройка режима проверки» (`dryRunSetting`) типа `Boolean`.
Присвойте результат `Boolean.parseBoolean(dryRunText)`:
возвращённый примитив `boolean` автоматически упакуется. Для основного ввода ожидается `true`.

## 18. Этап 17. Автораспаковка `Boolean`

Создайте «режим проверки включён» (`isDryRunEnabled`) типа `boolean`
и присвойте ей `dryRunSetting`. Произойдёт автораспаковка `Boolean → boolean`.

## 19. Этап 18. `Double.parseDouble`

Создайте «ограничение процессора в процентах» (`cpuLimitPercent`) типа `Double`
через `Double.parseDouble(cpuLimitPercentText)`.
Возвращённый `double` автоматически упакуется; для основного теста ожидается `75.5`.

## 20. Этап 19. Автораспаковка `Double`

Создайте «числовое ограничение процессора» (`cpuLimitPercentValue`) типа `double`
и присвойте ей `cpuLimitPercent`: произойдёт автораспаковка `Double → double`.

## 21. Этап 20. Проверка `NaN` через `Double`

Создайте «значение мониторинга» (`monitoringValue`) типа `double`
через `Double.parseDouble(monitoringValueText)`.

В «значение мониторинга не является числом» (`isMonitoringValueNaN`) типа `boolean`
сохраните `Double.isNaN(monitoringValue)`. Строка `"NaN"` даёт `NaN` и результат `true`.
Не проверяйте `NaN` выражением `monitoringValue == Double.NaN`.

## 22. Этап 21. `Character`

Через `releaseCharacterInput.charAt(0)` получите «символ выпуска» (`releaseCharacter`)
типа `char`; для основного теста это `'7'`.

В «символ выпуска является цифрой» (`isReleaseCharacterDigit`) типа `boolean`
сохраните `Character.isDigit(releaseCharacter)`. Ожидается `true`.

Создайте «обёрнутый символ выпуска» (`wrappedReleaseCharacter`) типа `Character`
и присвойте ей `releaseCharacter`, используя автоупаковку.

## 23. Этап 22. Nullable `Integer`

Создайте «ручной порт» (`manualPort`) типа `Integer`.
Если `manualPortText.equals("auto")`, присвойте `null`.
Иначе преобразуйте число через `Integer.parseInt` и сохраните в `manualPort`.

Для основного теста ожидается `null` — ручной порт не задан.
`Integer` может хранить ссылку на объект или `null`; примитив `int` хранит число
и не может обозначать отсутствие значения через `null`.

## 24. Этап 23. Автоматический порт через современный `switch`

Создайте «автоматический порт» (`automaticPort`) типа `int`.
Присвойте ему результат `switch`-выражения по `deploymentEnvironment`:

* `DEVELOPMENT` и `TESTING` объедините в одном `case` через запятую;
  результат — `DeploymentSettings.DEFAULT_PORT`.
* Для `STAGING` результат — `DeploymentSettings.STAGING_PORT`.
* Для `PRODUCTION` используйте блок после `->`: выведите
  `"Production environment selected."`
  и верните `DeploymentSettings.PRODUCTION_PORT` через `yield`.

Стрелочные ветки не требуют `break` и не проваливаются в следующую ветку.
Охватите все четыре значения перечисления. Для основного теста порт равен `443`.

## 25. Этап 24. Определение фактического порта

Создайте «фактический порт» (`effectivePort`) типа `int`.
При `manualPort != null` используйте ручное значение с автораспаковкой.
Иначе используйте `automaticPort`.

Проверка `null` должна предшествовать распаковке. Ручной порт имеет приоритет.
Для основного теста ожидается `443`.

## 26. Этап 25. Локальная `final`-переменная

Создайте «идентификатор развёртывания» (`deploymentId`) через `final var`.
Соедините `DeploymentSettings.APPLICATION_NAME`, `deploymentEnvironmentName`
и `releaseCharacter` дефисами. Выведенный тип — `String`.

Основной результат: `JavaService-PRODUCTION-7`.
После инициализации не переназначайте переменную.

## 27. Этап 26. `final`-ссылка на изменяемый объект

Через `final var` создайте «журнал развёртывания» (`deploymentLog`)
с новым `StringBuilder`. Последовательными `append` добавьте строки:

```text
Deployment ID: JavaService-PRODUCTION-7
Environment:   PRODUCTION
Port:          443
```

Подставляйте `deploymentId`, `deploymentEnvironmentName` и `effectivePort`.
Добавляйте `\n` после каждой строки.

`final` запрещает заменить ссылку, но не запрещает менять содержимое этого построителя.

## 28. Этап 27. Классический `switch` для команды

Создайте «категория команды» (`commandCategory`) типа `String`.
Обработайте `normalizedCommand` классическим `switch` с `case ...:`, `break` и `default`:

| Команда         | Категория     |
|-----------------|---------------|
| `build`, `test` | `PREPARATION` |
| `deploy`        | `DEPLOYMENT`  |
| `status`        | `INFORMATION` |
| любая другая    | `UNKNOWN`     |

`build` и `test` объедините двумя последовательными `case` перед общим присваиванием.
Завершайте рабочие ветки через `break`. В `default` задайте `UNKNOWN`.
Для основного ввода ожидается `DEPLOYMENT`.

Классический `switch` выбирает по конкретным значениям;
диапазон процессора проверяется логическим выражением на этапе 30.

## 29. Этап 28. Современное `switch`-выражение для сообщения

Создайте «сообщение команды» (`commandMessage`) типа `String`.
Непосредственно присвойте результат `switch`-выражения по `normalizedCommand`:

```text
build   → Build process selected.
test    → Test process selected.
deploy  → Deployment process selected.
status  → Status information requested.
default → Unknown command.
```

Используйте `case ... -> ...`, включая `default` для неизвестной команды.
`break` в стрелочные ветки не добавляйте.

## 30. Этап 29. Режим развёртывания

Создайте «режим выполнения» (`executionMode`) типа `String`.
При `isDryRunEnabled` используйте `"DRY_RUN"`, иначе `"LIVE"`.
Можно применить тернарный оператор. Для основного теста ожидается `DRY_RUN`.

## 31. Этап 30. Итоговая готовность

Создайте «развёртывание разрешено» (`isDeploymentAllowed`) типа `boolean`.
Все следующие условия должны выполняться одновременно:

* `commandCategory` равна `"DEPLOYMENT"` по `equals`;
* `isReleaseCharacterDigit` равно `true`;
* `effectiveRetryCount` не превышает `DeploymentSettings.MAX_RETRY_COUNT`;
* `cpuLimitPercentValue` больше `0` и не больше `100`.

Для основного теста ожидается `true`.
Режим проверки и значение мониторинга сами по себе не запрещают развёртывание
в правилах этого учебного задания.

## 32. Этап 31. Обновление `deploymentLog`

Добавьте через `append` следующие строки с переводом строки после каждой:

```text
Command:            deploy
Command category:   DEPLOYMENT
Execution mode:     DRY_RUN
Retry count:        3
CPU limit:          75.5
Deployment allowed: true
```

Источники по порядку: `normalizedCommand`, `commandCategory`, `executionMode`,
`effectiveRetryCount`, `cpuLimitPercentValue`, `isDeploymentAllowed`.
Затем выведите весь `deploymentLog`, включая первые три строки этапа 26.

## 33. Этап 32. Итоговый отчёт

Выведите отчёт из переменных и констант, не вписывая вычисленные результаты вручную:

```text
Application:                JavaService
Deployment ID:              JavaService-PRODUCTION-7
Environment:                PRODUCTION
Environment ordinal:        3
Command:                    deploy
Command category:           DEPLOYMENT
Command message:            Deployment process selected.
Execution mode:             DRY_RUN
Requested retries:          3
Effective retries:          3
CPU limit:                  75.5
Manual port:                null
Automatic port:             443
Effective port:             443
Release character:          7
Release character is digit: true
Monitoring value:           NaN
Monitoring value is NaN:    true
Deployment allowed:         true
```

Источники строк по порядку:

1. `DeploymentSettings.APPLICATION_NAME`;
2. `deploymentId`;
3. `deploymentEnvironmentName`;
4. `deploymentEnvironmentOrdinal`;
5. `normalizedCommand`;
6. `commandCategory`;
7. `commandMessage`;
8. `executionMode`;
9. `requestedRetryCount`;
10. `effectiveRetryCount`;
11. `cpuLimitPercentValue`;
12. `manualPort`;
13. `automaticPort`;
14. `effectivePort`;
15. `releaseCharacter`;
16. `isReleaseCharacterDigit`;
17. `monitoringValue`;
18. `isMonitoringValueNaN`;
19. `isDeploymentAllowed`.

## 34. Диагностические эксперименты

Выполняйте опыты по одному после получения рабочей программы.
После каждого удаляйте временные объявления и вывод; ошибочные строки удаляйте или комментируйте.
Итоговая версия должна снова компилироваться и проходить тесты.

### Диагностический эксперимент 1. `Integer` и `equals`

Создайте четыре `Integer`: «первое малое значение» (`firstSmallValue`)
и «второе малое значение» (`secondSmallValue`), оба `100`;
«первое большое значение» (`firstLargeValue`)
и «второе большое значение» (`secondLargeValue`), оба `200`.

Выведите сравнения каждой пары через `==` и `equals`.
Оба сравнения содержимого дают `true`; `==` проверяет ссылки.
Малые значения могут использовать кэшированные объекты; для `200` не закрепляйте
результат `==` как обязательный. Для сравнения значений обёрток используйте `equals`.

### Диагностический эксперимент 2. `null` и автораспаковка

В основном тесте `manualPort == null`.
Временно объявите «порт для опыта» (`port`) строкой `int port = manualPort;`.
При выполнении ожидается `NullPointerException`: распаковать отсутствующий объект нельзя.
Верните рабочую проверку `manualPort != null` перед распаковкой.

### Диагностический эксперимент 3. `final`-примитив

В `main` объявите «тестовый лимит» (`testLimit`) как `final int testLimit = 10;`.
Присваивание `testLimit = 20;` должно дать ошибку компиляции.

### Диагностический эксперимент 4. `final`-ссылка

После `final var deploymentLog = new StringBuilder();` вызов `append` допустим.
Временно попробуйте `deploymentLog = new StringBuilder();`:
ожидается ошибка компиляции. Объясните разницу между изменением объекта и заменой ссылки.

### Диагностический эксперимент 5. `var` без значения

По отдельности проверьте `var unknownValue;` и `var unknownValue = null;`.
«Неизвестное значение» (`unknownValue`) не получает выводимого типа в обоих случаях,
поэтому оба объявления должны дать ошибку компиляции.

### Диагностический эксперимент 6. `var` фиксирует тип

Создайте «временное значение» (`temporaryValue`) через `var temporaryValue = 10;`.
Компилятор выведет `int`. Присваивание `temporaryValue = "ten";` должно дать ошибку компиляции.
`var` не делает тип динамическим.

### Диагностический эксперимент 7. Проваливание классического `switch`

Временно удалите `break` после присваивания категории `DEPLOYMENT`
в ветке `deploy`, перед веткой `status`. Запустите основной ввод:
следующее присваивание заменит категорию на `INFORMATION`, и разрешение станет `false`.

Верните `break`. Объясните, почему проваливание (fall-through) появилось в классическом
`switch` и не появляется между стрелочными ветками современного варианта.

## 35. Дополнительные тесты

### Дополнительный тест 1. DEVELOPMENT

Введите:

```text
development
build
9
false
50.0
auto
4
10.5
```

Ожидаются окружение `DEVELOPMENT`, автоматический и фактический порты `8080`,
ручной порт `null`. Запрошено `9` попыток, фактически `5` через константу максимума.
Категория `PREPARATION`, сообщение `Build process selected.`, режим `LIVE`.
Символ `'4'` является цифрой, мониторинг не `NaN`. Развёртывание не разрешено для команды `build`.

### Дополнительный тест 2. Ручной порт

Введите:

```text
staging
deploy
2
false
65.0
9090
8
42.0
```

Ожидаются `STAGING`, автоматический порт `8443`, ручной и фактический порты `9090`.
Ручное значение имеет приоритет. Развёртывание разрешено.

### Дополнительный тест 3. TESTING

Введите:

```text
testing
test
1
true
20.0
auto
2
0.0
```

Ожидаются `TESTING`, порт `8080`, категория `PREPARATION`,
сообщение `Test process selected.`. Развёртывание не разрешено для команды `test`.
Этот тест вместе с тестом 1 проверяет общую ветку `DEVELOPMENT, TESTING` выбора порта.

### Дополнительный тест 4. Неизвестная команда

Введите:

```text
production
restart
3
false
70.0
auto
5
5.5
```

Ожидаются категория `UNKNOWN`, сообщение `Unknown command.`,
`isDeploymentAllowed == false`. Обе конструкции `switch` обрабатывают команду через `default`.

### Дополнительный тест 5. Символ выпуска не является цифрой

В основном вводе замените седьмую строку на `A`.
`Character.isDigit('A')` и `isDeploymentAllowed` должны дать `false`.

### Дополнительный тест 6. Разный регистр окружения

Поочерёдно используйте в первой строке `production`, `PRODUCTION`, `PrOdUcTiOn`.
Остальные строки оставьте основными. Каждый вариант нормализуется в `PRODUCTION`
и успешно преобразуется через `DeploymentEnvironment.valueOf`.
