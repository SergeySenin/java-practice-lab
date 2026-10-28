# 4. Модификаторы полей в Spring

## 4.1. Как сочетаются модификаторы полей?

Рассмотрим все **восемь комбинаций** `public` / `private`,
`static` / без `static` и `final` / без `final` на примерах Java 17 и Spring.

## 4.2. Все восемь комбинаций

| Комбинация             | Назначение и пример применения в Spring          |
|------------------------|--------------------------------------------------|
| `public static final`  | Общедоступная константа: `MAX_ORDERS`            |
| `private static final` | Внутренняя константа или объект логирования      |
| `public static`        | Открытое общее изменяемое поле; обычно избегают  |
| `private static`       | Скрытое  общее изменяемое поле; требует контроля |
| `public final`         | Открытое поле объекта с фиксированным значением  |
| `private final`        | Зависимость, заданная через конструктор          |
| `public`               | Открытое изменяемое поле отдельного объекта      |
| `private`              | Скрытое изменяемое состояние объекта             |

**Все восемь комбинаций разрешены Java.** Но разрешённая конструкция
не обязательно является хорошим решением для Spring-приложения.

## 4.3. Один пример для всех восьми комбинаций

```
class FieldMatrix {
    public  static final int    MAX_ORDERS = 100;   // ← 1. public static final
    private static final String PREFIX = "ORD-";    // ← 2. private static final
    public  static int          globalCount;        // ← 3. public static
    private static int          nextNumber;         // ← 4. private static

    public  final  String region;                   // ← 5. public final
    private final  String owner;                    // ← 6. private final
    public  String status = "NEW";                  // ← 7. public
    private int    processed;                       // ← 8. private

    FieldMatrix(String region, String owner) {
        this.region = region;                       // ← 5. Первое присваивание
        this.owner  = owner;                        // ← 6. Первое присваивание
    }

    static synchronized String nextOrderId() {
        nextNumber++;                               // ← 4. Изменение private static
        return PREFIX + nextNumber;                 // ← 2. Чтение private static final
    }

    synchronized void record() {
        processed++;                                // ← 8. Изменение private
    }

    synchronized int getProcessed() {
        return processed;
    }

    String getOwner() {
        return owner;                               // ← 6. Чтение private final
    }
}
```

Проверим чтение и изменение полей:

```
FieldMatrix first  = new FieldMatrix("EU", "Анна");
FieldMatrix second = new FieldMatrix("US", "Мария");

System.out.println(FieldMatrix.MAX_ORDERS);            // ← 100: public static final
System.out.println(FieldMatrix.nextOrderId());         // ← ORD-1: private static final и static

FieldMatrix.globalCount = 10;                          // ← Меняем public static
System.out.println(FieldMatrix.globalCount);           // ← 10

System.out.println(first.region);                      // ← EU: public final
System.out.println(first.getOwner());                  // ← Анна: private final через метод

first.status = "DONE";                                 // ← Меняем public
first.record();                                        // ← Меняем private через метод
System.out.println(first.status);                      // ← DONE
System.out.println(first.getProcessed());              // ← 1
System.out.println(second.status);                     // ← NEW: другой объект

// FieldMatrix.MAX_ORDERS = 200;                       // ← Нельзя: final
// first.region = "ASIA";                              // ← Нельзя: final
// first.owner  = "Иван";                              // ← Нельзя: private и final
// FieldMatrix.PREFIX     = "NEW-";                    // ← Нельзя: private и final
// FieldMatrix.nextNumber = 5;                         // ← Нельзя: private
```

Методы `getOwner()`, `record()` и `nextOrderId()` предоставляют доступ к скрытым полям.
Внешний код не получает права напрямую обращаться к `private`-полям.

В примере счётчики `static` общие для экземпляров `first` и `second`,
а `status` и `processed` принадлежат каждому экземпляру отдельно.

**Это означает**: любой вариант из таблицы 4.2 можно узнать по трём признакам:
кто имеет доступ, кому принадлежит поле и можно ли переназначить его значение.

## 4.4. Как это выглядит в Spring-приложении?

Обычно Spring создаёт сервис как **singleton bean** —
один экземпляр определённого бина в одном контейнере Spring.
Это не то же самое, что `static`: класс и его статические поля
существуют независимо от создания и количества Spring-бинов.

В реальном сервисе чаще нужны `private final` для обязательных зависимостей,
`private static final` для констант и `private` для изменяемого состояния.

```
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
class OrderRepository {
    void save(String title) {
        System.out.println("Сохранён заказ: " + title);   // ← Упрощённое хранилище
    }
}

@Service
class OrderService {
    private static final int MAX_TITLE_LENGTH = 50;       // ← Константа класса
    private final OrderRepository repository;             // ← Зависимость Spring
    private final AtomicInteger savedOrders = new AtomicInteger();

    OrderService(OrderRepository repository) {
        this.repository = repository;                     // ← Внедрение через конструктор
    }

    void save(String title) {
        if (title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("Слишком длинное название");
        }

        repository.save(title);
        savedOrders.incrementAndGet();                    // ← Меняется объект, не ссылка
    }

    int getSavedOrders() {
        return savedOrders.get();
    }
}
```

