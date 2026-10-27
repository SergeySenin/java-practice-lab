Задание 09. Анализатор журналов инцидентов (Incident Log Analyzer)

Программа получает одну запись журнала, очищает и проверяет её поля,
извлекает части строк и собирает отчёт об инциденте.

Задание закрепляет работу с неизменяемым `String` и изменяемым `StringBuilder`,
сравнение, преобразование и форматирование строк.

Используйте Java 17 или Java 21. Сторонние библиотеки не требуются.

## 1. Структура программы

В пакете задания создайте публичный класс «решение» (`Solution`) и метод
`public static void main(String[] args)`; `args` — аргументы командной строки типа `String[]`.
Используйте Java 17 или Java 21. Подключите `java.util.Locale` и `java.util.Scanner`.

Создайте «консоль» (`console`) типа `Scanner` с источником `System.in`.
Для вывода используйте `System.out.print` или `System.out.println` с учётом уже добавленных
переводов строк. Значения для отчёта берите из переменных, сохраняя пробелы в образцах.

Результаты `trim`, `strip`, изменения регистра, `replace` и `substring` нужно сохранять:
они не изменяют исходный объект `String`. Для сравнения текста применяйте `equals`,
`equalsIgnoreCase` или `compareTo` по условию этапа, а не `==`.

## 2. Этап 1. Формат входной строки

Через `nextLine()` получите «исходную запись журнала» (`logEntryInput`) типа `String`.
Формат содержит ровно шесть полей:

```text
код | уровень | сервис | email | путь к журналу | сообщение
```

Основной ввод — одна строка, включая пробелы вокруг разделителей:

```text
INC-5042 | error | auth-service | User@Example.com | C:\Logs\auth.log | Invalid password for "admin"
```

В консоль вводите обычные обратные слеши и кавычки:
Java-экранирование относится к литералам в исходном коде, а не к набираемому тексту.

## 3. Этап 2. Разделение строки

Создайте «поля записи журнала» (`logFields`) типа `String[]`
через `logEntryInput.split("\\|", -1)`.

Первый аргумент — регулярное выражение: `|` нужно экранировать для regex,
а обратный слеш — ещё раз для Java-литерала. Второй аргумент `-1` сохраняет пустое последнее поле,
чтобы пустое сообщение не меняло количество полей. Для основного ввода длина массива равна `6`.

## 4. Этап 3. Проверка количества полей

Создайте «получено ожидаемое количество полей» (`hasExpectedLogFieldCount`) типа `boolean`:
сравните `logFields.length` с `6`.

Если количество другое, выведите строку ниже и завершите `main` через `return;`
до обращения к элементам массива:

```text
Invalid log structure.
```

## 5. Этап 4. Извлечение полей

Получите шесть переменных типа `String` по порядку индексов `0–5`:

* «код инцидента» (`incidentCode`);
* «уровень события» (`eventLevel`);
* «название сервиса» (`serviceName`);
* «электронная почта» (`email`);
* «путь к файлу журнала» (`logFilePath`);
* «сообщение инцидента» (`incidentMessage`).

Для первых пяти используйте `trim()`, для сообщения — `strip()`.
После очистки должны получиться исходные значения без пробелов по краям:

```text
incidentCode    → INC-5042
eventLevel      → error
serviceName     → auth-service
email           → User@Example.com
logFilePath     → C:\Logs\auth.log
incidentMessage → Invalid password for "admin"
```

## 6. Этап 5. Нормализация уровня события

Преобразуйте `eventLevel` через `toUpperCase(Locale.ROOT)` и сохраните обратно.
Ожидается `ERROR`. `Locale.ROOT` задаёт независимое от языка компьютера преобразование
технических обозначений; используйте её и при `toLowerCase` на следующих этапах.

## 7. Этап 6. Анализ длины строк

Методом `length()` получите две переменные типа `int`:

* «длина кода инцидента» (`incidentCodeLength`)         — `8` для основного ввода;
* «длина сообщения инцидента» (`incidentMessageLength`) — `28`.

## 8. Этап 7. Первый символ кода

До `charAt(0)` проверьте, что `incidentCode` не пустой.
Для пустого кода выведите `"Invalid incident code."` и завершите `main` через `return;`.

