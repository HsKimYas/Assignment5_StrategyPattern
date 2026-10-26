# Strategy Pattern — Navigation / Route Planning

## Project idea

The project demonstrates the **Strategy behavioral design pattern** in a route-planning application. A `Navigator` (Context) can use different route-planning algorithms without changing its own code:

- `CarStrategy` — route optimized for a car;
- `WalkStrategy` — pedestrian route;
- `CycleStrategy` — bicycle route.

The strategy can be replaced at runtime with `Navigator#setStrategy(...)`.

## Requirements

- Java 17
- Maven 3.9+ (recommended) or IntelliJ IDEA

## Project structure

```text
src/
├── main/java/com/aitu/strategy/
│   ├── RouteStrategy.java
│   ├── RouteRequest.java
│   ├── Route.java
│   ├── CarStrategy.java
│   ├── WalkStrategy.java
│   ├── CycleStrategy.java
│   ├── Navigator.java
│   └── Main.java
└── test/java/com/aitu/strategy/
    └── NavigatorTest.java

docs/
└── strategy-uml.puml

README.md
REPORT.md
pom.xml
```

## Build and test

```bash
mvn test
```

Compile and run the demo from IntelliJ IDEA by running `Main.java`.

A successful demo shows the same trip being planned first by car, then by walking, then by bicycle. This demonstrates runtime strategy switching.

## How to add a new strategy

1. Create a class implementing `RouteStrategy`.
2. Implement `planRoute(RouteRequest)` and `name()`.
3. Keep the new algorithm inside that class.
4. Pass an instance to `Navigator` or call `setStrategy(...)` at runtime.

For example, a future `PublicTransportStrategy` would be added without modifying `Navigator`, `CarStrategy`, `WalkStrategy`, or `CycleStrategy`.

## Design summary

```text
Client (Main)
      |
      v
Navigator (Context) -----> RouteStrategy (interface)
                               ^
                    ___________|___________
                   |           |           |
             CarStrategy  WalkStrategy  CycleStrategy
```

`Navigator` knows only the `RouteStrategy` abstraction. It does not contain `if`/`switch` logic for choosing concrete algorithms.
