# 📚 Homework 6: Поведенческие паттерны проектирования (Java)

## 🔧 Проект состоит из двух частей:
1. **Chain of Responsibility (Цепочка обязанностей)** — Tech Support Request Handler
2. **Command Pattern (Команда)** — Smart Home Remote Control

---

## 🧩 1. Chain of Responsibility — Tech Support

### 📘 Описание:
Моделирует центр технической поддержки:
- Бот справки (`FAQBot`)
- Младший специалист (`JuniorSupport`)
- Старший инженер (`SeniorSupport`)

Каждый обработчик решает задачу или передаёт её дальше по цепочке.

### ✅ Обрабатываемые запросы:
- `password_reset` — FAQBot
- `refund_request`, `billing_issue` — JuniorSupport
- `account_ban`, `data_loss` — SeniorSupport
- Остальные — требуют ручной эскалации

### 🗂 Структура:
src/ 
└── chainofresponsibility/ 
├── SupportHandler.java 
├── AbstractSupportHandler.java
├── FAQBotHandler.java 
├── JuniorSupportHandler.java
├── SeniorSupportHandler.java 
├── SupportChainBuilder.java 
└── Main.java

---

## 🧩 2. Command Pattern — Smart Home Remote Control

### 📘 Описание:
Пульт управления умным домом. Выполняет и отменяет команды:
- Включение света
- Установка температуры
- Режим "Спокойной ночи" (MacroCommand)
- CLI-меню управления

### 🎮 Поддерживаемые команды:
- Включить свет
- Установить температуру (22°C)
- Режим "Goodnight" (выключить свет + понизить температуру)
- Undo (отмена последней команды)

### 🗂 Структура:
src/ 
└── command/ 
├── Command.java 
├── Light.java 
├── Thermostat.java 
├── TurnOnLightCommand.java
├── SetThermostatCommand.java
├── MacroCommand.java 
├── SmartHomeRemoteControl.java 
└── Main.java

---


## 📋 Пример вывода:

```text
==== Умный дом: Меню ====
1. Включить свет
2. Установить температуру 22°C
3. Goodnight Mode
u. Undo
q. Выход
Выберите команду: 3
[MacroCommand] Выполнение набора команд:
[Light] Выключено
[Thermostat] Установка температуры: 18°C
