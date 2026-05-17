# RoasteryLogistics
## Course: Object Oriented Programming

## Assignment: OOP Project 3

## Student: Semion Yohannes
## Project Description
RoasteryLogistics is a Java console application that simulates end-to-end coffee production tracking inside a roastery. It models key roles (manager and production workers), lets the manager define weight and quality targets, and allows each role to record work data. The system then calculates quality scores, contribution percentages, and progress reports so production performance can be monitored consistently from one stage to the next.

## Scope
In scope: harvesting, sorting and cleaning, roasting, grinding or whole-bean handling, packaging, goal setting, and production/quality reporting by role and overall progress. Out of scope: retail sales, inventory distribution, customer orders, payment processing, and external integrations (databases, web APIs, or GUI front-ends).

## How to Compile and Run
javac roastery/Main.java
java roastery.Main

## User Roles
Manager
Harvester
Sorting & Cleaning Operator
Roaster
Grinder
Packager

## OOP Concepts Demonstrated (V1.0 - V4.0)
V1.0: Introduction to OOP in Java
- Classes and Objects: [src/roastery/Main.java](src/roastery/Main.java#L19-L28)
- Encapsulation (private fields + getters/setters with validation): [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L3-L143)
- Constructors: [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L18-L23), [src/roastery/users/Manager.java](src/roastery/users/Manager.java#L3-L6)

V2.0: Core OOP Concepts in Java
- Access Modifiers (public/protected/private): [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L3-L143), [src/roastery/users/User.java](src/roastery/users/User.java#L3-L18), [src/roastery/users/ProductionWorker.java](src/roastery/users/ProductionWorker.java#L7-L55)

V3.0: Java Inheritance
- Inheritance (is-a relationships): [src/roastery/users/User.java](src/roastery/users/User.java#L3-L19), [src/roastery/users/ProductionWorker.java](src/roastery/users/ProductionWorker.java#L7-L33), [src/roastery/users/Harvester.java](src/roastery/users/Harvester.java#L8-L64)

V4.0: Java Polymorphism
- Method Overriding (runtime polymorphism): [src/roastery/users/Harvester.java](src/roastery/users/Harvester.java#L16-L64), [src/roastery/users/Roaster.java](src/roastery/users/Roaster.java#L17-L75)
- Method Overloading (compile-time polymorphism): [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L26-L38)
- Superclass References (dynamic dispatch with ProductionWorker): [src/roastery/Main.java](src/roastery/Main.java#L23-L45), [src/roastery/services/ReportService.java](src/roastery/services/ReportService.java#L28-L67)

## Additional Concepts (Outside V1.0 - V4.0)
- Abstraction (abstract classes + abstract methods): [src/roastery/users/User.java](src/roastery/users/User.java#L3-L12), [src/roastery/users/ProductionWorker.java](src/roastery/users/ProductionWorker.java#L7-L33)
- Packages: [src/roastery/Main.java](src/roastery/Main.java#L1), [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L1), [src/roastery/users/User.java](src/roastery/users/User.java#L1), [src/roastery/services/ReportService.java](src/roastery/services/ReportService.java#L1)
- ArrayList: [src/roastery/Main.java](src/roastery/Main.java#L23-L28)
- Scanner Input: [src/roastery/Main.java](src/roastery/Main.java#L19), [src/roastery/services/InputValidator.java](src/roastery/services/InputValidator.java#L6-L63)
- Exception Handling: [src/roastery/services/InputValidator.java](src/roastery/services/InputValidator.java#L6-L50), [src/roastery/models/ProductionGoal.java](src/roastery/models/ProductionGoal.java#L45-L143)