Создайте «первый символ кода» (`firstCodeCharacter`) типа `char` через `charAt(0)`.
Для основного теста ожидается `'I'`. Допустимые индексы строки — от `0` до длины минус один.

## 9. Этап 8. Проверка префикса кода

Создайте «код имеет правильный префикс» (`hasValidIncidentPrefix`) типа `boolean`.
Через `startsWith("INC-")` проверьте `incidentCode`. Ожидается `true`.

## 10. Этап 9. Посимвольный анализ кода

Через `toCharArray()` получите «символы кода» (`incidentCodeCharacters`) типа `char[]`.
Создайте «количество цифр в коде инцидента» (`incidentCodeDigitCount`) типа `int`, начально `0`.

Переберите массив циклом `for-each`. Элемент «символ кода» (`codeCharacter`) имеет тип `char`.
Увеличивайте счётчик, если символ от `'0'` до `'9'` включительно.
Для `INC-5042` ожидается `4`. Здесь требуется именно проверка диапазона символов.

## 11. Этап 10. Поиск домена электронной почты

Через `email.indexOf('@')` получите «индекс символа @ в email» (`emailAtSignIndex`)
типа `int`. Результат `-1` означает, что символ не найден.

Создайте «домен электронной почты» (`emailDomain`) типа `String`.
Если `@` найден, извлеките `substring(emailAtSignIndex + 1)` и преобразуйте в нижний регистр
через `toLowerCase(Locale.ROOT)`. Иначе присвойте `""` и продолжите обработку без `substring`.

Для основного теста получится `example.com`. Если `@` последний, домен также пустой.
В варианте `substring(start, end)` конечный индекс не включается в результат.

## 12. Этап 11. Сравнение email без учёта регистра

Создайте «зарегистрированный email» (`registeredEmail`)
типа `String` со значением `"user@example.com"`.
В «email совпадает» (`isRegisteredEmail`) типа `boolean` сохраните результат
`email.equalsIgnoreCase(registeredEmail)`. Ожидается `true`, несмотря на разный регистр.

## 13. Этап 12. Строгое сравнение уровня события

Создайте «событие является ошибкой» (`isErrorEvent`) типа `boolean`.
Сравните `eventLevel` со строкой `"ERROR"` через `equals()`. Ожидается `true`.

## 14. Этап 13. Проверка сообщения через `contains`

Создайте «сообщение инцидента в нижнем регистре» (`lowerCaseIncidentMessage`) типа `String`
через `incidentMessage.toLowerCase(Locale.ROOT)`.

В «сообщение содержит ключевое слово password» (`hasPasswordKeyword`) типа `boolean`
сохраните проверку `contains("password")`. Ожидается `true`.
Исходный `incidentMessage` не изменяйте.

## 15. Этап 14. Проверка пути к журналу

