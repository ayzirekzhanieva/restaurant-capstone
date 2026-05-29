# Restaurant Management System

## Описание проекта (Project Description)

Restaurant Management System — это backend-приложение, разработанное на Spring Boot для управления клиентами, меню ресторана и заказами.

Проект демонстрирует применение объектно-ориентированного программирования (OOP), шаблонов проектирования (Design Patterns), многоуровневой архитектуры, REST API, PostgreSQL и Spring Boot.

Проект разработан в рамках Capstone Project по курсу Object-Oriented Programming.

---

## Используемые технологии (Technologies)

* Java 17
* Spring Boot 3.5
* Spring Web
* Spring Data JPA
* Spring Validation
* PostgreSQL
* Gradle
* Lombok
* JUnit 5
* Mockito
* GitHub

---

## Архитектура приложения (Architecture)

Приложение построено по многоуровневой архитектуре:

Controller → Service → Repository → Entity

### Controller Layer

Обрабатывает HTTP-запросы и возвращает HTTP-ответы.

### Service Layer

Содержит бизнес-логику приложения.

### Repository Layer

Отвечает за взаимодействие с базой данных.

### Entity Layer

Представляет объекты предметной области и таблицы базы данных.

---

## Сущности (Domain Entities)

### Customer

Хранит информацию о клиентах.

Поля:

* id
* fullName
* email
* phone

### MenuItem

Хранит информацию о блюдах меню.

Поля:

* id
* name
* description
* price

### Order

Представляет заказ клиента.

Поля:

* id
* customer
* status
* totalAmount

### OrderItem

Представляет отдельную позицию внутри заказа.

Поля:

* id
* menuItem
* quantity
* price

---

## Связи между сущностями (Relationships)

* Один Customer может иметь много Orders
* Один Order может содержать много OrderItems
* Один MenuItem может использоваться во многих OrderItems

---

## Бизнес-операции (Business Operations)

### Создание заказа

Создание заказа с несколькими блюдами и автоматическим расчётом общей стоимости.

### Изменение статуса заказа

Статусы заказа:

RECEIVED → PREPARING → READY → DELIVERED

---

## Design Patterns

### Strategy Pattern

Используется для расчёта скидок.

Реализации:

* NoDiscountStrategy
* TenPercentDiscountStrategy

Преимущества:

* Простое добавление новых типов скидок
* Соблюдение принципа Open/Closed

### Factory Pattern

Используется для выбора нужной стратегии скидок.

Класс:

* DiscountStrategyFactory

Преимущества:

* Централизованное создание объектов
* Снижение связности между компонентами

---

## REST API

### Customer API

GET /api/customers

GET /api/customers/{id}

POST /api/customers

PUT /api/customers/{id}

DELETE /api/customers/{id}

---

### Menu Item API

GET /api/menu-items

GET /api/menu-items/{id}

POST /api/menu-items

PUT /api/menu-items/{id}

DELETE /api/menu-items/{id}

---

### Order API

GET /api/orders

GET /api/orders/{id}

POST /api/orders

PATCH /api/orders/{id}/status

---

## Настройка базы данных (Database Setup)

Создать базу данных:

CREATE DATABASE restaurant_capstone;

Настроить файл application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/restaurant_capstone

spring.datasource.username=postgres

spring.datasource.password=your_password

---

## Запуск приложения (Running the Application)

Сборка проекта:

./gradlew build

Запуск приложения:

./gradlew bootRun

Приложение будет доступно по адресу:

http://localhost:8080

---

## Тестирование (Testing)

Запуск тестов:

./gradlew test

Используются:

* JUnit 5
* Mockito

---

## AI Use Statement

В процессе разработки использовался ChatGPT для:

* объяснения концепций Spring Boot;
* помощи в поиске и исправлении ошибок;
* проверки архитектуры приложения;
* генерации шаблонного кода.


