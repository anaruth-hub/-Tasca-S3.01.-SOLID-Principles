## Contents
- SRP (S)
- DIP (D)
- OCP (O)
- ISP (I)
- LSP (L)

# Explanation — SOLID Principles (S, O, L, I, D)

This document summarizes what was wrong in the original design, why it violated SOLID principles, what changes were applied, and why the refactor is better.

---

## ✅ S — Single Responsibility Principle (SRP)

### What was wrong
- `User` was doing too many things: modeling, validation, email sending, and confirmation/orchestration.

### Why it violated SRP
- There were several reasons to change the class (data, validation rules, email logic, workflow).

### Solution applied
I separated responsibilities into dedicated classes:
- `User` → entity/model (data only)
- `UserValidator` → validation rules
- `EmailService` → sending confirmation
- `RegistrationService` → use case orchestration

### Why it’s better
- More testable and maintainable.
- Less coupling and clearer responsibilities.

---

## ✅ D — Dependency Inversion Principle (DIP)

### What was wrong
- `ServicePerson` created `MySql` directly (`new MySql()`), causing tight coupling.

### Why it violated DIP
- The high-level module depended on a specific low-level implementation.

### Solution applied
- Created `PersonRepository` (abstraction).
- Moved MySQL logic to `MySqlPersonRepository`.
- Injected the repository into `ServicePerson`.

### Why it’s better
- I can replace MySQL with another implementation (Memory, MongoDB, API) without modifying `ServicePerson`.
- Easier to test (mock/fake repository).

---

## ✅ O — Open/Closed Principle (OCP)

### What was wrong
- `InstrumentPlayer` used `if/else` to decide what to do depending on a `String` instrument.

### Why it violated OCP
- Every time we add a new instrument, we must modify `InstrumentPlayer`, risking regressions.

### Solution applied
- Introduced an abstraction: `Instrument` with `play()`.
- Created concrete implementations: `Guitar`, `Drums`, `Piano`.
- Injected them into `InstrumentPlayer` using a `Map<String, Instrument>`.

### Why it’s better
- To add a new instrument, I only add a new class implementing `Instrument` and register it in the map.
- Cleaner code, easier testing, no long conditional chains.

---

## ✅ I — Interface Segregation Principle (ISP)

### What was wrong
- `MachineActions` forced classes to implement methods they don’t need:
    - `wash()` in `AirConditioner`
    - `heat()` / `cool()` in `WashingMachine`

### Why it violated ISP
- The interface was “fat” (too many responsibilities).
- Clients were forced to depend on methods they don’t use, leading to meaningless implementations.

### Solution applied
Split the big interface into smaller, focused interfaces:
- `Switchable` → `turnOn()`, `turnOff()`
- `Heater` → `heat()`
- `Cooler` → `cool()`
- `Washable` → `wash()`

Then:
- `AirConditioner` implements `Switchable`, `Heater`, `Cooler`.
- `WashingMachine` implements `Switchable`, `Washable`.

### Why it’s better
- Classes are simpler and only implement what they actually support.
- Interfaces are reusable, flexible, and reduce coupling.

---

## ✅ L — Liskov Substitution Principle (LSP)

### What was wrong
- `Ghost` extended `Character` but threw an exception in `takeDamage()`, breaking the expected behavior of the base type.

### Why it violated LSP
- Code that works with `Character` expects `takeDamage()` to be valid.
- Replacing a `Character` with a `Ghost` could break the program at runtime.

### Solution applied
- `Character` keeps only common behavior (e.g., `attack()`).
- Introduced `Damageable` interface for characters that can take damage.
- `Warrior` implements `Damageable`.
- `Ghost` does **not** implement `Damageable`, so it never promises it can take damage.

### Why it’s better
- Subtypes don’t break the base contract anymore (safe substitution).
- Clearer design: only damageable characters expose `takeDamage()`.
- No runtime surprises (no `UnsupportedOperationException` in normal polymorphic use).
