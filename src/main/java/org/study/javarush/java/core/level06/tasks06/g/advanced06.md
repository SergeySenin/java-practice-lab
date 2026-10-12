Задание 06. Лаборатория анализа климатических данных (Climate Data Laboratory)

Программа метеостанции хранит характеристики в разных числовых типах, принимает три температуры,
вычисляет средние значения и проверяет точность калибровки. Отдельный диагностический блок
показывает бесконечность, `NaN` и потерю данных при сужении типа.

## 1. Структура программы

В файле `Solution.java` создайте класс «решение» (`Solution`) и главный метод программы (`main`):

```
public static void main(String[] args)
```

Параметр «аргументы командной строки» (`args`) типа `String[]` здесь не используется.
Все действия выполняйте внутри `main`, используя указанные английские имена.

Импортируйте класс «сканер» (`Scanner`) из `java.util` и класс «десятичный формат»
(`DecimalFormat`) из `java.text`. Создайте «консоль» (`console`) типа `Scanner`,
связанную со стандартным потоком ввода (`System.in`).

Строки выводите через `System.out.println()`, подставляя переменные конкатенацией (`+`).
Пробелы выравнивания из образцов помещайте внутрь строковых литералов.

## 2. Этап 1. Технические характеристики станции

Создайте переменные с начальными значениями:

* «версия протокола» (`protocolVersion`) типа «байт» (`byte`) — `6`;
* «высота станции» (`stationAltitude`) типа «короткое целое число» (`short`) — `1847` метров;
* «количество измерений» (`measurementCount`) типа «целое число» (`int`) — `3`;
* «общее количество измерений» (`totalMeasurementCount`) типа «длинное целое число» (`long`)
  — `12_500_000_000L`; обязательны разделители разрядов `_` и суффикс `L`;
* «точность старого датчика» (`legacySensorAccuracy`)
  типа «вещественное число одинарной точности» (`float`) — `98.5F`; обязателен суффикс `F`.

Создайте «поправочный коэффициент» (`calibrationFactor`)
типа «вещественное число двойной точности» (`double`) и присвойте ему `legacySensorAccuracy`.
Преобразование `float → double` должно произойти **неявно** (implicit conversion).

Объясните выбор числовых типов и назначение суффиксов `L` и `F` на этих значениях.

## 3. Этап 2. Символьный код станции

1. Создайте «код станции» (`stationCode`) типа «символ» (`char`) со значением `'M'`.
   Символьный литерал записывайте в одиночных кавычках.
2. Создайте «Unicode-код станции» (`stationUnicodeCode`) типа `int` и присвойте ему
   `stationCode`: преобразование `char → int` должно быть неявным.
3. Создайте «восстановленный код станции» (`restoredStationCode`) типа `char`.
   Выполните **явное приведение типа** (explicit cast) `stationUnicodeCode` обратно в `char`.

Для символа `M` должен получиться код `77`, а после обратного преобразования — снова `M`.
Так символ связывается с числовым Unicode-кодом;
направления преобразования требуют разных способов приведения.

## 4. Этап 3. Ввод температурных измерений

Методом «считать дробное число» (`nextDouble()`) последовательно
получите три переменные типа `double`:

* «температура 1» (`firstTemperature`);
* «температура 2» (`secondTemperature`);
* «температура 3» (`thirdTemperature`).

`nextDouble()` учитывает текущую локаль. Основной тест приведён с десятичной точкой.
Если ваша локаль ожидает запятую, введите те же значения так:

```text
18,73
21,48
19,12
```

Различие десятичных разделителей не считается ошибкой решения.

## 5. Этап 4. Средняя температура

Создайте «сумма температур» (`temperatureSum`) типа `double` и сложите три введённых значения.
Создайте «средняя температура» (`averageTemperature`) типа `double`:
разделите `temperatureSum` на `measurementCount`.

В смешанном выражении `double` и `int` результат автоматически имеет тип `double`.
Для основного теста он приблизительно равен `19.776666...`.

## 6. Этап 5. Разница между целочисленным и дробным делением

Создайте «общее количество осадков» (`totalRainfall`) типа `int` со значением `7`
и «количество дождливых дней» (`rainyDays`) типа `int` со значением `2`.

Создайте «среднее количество осадков» (`averageRainfall`) типа `double`.
Перед делением **явно приведите хотя бы один операнд к `double`**.
Результат должен быть `3.5`: присваивание результата целочисленного деления в `double`
дало бы `3.0`, поскольку дробная часть уже потеряна.

## 7. Этап 6. Отбрасывание дробной части

Создайте «целая часть средней температуры» (`truncatedTemperature`) типа `int`.
Явно приведите `averageTemperature` к `int`.
Такое преобразование отбрасывает дробную часть, а не округляет до ближайшего целого.

## 8. Этап 7. Округление до ближайшего целого

