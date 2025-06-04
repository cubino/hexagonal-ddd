# Гексагональная Архитектура в Java

Этот проект демонстрирует реализацию гексагональной архитектуры (также известной как порты и адаптеры) в Java с использованием Spring Boot.

## Архитектура

Проект разделен на три основных слоя:

### 1. Доменный слой (`domain`)
Содержит бизнес-логику и основные модели:
- `Order` - модель заказа
- `Money` - модель денежной суммы
- `OrderStatus` - перечисление статусов заказа
- `OrderDomainService` - доменный сервис с бизнес-логикой

### 2. Прикладной слой (`application`)
Содержит порты и адаптеры для входящих запросов:
- `OrderUseCase` - порт для входящих запросов
- `OrderService` - адаптер, реализующий бизнес-операции

### 3. Инфраструктурный слой (`infrastructure`)
Содержит порты и адаптеры для исходящих запросов:
- `OrderRepository` - порт для работы с хранилищем данных

## Структура проекта

```
src/main/java/com/example/
├── domain/
│   └── order/
│       ├── Order.java
│       ├── Money.java
│       ├── OrderStatus.java
│       └── OrderDomainService.java
├── application/
│   ├── ports/
│   │   └── OrderUseCase.java
│   └── adapters/
│       └── OrderService.java
└── infrastructure/
    └── ports/
        └── OrderRepository.java
```

## Основные принципы

1. **Изоляция домена**: Доменный слой не зависит от внешних слоев
2. **Порты и адаптеры**: 
   - Входящие порты определяют, как внешний мир может взаимодействовать с приложением
   - Исходящие порты определяют, как приложение взаимодействует с внешним миром
3. **Инверсия зависимостей**: Внешние слои зависят от внутренних, а не наоборот

## Примеры использования

### Создание заказа
```java
@Autowired
private OrderUseCase orderUseCase;

public void createOrder() {
    Money amount = Money.of(new BigDecimal("100.00"), "USD");
    Order order = orderUseCase.createOrder("customer123", amount);
}
```

### Получение заказа
```java
Order order = orderUseCase.getOrder("order123");
```

### Обновление статуса заказа
```java
orderUseCase.updateOrderStatus("order123", "CONFIRMED");
```

## Требования

- Java 17 или выше
- Spring Boot 3.x
- Maven или Gradle

## Запуск проекта

```bash
./gradlew bootRun
```

## Тестирование

```bash
./gradlew test
```

## Лицензия

MIT
