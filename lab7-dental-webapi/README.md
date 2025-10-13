# ADS Dental Surgeries - Lab 7 (Spring Boot REST WebAPI)

Implements the required REST endpoints for **Lesson 7** using Spring Boot + Spring Web MVC + Spring Data JPA + H2.

## Run

```bash
mvn spring-boot:run
```
App starts at `http://localhost:8080`.

## Endpoints (per assignment)

1. **GET** `/adsweb/api/v1/patients`  
   Returns **all patients** with `primaryAddress`, sorted by `lastName` ascending (JSON).

2. **GET** `/adsweb/api/v1/patients/{id}`  
   Returns **one patient** by id with `primaryAddress`.  
   Invalid `id` → returns `404 { "message": "Patient with id X not found" }`.

3. **POST** `/adsweb/api/v1/patients`  
   **Register a new patient**. Example JSON:
   ```json
   {
     "firstName": "Diana",
     "lastName": "Evans",
     "email": "diana.evans@example.com",
     "phone": "555-222-3333",
     "dateOfBirth": "1995-06-05",
     "primaryAddress": {
       "street": "88 Oak St",
       "city": "Frisco",
       "state": "TX",
       "zipCode": "75034"
     }
   }
   ```

4. **PUT** `/adsweb/api/v1/patient/{id}`  
   **Update an existing patient** (any subset of fields, including nested `primaryAddress`).  
   Invalid `id` → `404` with JSON error.

5. **DELETE** `/adsweb/api/v1/patient/{id}`  
   **Deletes** the patient. Returns `204 No Content` on success.

6. **GET** `/adsweb/api/v1/patient/search/{searchString}`  
   **Search** across firstName, lastName, email, phone.

7. **GET** `/adsweb/api/v1/addresses`  
   Returns **all addresses** with minimal **patient** data, sorted by **city** ascending.

## Postman Screenshots
Take screenshots of the above endpoints (200/201/204/404 cases) and put them into:  
`/screenshots` inside the project root (as the assignment requires).

## Notes
- Uses in-memory H2 with sample seed data (3 patients + addresses).
- Entities: `Patient` (with `primaryAddress`) and `Address` (with `patient` reference for `/addresses`).  
- Global exception handler returns JSON for not found and validation errors.