Методом `Math.round()` округлите `averageTemperature` и сохраните результат в
«округлённая средняя температура» (`averageTemperatureRoundedToWholeNumber`) типа `long`.

Для основного теста приведение к `int` даёт `19`, а `Math.round()` — `20`.
Это разные операции: изменение типа с отбрасыванием дробной части и округление.

## 9. Этап 8. Другие способы округления

Для одного исходного значения `averageTemperature` создайте три переменные типа `double`:

* «округление вниз» (`averageTemperatureRoundedDown`)      — результат `Math.floor()`;
* «округление вверх» (`averageTemperatureRoundedUp`)       — результат `Math.ceil()`;
* «банковское округление» (`averageTemperatureRintResult`) — результат `Math.rint()`.

Для основного теста ожидаются соответственно `19.0`, `20.0` и `20.0`.

## 10. Этап 9. Математическое округление до двух знаков

Создайте «округлённая температура» (`averageTemperatureRoundedToTwoDecimals`) типа `double`.
Округлите `averageTemperature` по схеме:
умножить на `100.0`, применить `Math.round()`, разделить на `100.0`.

Для основного теста получится `19.78`. Сохраните число в переменной для дальнейших вычислений.

## 11. Этап 10. Форматирование через `String.format()`

Создайте «температура для отображения» (`formattedAverageTemperature`) типа «строка» (`String`).
Методом `String.format()` с форматом `%.2f` представьте исходную `averageTemperature`
с ровно двумя знаками после десятичного разделителя.

`averageTemperatureRoundedToTwoDecimals` хранит число, а `formattedAverageTemperature` —
текстовое представление. Форматирование не изменяет исходную `averageTemperature`
и не заменяет числовое округление из предыдущего этапа.

## 12. Этап 11. Форматирование большого числа через `DecimalFormat`

Создайте «общий объём обработанных данных» (`totalProcessedData`)
типа `double` со значением `12345678.9012`.

Создайте объект «формат больших чисел» (`processedDataNumberFormat`) типа `DecimalFormat`,
передав конструктору шаблон `#,##0.00`.
Его методом `format()` отформатируйте `totalProcessedData` и сохраните результат в
«отформатированный объём данных» (`formattedTotalProcessedData`) типа `String`.

Например, результат может быть `12,345,678.90`. Разделители групп и дробной части зависят
от локали; такие различия ошибкой не считаются. `DecimalFormat`, как и `String.format()`,
создаёт представление значения, не меняя исходного числа.

## 13. Этап 12. Проверка точности калибровки

Создайте переменные типа `double`:

* «фактический результат калибровки» (`actualCalibration`) — результат `0.1 + 0.2`;
* «ожидаемый результат калибровки» (`expectedCalibration`) — `0.3`;
* «допуск» (`calibrationTolerance`)                        — `0.000001`.

Создайте «точное сравнение» (`exactCalibrationMatch`) типа «логический» (`boolean`).
Сохраните результат сравнения `actualCalibration` и `expectedCalibration` через `==`.

Затем создайте «разница калибровки» (`calibrationDifference`) типа `double`.
Вычислите абсолютную разницу этих значений через `Math.abs()`.
Создайте «калибровка находится в допустимых пределах» (`calibrationWithinTolerance`)
типа `boolean`: разница должна быть строго меньше `calibrationTolerance`.

Ожидаются `exactCalibrationMatch = false` и `calibrationWithinTolerance = true`.
Дробные вычисления могут содержать погрешность, поэтому основная проверка использует допуск.

## 14. Этап 13. Статус калибровки

Конструкцией `if-else` проверьте `calibrationWithinTolerance`.
При `true` выведите `Calibration status: ACCEPTED`, иначе — `Calibration status: REJECTED`.

## 15. Этап 14. Диагностика бесконечности

Здесь начинается отдельный диагностический блок.
Создайте «результат деления на ноль» (`divisionByZeroResult`) типа `double`,
присвойте результат `1.0 / 0.0` и выведите значение.

Создайте «результат является бесконечностью» (`isDivisionByZeroInfinite`) типа `boolean`.
Проверьте `divisionByZeroResult` методом `Double.isInfinite()`.
Ожидаются `Infinity` и `true`.

## 16. Этап 15. Диагностика `NaN`

Создайте «неопределённый результат» (`negativeSquareRootResult`) типа `double`:
получите `Math.sqrt(-1)`.

Создайте «результат является `NaN`» (`isNegativeSquareRootNaN`) типа `boolean`.
Используйте `Double.isNaN()` для полученного значения.
Ожидаются `NaN` и `true`; обычное сравнение через `==` не заменяет эту проверку.

## 17. Этап 16. Диагностика сужения `int` → `byte`

Старый контроллер хранит температуру только в `byte`.
Создайте «экстремальная температура» (`extremeTemperature`) типа `int` со значением `200`.
Создайте «показание старого контроллера» (`legacyControllerReading`) типа `byte`
и явно приведите `extremeTemperature` к этому типу.