Создайте «ожидаемый каталог журналов» (`expectedLogDirectory`) типа `String`
со значением `C:\Logs\`; Java-литерал для него — `"C:\\Logs\\"`.

Получите две переменные типа `boolean`:

* «файл находится в ожидаемом каталоге» (`isLogFileInExpectedDirectory`) —
  проверка `logFilePath.startsWith(expectedLogDirectory)`;
* «файл имеет расширение журнала» (`hasLogFileExtension`)                —
  проверка `logFilePath.endsWith(".log")`.

Для основного теста обе равны `true`. Сравнения пути здесь учитывают регистр.

## 16. Этап 15. Извлечение имени файла

Через `logFilePath.lastIndexOf('\\')` получите «индекс последнего обратного слеша»
(`lastPathSeparatorIndex`) типа `int`. Если он не равен `-1`, извлеките часть
после него методом `substring`. Если слеша нет, именем считается весь `logFilePath`.

Сохраните результат в «имя файла журнала» (`logFileName`) типа `String`.
Для `C:\Logs\auth.log` ожидается `auth.log`. Путь, заканчивающийся слешем, даст пустое имя.

## 17. Этап 16. Маскирование email

Создайте «замаскированный email» (`maskedEmail`) типа `String`:
через `email.replace("@", "[at]")` замените символ `@` текстом `[at]`.

### Дополнительный тест 9. Неизменяемость `String`

Временно выведите `email` и `maskedEmail`. Ожидаются соответственно:

```text
User@Example.com
User[at]Example.com
```

Исходный `email` не меняется: метод возвращает результат для другой переменной.
После опыта удалите временный вывод.

## 18. Этап 17. Лексикографическое сравнение сервисов

Создайте «эталонное имя сервиса» (`referenceServiceName`) типа `String`
со значением `"billing-service"`.
В «результат сравнения имён сервисов» (`serviceNameComparison`) типа `int`
сохраните `serviceName.compareTo(referenceServiceName)`.

Создайте «положение имени сервиса» (`serviceNameOrder`) типа `String`:
`"BEFORE"` при отрицательном результате, `"SAME"` при нуле, `"AFTER"` при положительном.
Для `auth-service` и `billing-service` ожидается `BEFORE`.
Это диагностическая имитация алфавитной сортировки.
Учитывайте знак результата, а не только значения `-1` и `1`.

## 19. Этап 18. Подсчёт успешно пройденных проверок

Создайте «количество пройденных проверок» (`passedValidationCheckCount`) типа `int`, начально `0`.
Увеличивайте его отдельно за каждое истинное условие:

1. `hasValidIncidentPrefix`;
2. `isRegisteredEmail`;
3. `isErrorEvent`;
4. `isLogFileInExpectedDirectory && hasLogFileExtension`;
5. `hasPasswordKeyword`.

Создайте «общее количество проверок» (`totalValidationCheckCount`) типа `int` со значением `5`.
Для основного ввода пройдены все пять; две проверки пути вместе дают только один балл.

## 20. Этап 19. Процент успешных проверок

Создайте «процент успешных проверок» (`validationPercent`) типа `double`.
Вычислите `passedValidationCheckCount / totalValidationCheckCount * 100`,
приведя один операнд деления к `double` до деления. Ожидается `100.0`.

## 21. Этап 20. `String.format` и локаль

Создайте «форматированный результат проверки» (`formattedValidationResult`) типа `String`.
Используйте `String.format(Locale.GERMANY, "Validation: %.1f%%", validationPercent)`:
`%.1f` задаёт один дробный знак, `%%` выводит знак процента.

```text
Validation: 100,0%
```

Для `80.0` получится `Validation: 80,0%`. Это форматирование значений для показа,
в отличие от последовательного построения текста отчёта.

## 22. Этап 21. Форматированная строка таблицы

Через `String.format` создайте «форматированная таблица сервисов»
(`formattedServiceTable`) типа `String`, включая заголовок и строку данных:

```text
Service         | Level   | File
auth-service    | ERROR   | auth.log
```

Примените шаблон `"%-15s | %-7s | %s\n"` к каждой строке и соедините результаты.
`%s` подставляет строку; `-` выравнивает влево, числа задают минимальную ширину.
Последний столбец выводится без начального отступа. Длинные значения не обрезайте.

## 23. Этап 22. Экранированное диагностическое сообщение

Создайте «диагностическое сообщение» (`escapedDiagnosticMessage`) типа `String`.
Соедините подписи, `logFilePath` и `eventLevel`, используя `\n`, `\t` и `\"`:

```text
Source:	"C:\Logs\auth.log"
Level:	"ERROR"
```

Табуляции в образце намеренные. Обратные слеши пути уже находятся в `logFilePath`.

## 24. Этап 23. Unicode-символ

Создайте «значок предупреждения» (`warningSymbol`) типа `String`
из Java-литерала `"\u26A0"`. Получится `⚠`.
Не вставляйте символ непосредственно в исходный литерал.

## 25. Этап 24. Текстовый блок

Создайте «баннер отчёта» (`reportBanner`) типа `String`
с помощью текстового блока с тройными двойными кавычками:

```
"""
System Log Processing Report
"""
```

Не заменяйте текстовый блок конкатенациями с `\n`. Учтите завершающий перевод строки при выводе.

## 26. Этап 25. Метод построения отчёта