Разбор полей `OrderService`:

1. `MAX_TITLE_LENGTH` — общая неизменяемая константа класса.
2. `repository`       — обязательная зависимость, переданная Spring в конструктор.
3. `savedOrders`      — `final`-ссылка на изменяемый `AtomicInteger`.

Здесь `AtomicInteger` позволяет потокобезопасно увеличивать счётчик.
Для бизнес-данных такое поле не заменяет базу данных:
при перезапуске приложения значение не сохраняется, а
несколько экземпляров приложения не разделяют один счётчик.

**Это означает**: типичный Spring-сервис скрывает поля и предоставляет методы.
Для обязательных зависимостей обычно используют `private final` и конструктор.
Само наличие `final` не делает состояние сервиса неизменяемым.

## 4.5. Особенности Spring, которые важно учитывать

* **`static` и `singleton` — разные механизмы**.

  Статическое поле относится к классу и его загрузчику классов.
  Singleton-объект относится к конкретному определению бина в контейнере Spring.
  Даже два разных Spring-контейнера могут обращаться к одному `static`-полю,
  но иметь разные экземпляры `OrderService`.

  **Это означает**: не нужно делать поле `static` только потому,
  что сервис Spring обычно создаётся в одном экземпляре.

* **Внедрение зависимостей и `final`**.

  Spring Boot рекомендует внедрение обязательных зависимостей через конструктор.
  Если у бина только один конструктор, `@Autowired` над ним не требуется.
  Обычное внедрение через поле не подходит для присваивания `final`-полю.

  Пример — `private final OrderRepository repository` в разделе 4.4.

  **Это означает**: зависимость задаётся при создании объекта,
  после чего ссылку нельзя случайно переназначить.

* **Настройки приложения и `static final`**.

  Значение из `application.properties` или переменной окружения
  может отличаться между запусками приложения.
  Его не следует записывать как константу времени компиляции.

  ```
  import org.springframework.beans.factory.annotation.Value;
  import org.springframework.stereotype.Service;

  @Service
  class RetryPolicy {
      private final int maxAttempts;

      RetryPolicy(@Value("${app.max-attempts:3}") int maxAttempts) {
          this.maxAttempts = maxAttempts;
      }
  }
  ```

  Здесь `3` — значение на случай, если `app.max-attempts` не задано.
  Spring передаёт настройку в конструктор, а `final` сохраняет
  выбранное значение для данного экземпляра `RetryPolicy`.

  **Это означает**: `private final` подходит и для настроек,
  получаемых при создании бина, а не только для других объектов.

* **Изменяемые поля и многопоточность**.

  Несколько HTTP-запросов могут одновременно вызывать методы одного singleton-бина.
  Поэтому `private int count` с операцией `count++`
  не становится безопасным только потому, что поле скрыто через `private`.

  Для счётчиков можно применять `AtomicInteger` или подходящую синхронизацию.
  Данные конкретного пользователя или запроса обычно не хранят
  в общих полях singleton-сервиса. Для них используют локальные переменные,
  хранилище данных или бин с подходящей областью видимости.

  **Это означает**: `private` отвечает за доступ, а не за безопасность потоков.

* **Почему открытые изменяемые поля обычно нежелательны**.

  Поля `public static` и `public` позволяют внешнему коду менять состояние напрямую.
  При этом нельзя централизованно проверять каждое присваивание.
  В Spring предпочтительнее скрывать состояние и управлять им через методы.

  `public final`   разрешён, но для зависимостей сервиса обычно выбирают
  `private final`: внешний код не должен зависеть от внутреннего устройства бина.

* **`final`-поля и Spring-прокси**.

  Само по себе `final` у поля не мешает Spring внедрять зависимость через конструктор.
  Но `final` у класса или метода — отдельный случай из [части 3][r1].
  При проксировании через наследование Spring не может создать подкласс
  `final`-класса или переопределить `final`-метод для перехвата вызова.

  Это важно, например, для методов, работающих через Spring AOP и `@Transactional`.

### Что это означает на практике?

Главное — выбирать модификаторы по назначению поля:

* `public` или `private` — кому разрешён доступ.
* `static` или без него  — одно поле класса или поле каждого объекта.
* `final`  или без него  — допустимо ли повторное присваивание.

**Итог**: в Spring-сервисах чаще всего подходят `private final` для зависимостей
и `private static final` для констант. Изменяемые поля требуют отдельного решения
о доступе и потокобезопасности. Все восемь комбинаций допустимы в Java,
но не все одинаково полезны для устройства Spring-приложения.

Предыдущая часть: [Модификатор `final` в Java][r1].

[r1]: java_final_modifier.md