Выведите исходное значение из `extremeTemperature` и результат из `legacyControllerReading`:

```text
Original value:          200
Value after int -> byte: [результат]
```

Не исправляйте результат вручную. Определите его запуском программы и объясните
через диапазон `byte`: явное приведение разрешает сужение, но не гарантирует сохранения значения.

## 18. Этап 17. Итоговый отчёт станции

После диагностического блока выведите отчёт. В квадратных скобках указаны переменные,
из которых нужно брать значения:

```text
Protocol version:              [protocolVersion]
Station altitude:              [stationAltitude] m
Station code:                  [stationCode]
Station Unicode code:          [stationUnicodeCode]
Restored station code:         [restoredStationCode]
Total measurements:            [totalMeasurementCount]
Legacy sensor accuracy:        [legacySensorAccuracy]
Calibration factor:            [calibrationFactor]
Measurement count:             [measurementCount]
Temperature sum:               [temperatureSum]
Average temperature:           [averageTemperature]
Average temperature rounded:   [averageTemperatureRoundedToTwoDecimals]
Average temperature formatted: [formattedAverageTemperature]
Truncated temperature:         [truncatedTemperature]
Rounded temperature:           [averageTemperatureRoundedToWholeNumber]
Floor:                         [averageTemperatureRoundedDown]
Ceil:                          [averageTemperatureRoundedUp]
Rint:                          [averageTemperatureRintResult]
Average rainfall:              [averageRainfall]
Processed data:                [formattedTotalProcessedData]
Exact calibration match:       [exactCalibrationMatch]
Calibration within tolerance:  [calibrationWithinTolerance]
Infinity diagnostic:           [divisionByZeroResult]
Is infinite:                   [isDivisionByZeroInfinite]
NaN diagnostic:                [negativeSquareRootResult]
Is NaN:                        [isNegativeSquareRootNaN]
Legacy controller reading:     [legacyControllerReading]
```

## 19. Основной тест

Скомпилируйте и запустите программу. Введите температуры:

```text
18.73
21.48
19.12
```

При необходимости замените точки запятыми по правилу этапа 3.
Ожидаемые значения после вычислений:

```text
protocolVersion                        → 6
stationAltitude                        → 1847
measurementCount                       → 3
totalMeasurementCount                  → 12500000000
legacySensorAccuracy                   → 98.5
stationCode                            → M
stationUnicodeCode                     → 77
restoredStationCode                    → M

temperatureSum                         → 59.33
averageTemperature                     → приблизительно 19.776666666...
averageRainfall                        → 3.5

truncatedTemperature                   → 19
averageTemperatureRoundedToWholeNumber → 20
averageTemperatureRoundedDown          → 19.0
averageTemperatureRoundedUp            → 20.0
averageTemperatureRintResult           → 20.0
averageTemperatureRoundedToTwoDecimals → 19.78

actualCalibration                      → 0.30000000000000004
expectedCalibration                    → 0.3
exactCalibrationMatch                  → false
calibrationWithinTolerance             → true

divisionByZeroResult                   → Infinity
isDivisionByZeroInfinite               → true

negativeSquareRootResult               → NaN
isNegativeSquareRootNaN                → true
```

Значение `legacyControllerReading` проверьте экспериментом из этапа 16.
Различия разделителей в отформатированных строках оценивайте с учётом локали.

## 20. Дополнительная проверка 1. Приведение не равно округлению

Введите `19.99` три раза, чтобы средняя температура получилась `19.99`
(при необходимости используйте `19,99`).

```text
(int) 19.99       → 19
Math.round(19.99) → 20
```

Сравните `truncatedTemperature` и `averageTemperatureRoundedToWholeNumber`
и объясните, почему результаты различаются.

## 21. Дополнительная проверка 2. Целочисленное деление

Временно выведите выражение `7 / 2` без приведения и сравните с `averageRainfall`.
Объясните различие результатов `7 / 2` и `(double) 7 / 2`.
Новая переменная не нужна; после проверки дополнительный вывод можно удалить.

## 22. Дополнительная проверка 3. Форматирование не изменяет значение

Сразу после создания `formattedAverageTemperature` временно повторно выведите
`averageTemperature`. Убедитесь, что число сохранило значение:
`String.format()` создал строку, а не изменил исходную температуру.

## 23. Дополнительная проверка 4. `NaN` нельзя проверять обычным равенством

Временно выведите результаты выражений `negativeSquareRootResult == Double.NaN`
и `Double.isNaN(negativeSquareRootResult)`. Сравните результаты.
Дополнительные переменные не нужны; основная логика должна использовать `Double.isNaN()`.

После экспериментов уберите временные диагностические строки,
чтобы вернуть формат основного отчёта, и повторите основной тест.
