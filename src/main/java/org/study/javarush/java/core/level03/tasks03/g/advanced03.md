Задание 03. Система безопасности банковского перевода

Вы разрабатываете консольную программу, которая проверяет банковский перевод перед его выполнением.
Пользователь вводит сведения о счёте, устройстве и переводе.
Программа преобразует данные в логические признаки, определяет уровень риска,
проверяет безопасность и разрешает перевод или отклоняет его.

## 1. Структура программы

В файле `Solution.java` создайте класс «решение» (`Solution`) и главный метод программы (`main`):

```
public static void main(String[] args)
```

Параметр «аргументы командной строки» (`args`) имеет тип `String[]`.
В этом задании он не используется.
Все действия ниже выполняйте внутри `main`, используя указанные английские имена переменных.

Подключите класс «сканер» (`Scanner`) из пакета `java.util` и создайте объект «консоль» (`console`),
который читает стандартный поток ввода (`System.in`).

## 2. Ввод данных

Методом «считать строку» (`nextLine()`)
последовательно получите четыре значения типа «строка» (`String`):

1. «имя клиента» (`customerNameInput`);
2. «статус счёта» (`accountStatusInput`);
3. «статус устройства» (`deviceStatusInput`);
4. «код подтверждения» (`confirmationCodeInput`).

Затем методом «считать целое число» (`nextInt()`) получите четыре значения
типа «целое число» (`int`):

5. «текущий баланс» (`accountBalance`);
6. «сумма перевода» (`transferAmount`);
7. «возраст счёта в днях» (`accountAgeDays`);
8. «количество неудачных попыток входа» (`failedLoginAttempts`).

Статус счёта принимает значения `"ACTIVE"` — активен, `"INACTIVE"` — неактивен.
Статус устройства: `"TRUSTED"` — доверенное, `"UNKNOWN"` — неизвестное.
Правильный код подтверждения — `"BANK-2026"`.

## 3. Подготовка данных

Создайте «имя клиента» (`customerName`) типа `String`,
удалив пробелы по краям `customerNameInput` методом «удалить пробелы по краям» (`trim()`).

Создайте три переменные типа «логический» (`boolean`):

* «счёт активен» (`isAccountActive`)             —
  результат сравнения `accountStatusInput` с `"ACTIVE"`;
* «устройство доверенное» (`isTrustedDevice`)    —
  результат сравнения `deviceStatusInput` с `"TRUSTED"`;
* «код правильный» (`isConfirmationCodeCorrect`) —
  результат сравнения `confirmationCodeInput` с `"BANK-2026"`.

Для содержимого строк используйте метод «сравнить строки по содержимому» (`equals()`), а не `==`.

Для трёх признаков выше, числовых проверок и основной предварительной проверки
сохраняйте результат сравнения или логического выражения непосредственно в `boolean`.
Не используйте избыточное `условие ? true : false`.
Тернарный оператор в этом задании нужен только для строк `transferType` и `transferStatus`.

## 4. Числовые проверки

Создайте следующие переменные типа `boolean`.
Каждая получает `true` при выполнении своего условия и `false` в противном случае:

* «достаточно средств» (`hasSufficientBalance`)                  — сумма перевода (`transferAmount`)
  меньше или равна текущему балансу (`accountBalance`); используйте «меньше или равно» (`<=`);
* «крупный перевод» (`isLargeTransfer`)                          — сумма перевода (`transferAmount`)
  больше `100000`; используйте «больше» (`>`);
* «новый счёт» (`isNewAccount`)                                  — возраст счёта (`accountAgeDays`)
  меньше `30` дней; используйте «меньше» (`<`);
* «слишком много неудачных попыток» (`hasTooManyFailedAttempts`) — число попыток
  (`failedLoginAttempts`) больше или равно `3`; используйте «больше или равно» (`>=`).

## 5. Основная предварительная проверка

Создайте «основные условия безопасности выполнены» (`areBasicSecurityConditionsMet`) типа `boolean`.
Для успешной проверки должны одновременно выполняться условия:

* счёт активен (`isAccountActive`);
* средств достаточно (`hasSufficientBalance`);
* нет слишком большого количества неудачных попыток входа.