Создайте `public static` метод «построить отчёт инцидента» (`buildIncidentReport`),
возвращающий `String`. Он ничего не выводит и получает следующие параметры по порядку:

* `String incidentCode`            — код;
* `String eventLevel`              — нормализованный уровень;
* `String serviceName`             — сервис;
* `String maskedEmail`             — замаскированный email;
* `String emailDomain`             — домен;
* `String logFileName`             — имя файла;
* `String incidentMessage`         — исходное очищенное сообщение;
* `int incidentCodeDigitCount`     — количество цифр;
* `String serviceNameOrder`        — порядок имени сервиса;
* `double validationPercent`       — процент проверок;
* `int passedValidationCheckCount` — число пройденных проверок;
* `int totalValidationCheckCount`  — общее число проверок;
* `boolean isErrorEvent`           — признак ошибки;
* `String warningSymbol`           — предупреждающий символ.

В `main` передавайте одноимённые переменные. Этапы 26–31 выполняются внутри этого метода
с одним `StringBuilder`, без накопления длинного отчёта через `result = result + ...`.
Для простого соединения нескольких фрагментов обычный `+` допустим.

## 27. Этап 26. Создание `StringBuilder`

Создайте «построитель отчёта» (`reportBuilder`) типа `StringBuilder`
с начальным содержимым `"STATUS:        PENDING\n"`.
Пробелы после двоеточия соответствуют итоговому образцу.

## 28. Этап 27. `replace` у `StringBuilder`

Создайте «начальный индекс статуса» (`statusStartIndex`) типа `int`
из длины префикса `"STATUS:        "`.
«Конечный индекс статуса» (`statusEndIndex`) типа `int` равен начальному плюс длина `"PENDING"`.

Создайте «статус проверки» (`validationStatus`) типа `String`:
`"VALIDATED"`, если счётчики проверок равны, иначе `"REVIEW"`.
Через `reportBuilder.replace(statusStartIndex, statusEndIndex, validationStatus)`
замените слово `PENDING`. Конечный индекс не включается; необъяснимые числовые индексы не нужны.

## 29. Этап 28. `append`

Последовательными вызовами `append` добавьте строки, подставляя параметры метода:

```text
Incident:      INC-5042
Level:         ERROR
Service:       auth-service
Email:         User[at]Example.com
Domain:        example.com
File:          auth.log
Message:       Invalid password for "admin"
Code digits:   4
Service order: BEFORE
Validation:    100,0%
```

После каждой строки добавляйте `\n`.
Строку количества цифр сформируйте через `String.format("Code digits:   %d\n", ...)`,
подставив `incidentCodeDigitCount`: здесь `%d` форматирует целое число.
Для процента используйте `String.format` с `Locale.GERMANY` и шаблоном
`"Validation:    %.1f%%\n"`. Затем добавьте обе строки в тот же `reportBuilder`.

## 30. Этап 29. `insert`

Если `isErrorEvent` равно `true`, вставьте через `insert(0, ...)` в начало
`warningSymbol`, затем `" [CRITICAL]\n"`. Для основного теста первая строка:

```text
⚠ [CRITICAL]
```

## 31. Этап 30. `delete`

Сохраните `reportBuilder.length()` в «индекс начала временной строки»
(`temporaryLineStartIndex`) типа `int`.
Временно добавьте через `append` строку `"TEMPORARY LINE\n"`,
затем удалите её через `delete(temporaryLineStartIndex, reportBuilder.length())`.
В итоговом тексте временной строки быть не должно.

### Дополнительный тест 10. `StringBuilder` изменяем

Наблюдайте за `reportBuilder` после `replace`, `append`, `insert` и `delete`:
все операции меняют один объект. При отладке можно временно выводить его после каждого шага.
Сравните результат с опытом над `String` на этапе 16 и затем удалите временный вывод.

## 32. Этап 31. Преобразование `StringBuilder` в `String`

Верните `reportBuilder.toString()`.
Метод должен возвращать обычную строку `String`, а не сам `StringBuilder`.

## 33. Этап 32. Зеркальный код инцидента

Создайте `public static` метод «развернуть код инцидента» (`reverseIncidentCode`):
параметр `String incidentCode` — код, возвращаемый тип — `String`.

