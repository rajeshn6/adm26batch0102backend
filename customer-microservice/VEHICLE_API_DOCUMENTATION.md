# Vehicle Management API Documentation

## Overview
This is a Spring Boot REST API for managing vehicles with full CRUD operations, validation, and custom exception handling.

## Technology Stack
- Spring Boot 3.3.5
- MySQL Database
- Spring Data JPA
- Jakarta Validation
- Maven

## Prerequisites
- Java 17 or higher
- MySQL Server running on localhost:3306
- Maven

## Database Setup
The application will automatically create the database `vms` if it doesn't exist.
Default credentials:
- Username: `root`
- Password: `root`

Update `application.properties` if your MySQL credentials are different.

## Running the Application
```bash
cd backend/vehicle-management-system
mvn spring-boot:run
```

The server will start on `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api/vehicles
```

### 1. Create Vehicle (Register)
**Endpoint:** `POST /api/vehicles`

**Request Body:**
```json
{
  "vin": "ABC12345",
  "model": "Toyota Camry",
  "year": 2024,
  "status": "ACTIVE",
  "userId": 1,
  "name": "John Doe"
}
```

**Success Response (201 Created):**
```json
{
  "message": "Vehicle registered successfully",
  "vehicle": {
    "id": 1,
    "vin": "ABC12345",
    "model": "Toyota Camry",
    "year": 2024,
    "status": "ACTIVE",
    "userId": 1,
    "name": "John Doe",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
}
```

**Error Response (400 Bad Request):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Invalid input data provided",
  "path": "/api/vehicles",
  "validationErrors": {
    "vin": "VIN must be exactly 8 characters",
    "year": "Year cannot exceed 2026"
  }
}
```

### 2. Get All Vehicles
**Endpoint:** `GET /api/vehicles`

**Success Response (200 OK):**
```json
[
  {
    "id": 1,
    "vin": "ABC12345",
    "model": "Toyota Camry",
    "year": 2024,
    "status": "ACTIVE",
    "userId": 1,
    "name": "John Doe",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
]
```

### 3. Get Vehicle by ID
**Endpoint:** `GET /api/vehicles/{id}`

**Example:** `GET /api/vehicles/1`

**Success Response (200 OK):**
```json
{
  "id": 1,
  "vin": "ABC12345",
  "model": "Toyota Camry",
  "year": 2024,
  "status": "ACTIVE",
  "userId": 1,
  "name": "John Doe",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

**Error Response (404 Not Found):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Vehicle not found with id: 1",
  "path": "/api/vehicles/1"
}
```

### 4. Get Vehicles by User ID
**Endpoint:** `GET /api/vehicles/user/{userId}`

**Example:** `GET /api/vehicles/user/1`

**Success Response (200 OK):**
```json
[
  {
    "id": 1,
    "vin": "ABC12345",
    "model": "Toyota Camry",
    "year": 2024,
    "status": "ACTIVE",
    "userId": 1,
    "name": "John Doe",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
]
```

### 5. Update Vehicle
**Endpoint:** `PUT /api/vehicles/{id}`

**Example:** `PUT /api/vehicles/1`

**Request Body:**
```json
{
  "vin": "ABC12345",
  "model": "Toyota Camry 2024",
  "year": 2024,
  "status": "INACTIVE",
  "userId": 1,
  "name": "John Doe"
}
```

**Success Response (200 OK):**
```json
{
  "message": "Vehicle updated successfully",
  "vehicle": {
    "id": 1,
    "vin": "ABC12345",
    "model": "Toyota Camry 2024",
    "year": 2024,
    "status": "INACTIVE",
    "userId": 1,
    "name": "John Doe",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T11:00:00"
  }
}
```

### 6. Delete Vehicle
**Endpoint:** `DELETE /api/vehicles/{id}`

**Example:** `DELETE /api/vehicles/1`

**Success Response (200 OK):**
```json
{
  "message": "Vehicle deleted successfully"
}
```

## Validation Rules

### VIN (Vehicle Identification Number)
- Required
- Must be exactly 8 characters
- Must be unique

### Model
- Required
- Cannot be empty or whitespace only

### Year
- Required
- Must be between 1900 and 2026
- Must be a valid integer

### Status
- Required
- Must be either "ACTIVE" or "INACTIVE"

### User ID
- Required
- Must be a valid Long value

### Name
- Required
- Cannot be empty or whitespace only

## Custom Exceptions

### ResourceNotFoundException (404)
Thrown when a vehicle is not found by ID.

### DuplicateResourceException (409)
Thrown when attempting to create a vehicle with a VIN that already exists.

### InvalidDataException (400)
Thrown when data validation fails beyond standard Jakarta validation.

## Error Response Format
All errors follow a consistent format:
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Error Type",
  "message": "Detailed error message",
  "path": "/api/vehicles",
  "validationErrors": {
    "field": "error message"
  }
}
```

## Frontend Integration

Update your frontend axios call from:
```javascript
axios.post("http://localhost:3001/vehicles", payload)
```

To:
```javascript
axios.post("http://localhost:8080/api/vehicles", payload)
```

## Testing with cURL

### Create Vehicle
```bash
curl -X POST http://localhost:8080/api/vehicles \
  -H "Content-Type: application/json" \
  -d '{
    "vin": "ABC12345",
    "model": "Toyota Camry",
    "year": 2024,
    "status": "ACTIVE",
    "userId": 1,
    "name": "John Doe"
  }'
```

### Get All Vehicles
```bash
curl http://localhost:8080/api/vehicles
```

### Get Vehicle by ID
```bash
curl http://localhost:8080/api/vehicles/1
```

### Update Vehicle
```bash
curl -X PUT http://localhost:8080/api/vehicles/1 \
  -H "Content-Type: application/json" \
  -d '{
    "vin": "ABC12345",
    "model": "Toyota Camry Updated",
    "year": 2024,
    "status": "INACTIVE",
    "userId": 1,
    "name": "John Doe"
  }'
```

### Delete Vehicle
```bash
curl -X DELETE http://localhost:8080/api/vehicles/1
```

## Project Structure
```
src/main/java/com/cts/
├── config/
│   └── CorsConfig.java
├── controller/
│   └── VehicleController.java
├── dto/
│   └── ErrorResponse.java
├── entity/
│   └── Vehicle.java
├── exception/
│   ├── DuplicateResourceException.java
│   ├── GlobalExceptionHandler.java
│   ├── InvalidDataException.java
│   └── ResourceNotFoundException.java
├── repository/
│   └── VehicleRepository.java
├── service/
│   └── VehicleService.java
└── VehicleManagementSystemApplication.java
```