Объедините условия логическим «И» (`&&`, AND), а `hasTooManyFailedAttempts`
инвертируйте логическим «НЕ» (`!`, NOT). Для явного выделения отрицания
заключите выражение `!hasTooManyFailedAttempts` в круглые скобки.

## 6. Тип перевода, уровень риска и предупреждение

### Тип перевода

Создайте «тип перевода» (`transferType`) типа `String`. Определите его **тернарным оператором**
(`?:`): `"LARGE"`, если `isLargeTransfer` равно `true`, иначе `"STANDARD"`.
Не заменяйте тернарный оператор конструкцией `if-else`.

### Уровень риска

Создайте «уровень риска» (`riskLevel`) типа `String`.
Используйте цепочку `if → else if → else` с блоками команд в фигурных скобках `{}`:

1. Если `hasTooManyFailedAttempts` равно `true`, запишите `"HIGH"`.
2. Иначе, если перевод крупный (`isLargeTransfer`) **или** счёт новый (`isNewAccount`),
   запишите `"MEDIUM"`. Используйте логическое «ИЛИ» (`||`, OR).
3. В остальных случаях запишите `"LOW"`.

### Предупреждение о крупном переводе

Отдельным условным оператором (`if`) **без `else`** проверьте `isLargeTransfer`.
Для крупного перевода выведите предупреждение `SECURITY NOTICE` по первой строке итогового образца
ниже, включая текст и пробелы. Для обычного перевода эта строка выводиться не должна.

## 7. Правила разрешения перевода

Создайте «перевод разрешён» (`isTransferAllowed`) типа `boolean` с начальным значением `false`.
Используйте вложенные условные операторы с блоками команд в фигурных скобках.

Сначала оператором `if` проверьте `areBasicSecurityConditionsMet`. **Только внутри этого блока**
выполняйте дополнительные проверки. Если основные условия не выполнены, флаг остаётся `false`.

Внутри внешнего `if` создайте вложенную конструкцию `if-else` по значению `isLargeTransfer`:

* Для крупного перевода (`if`) проверьте, что счёт не новый и код правильный:
  используйте `isNewAccount`, `isConfirmationCodeCorrect`, логические `!` и `&&`.
  Если оба условия выполнены, присвойте `isTransferAllowed` значение `true`.
  Иначе оставьте `false`.
* Для обычного перевода (`else`) проверьте, что устройство доверенное или код правильный:
  используйте `isTrustedDevice`, `isConfirmationCodeCorrect` и логическое `||`.
  Если хотя бы одно условие выполнено, присвойте `isTransferAllowed` значение `true`.
  Иначе оставьте `false`.

Для крупного перевода доверенное устройство не заменяет правильный код,
а новый счёт не может пройти дополнительную проверку.

## 8. Изменение баланса и итоговый статус

Создайте «баланс после операции» (`accountBalanceAfterTransfer`) типа `int` и сначала
присвойте ему исходный баланс (`accountBalance`).

После проверок используйте отдельный `if` **без `else`**: если `isTransferAllowed` равно `true`,
уменьшите `accountBalanceAfterTransfer` на сумму перевода (`transferAmount`).
При запрещённом переводе баланс должен остаться прежним.

Создайте «статус перевода» (`transferStatus`) типа `String`. Тернарным оператором (`?:`)
выберите `"APPROVED"`, если `isTransferAllowed` равно `true`, иначе `"DECLINED"`.

## 9. Итоговый отчёт и основной тест

После всех проверок выведите отчёт. Для каждой подписи используйте указанную переменную:

| Подпись                     | Значение                        | Переменная                    |
|-----------------------------|---------------------------------|-------------------------------|
| `Customer:`                 | Имя клиента                     | `customerName`                |
| `Transfer type:`            | Тип перевода                    | `transferType`                |
| `Risk level:`               | Уровень риска                   | `riskLevel`                   |
| `Account active:`           | Счёт активен                    | `isAccountActive`             |
| `Trusted device:`           | Устройство доверенное           | `isTrustedDevice`             |
| `Code correct:`             | Код правильный                  | `isConfirmationCodeCorrect`   |
| `Enough balance:`           | Достаточно средств              | `hasSufficientBalance`        |
| `New account:`              | Новый счёт                      | `isNewAccount`                |
| `Too many failed attempts:` | Слишком много неудачных попыток | `hasTooManyFailedAttempts`    |
| `Transfer status:`          | Статус перевода                 | `transferStatus`              |
| `Balance before:`           | Исходный баланс                 | `accountBalance`              |
| `Transfer amount:`          | Сумма перевода                  | `transferAmount`              |
| `Balance after:`            | Баланс после операции           | `accountBalanceAfterTransfer` |