Создайте «построитель зеркального кода» (`reversedCodeBuilder`) типа `StringBuilder`
на основе параметра, вызовите `reverse()` и верните `toString()`.
В `main` сохраните результат в «зеркальный код» (`reversedIncidentCode`) типа `String`.
Для `INC-5042` ожидается `2405-CNI`. Это диагностическое упражнение.

## 34. Этап 33. Сравнение содержимого двух `StringBuilder`

В `main` создайте два отдельных `StringBuilder` с текстом `"INCIDENT"`:
«первый построитель» (`builderOne`) и «второй построитель» (`builderTwo`).

Сохраните в «содержимое построителей совпадает» (`hasEqualBuilderContent`) типа `boolean`
сравнение `builderOne.toString().equals(builderTwo.toString())`. Ожидается `true`.
Само `builderOne.equals(builderTwo)` не сравнивает текст разных построителей.

## 35. Этап 34. Итоговый вывод

Выведите по порядку:

1. `reportBanner`;
2. `formattedServiceTable`;
3. `escapedDiagnosticMessage`;
4. результат `buildIncidentReport`;
5. `reversedIncidentCode`.

Результат `formattedValidationResult` и `hasEqualBuilderContent` проверьте временным выводом
до баннера или в отладчике, затем уберите диагностические строки.

Основной результат `buildIncidentReport`:

```text
⚠ [CRITICAL]
STATUS:        VALIDATED
Incident:      INC-5042
Level:         ERROR
Service:       auth-service
Email:         User[at]Example.com
Domain:        example.com
File:          auth.log
Message:       Invalid password for "admin"
Code digits:   4
Service order: BEFORE
Validation:    100,0%
```

## 36. Дополнительные тесты

В тестах с заменой одного поля используйте остальные значения основного ввода без изменений.

### Дополнительный тест 1. Регистр уровня события

Замените `error` на `ErRoR`. После нормализации ожидаются `ERROR` и `isErrorEvent == true`.

### Дополнительный тест 2. Другой email-регистр

Введите `USER@EXAMPLE.COM`. Сравнение с `user@example.com` через `equalsIgnoreCase`
должно дать `true`.

### Дополнительный тест 3. Другой домен

Введите `User@Other.org`. Ожидаются `emailDomain` со значением `other.org`,
`isRegisteredEmail == false`, четыре проверки из пяти, `80.0` процента и статус `REVIEW`.
Строка отчёта с сохранением выравнивания: `STATUS:        REVIEW`.

### Дополнительный тест 4. Файл неправильного типа

Замените путь на `C:\Logs\auth.txt`.
Ожидаются `isLogFileInExpectedDirectory == true` и `hasLogFileExtension == false`.
Общая проверка пути не засчитывается: четыре проверки, `80.0` процента и `REVIEW`.

### Дополнительный тест 5. Файл из другого каталога

Используйте `D:\Temp\auth.log`. Ожидаются `isLogFileInExpectedDirectory == false`,
`hasLogFileExtension == true`, четыре проверки, `80.0` процента и `REVIEW`.

### Дополнительный тест 6. Сообщение без password

Используйте `Connection timeout`. Ожидается `hasPasswordKeyword == false`:
четыре проверки, `80.0` процента и `REVIEW`.

### Дополнительный тест 7. Ошибка структуры

Введите пять полей:

```text
INC-5042 | ERROR | auth-service | User@Example.com | C:\Logs\auth.log
```

Должна появиться только строка `Invalid log structure.`.
Программа не обращается к отсутствующему шестому элементу.

### Дополнительный тест 8. Отсутствует символ @

Введите `invalid-email`. Ожидаются индекс `-1`, домен `""`,
`isRegisteredEmail == false`, `80.0` процента и `REVIEW`.
Вызов `substring` для домена пропускается; программа продолжает работу без ошибки.

### Проверка границ строк

Пустой код после очистки даёт `Invalid incident code.` и завершение.
Путь `auth.log` без слешей даёт имя `auth.log`, но проверку каталога не проходит.
Пустое шестое поле сохраняется при разделении; сообщение пустое и не содержит `password`.
