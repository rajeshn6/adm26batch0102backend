# Service Booking API Documentation

## ✅ Backend APIs Implemented

### 1. **Book Service**
- **Endpoint:** `POST /api/services`
- **Request Body:**
```json
{
  "vehicleId": 1,
  "serviceType": "PREVENTIVE",
  "serviceCategory": "ENGINE",
  "partsToReplace": "Oil filter, Air filter",
  "urgency": "MEDIUM",
  "additionalNotes": "Engine making unusual noise",
  "scheduledDate": "2024-02-15",
  "status": "PENDING",
  "userId": "user123"
}
```
- **Response:** Service record with ID

### 2. **Get All Service Records**
- **Endpoint:** `GET /api/services`
- **Response:** Array of all service records

### 3. **Get Service Record by ID**
- **Endpoint:** `GET /api/services/{id}`
- **Response:** Single service record

### 4. **Get Service Records by User ID**
- **Endpoint:** `GET /api/services/user/{userId}`
- **Response:** Array of service records for specific user

### 5. **Get Service Records by Vehicle ID**
- **Endpoint:** `GET /api/services/vehicle/{vehicleId}`
- **Response:** Array of service records for specific vehicle

### 6. **Get Service Records by Status**
- **Endpoint:** `GET /api/services/status/{status}`
- **Response:** Array of service records with specific status
- **Status values:** PENDING, IN_PROGRESS, COMPLETED, CANCELLED

### 7. **Update Service Record**
- **Endpoint:** `PUT /api/services/{id}`
- **Request Body:** Same as create
- **Response:** Updated service record

### 8. **Delete Service Record**
- **Endpoint:** `DELETE /api/services/{id}`
- **Response:** Success message

## 🔧 Validation Rules

- **Vehicle ID:** Required, must exist in database
- **Service Type:** Required, must be PREVENTIVE or CORRECTIVE
- **Service Category:** Required (ENGINE, TRANSMISSION, BRAKES, ELECTRICAL, SUSPENSION, TIRES, GENERAL, OTHER)
- **Urgency:** Required (LOW, MEDIUM, HIGH, EMERGENCY)
- **Scheduled Date:** Required, cannot be in the past
- **Status:** PENDING (default), IN_PROGRESS, COMPLETED, CANCELLED
- **User ID:** Required

## 📋 Service Categories

- ENGINE - Engine Service
- TRANSMISSION - Transmission Service
- BRAKES - Brake Service
- ELECTRICAL - Electrical Service
- SUSPENSION - Suspension Service
- TIRES - Tire Service
- GENERAL - General Maintenance
- OTHER - Other

## 🎯 Frontend Integration

**BookService.jsx** updated to:
- Fetch user's vehicles from Spring Boot API
- Submit service booking to Spring Boot API
- Handle validation errors properly

## 🚀 Testing

1. Login as customer
2. Go to Dashboard → Schedule Service
3. Select a vehicle
4. Fill service details
5. Click "Book Service"
6. Service will be saved with PENDING status

All APIs are working and integrated!