Соединяйте подписи и значения конкатенацией (`+`).
Пробелы для выравнивания записывайте внутри строковых литералов по образцу ниже.
Используйте метод «вывести с переходом на новую строку» (`System.out.println()`).

Скомпилируйте и запустите программу. Последовательно введите:

```text
   Sergey Senin   
ACTIVE
TRUSTED
BANK-2026
250000
120000
420
1
```

Ожидаемый вывод, включая предупреждение перед отчётом:

```text
SECURITY NOTICE:          additional verification is required.
Customer:                 Sergey Senin
Transfer type:            LARGE
Risk level:               MEDIUM
Account active:           true
Trusted device:           true
Code correct:             true
Enough balance:           true
New account:              false
Too many failed attempts: false
Transfer status:          APPROVED
Balance before:           250000
Transfer amount:          120000
Balance after:            130000
```

Дополнительно проверьте признаки, которые не выводятся отдельными строками:
`isLargeTransfer`, `areBasicSecurityConditionsMet` и `isTransferAllowed` должны быть равны `true`.

## 10. Дополнительные тесты для самопроверки

После успешного выполнения основного теста проверьте программу ещё на нескольких наборах данных.

### Тест 2. Неверный код для крупного перевода

```text
Alice Brown
ACTIVE
TRUSTED
WRONG
250000
120000
420
0
```

Ожидаемые ключевые результаты:

* `isLargeTransfer`             → `true`;
* `isConfirmationCodeCorrect`   → `false`;
* `isTransferAllowed`           → `false`;
* `transferStatus`              → `DECLINED`;
* `accountBalanceAfterTransfer` → `250000`.

Обратите внимание: для **крупного** перевода одного доверенного устройства недостаточно.

### Тест 3. Обычный перевод с доверенного устройства

```text
John Smith
ACTIVE
TRUSTED
WRONG
50000
10000
400
0
```

Ожидаемые ключевые результаты:

* `isLargeTransfer`             → `false`;
* `isTrustedDevice`             → `true`;
* `isConfirmationCodeCorrect`   → `false`;
* `isTransferAllowed`           → `true`;
* `transferType`                → `STANDARD`;
* `riskLevel`                   → `LOW`;
* `accountBalanceAfterTransfer` → `40000`.

### Тест 4. Недостаточно средств

```text
Mary Green
ACTIVE
TRUSTED
BANK-2026
5000
10000
500
0
```

Ожидаемые ключевые результаты:

* `hasSufficientBalance`          → `false`;
* `areBasicSecurityConditionsMet` → `false`;
* `isTransferAllowed`             → `false`;
* `transferStatus`                → `DECLINED`;
* `accountBalanceAfterTransfer`   → `5000`.

### Тест 5. Слишком много неудачных попыток

```text
David White
ACTIVE
TRUSTED
BANK-2026
200000
10000
500
3
```

Ожидаемые ключевые результаты:

* `hasTooManyFailedAttempts`      → `true`;
* `areBasicSecurityConditionsMet` → `false`;
* `riskLevel`                     → `HIGH`;
* `isTransferAllowed`             → `false`;
* `transferStatus`                → `DECLINED`.

### Тест 6. Новый счёт и крупный перевод

```text
Emma Black
ACTIVE
TRUSTED
BANK-2026
300000
150000
15
0
```

Ожидаемые ключевые результаты:

* `isLargeTransfer`             → `true`;
* `isNewAccount`                → `true`;
* `riskLevel`                   → `MEDIUM`;
* `isTransferAllowed`           → `false`;
* `accountBalanceAfterTransfer` → `300000`.
