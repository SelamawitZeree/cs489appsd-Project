# Dental Clinic (Spring Boot)

Entities mapped from the ER diagram: Dentist, Patient, Surgery, Appointment, Bill.

## Build & Run
```bash
mvn -v  # Java 17 required
mvn spring-boot:run
```
Configure `src/main/resources/application.properties` for your DB (MySQL by default).

## Basic APIs
- GET /api/patients
- GET /api/dentists
- GET /api/surgeries
- GET /api/appointments
- GET /api/bills


## Architecture
- Controller → Service → Repository → JPA → DB
- Service layer added for clean separation, testability, and future business rules.
