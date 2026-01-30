# Maintenance Alert System Documentation

## Overview
Automated maintenance alert system that notifies customers 2 months after their last completed service.

## How It Works

### 1. **Alert Generation Logic**
- **Trigger**: Automatically runs daily at 2:00 AM
- **Interval**: Alerts generated 2 months after last completed service
- **Alert Types**:
  - **OVERDUE** (Red): Service date has passed
  - **WARNING** (Orange): Service due within 7 days
  - **INFO** (Blue): Service due within 14 days

### 2. **Alert Timeline**

```
Last Service Completed
        ↓
    [2 months]
        ↓
   14 days before → INFO alert generated
        ↓
    7 days before → WARNING alert generated
        ↓
    Service Due Date
        ↓
    After due date → OVERDUE alert
```

### 3. **When Customers Receive Notifications**

#### **Daily Automated Check (2:00 AM)**
- System scans all vehicles
- Checks last completed service date
- Generates alerts for vehicles due in 14 days or less

#### **Customer Views Alerts**
- Login to customer dashboard
- Click "Maintenance Alerts" card
- View all active alerts for their vehicles

#### **Alert Display Locations**
1. **Dashboard Badge**: Shows count of unread alerts
2. **Maintenance Alerts Page**: Full list with details
3. **Vehicle Details**: Alerts specific to each vehicle

### 4. **Alert Metrics**

| Metric | Value | Description |
|--------|-------|-------------|
| Service Interval | 2 months | Time between services |
| Early Warning | 14 days | INFO alert appears |
| Urgent Warning | 7 days | WARNING alert appears |
| Overdue | 0 days | OVERDUE alert appears |
| Check Frequency | Daily | System runs at 2 AM |

### 5. **Notification Flow**

```
Service Completed (Day 0)
    ↓
System waits 2 months
    ↓
Day 46: INFO alert created (14 days before due)
    ↓
Day 53: Upgraded to WARNING (7 days before due)
    ↓
Day 60: Service Due Date
    ↓
Day 61+: OVERDUE alert
```

### 6. **Backend APIs**

#### Get Alerts by User
```
GET /api/maintenance-alerts/user/{userId}
```
Returns all alerts for a user

#### Get Unread Alerts
```
GET /api/maintenance-alerts/user/{userId}/unread
```
Returns only unread alerts

#### Mark Alert as Read
```
PUT /api/maintenance-alerts/{alertId}/mark-read
```
Marks an alert as read

### 7. **Alert Content**

Each alert includes:
- **Vehicle Details**: VIN, Model, Year
- **Last Service Date**: When last serviced
- **Next Service Due**: Calculated date (2 months after last)
- **Alert Type**: OVERDUE, WARNING, or INFO
- **Message**: Descriptive alert message
- **Maintenance Suggestions**: Based on last service category
  - Engine: Oil, filters, belts
  - Brakes: Pads, rotors, fluid
  - Suspension: Shocks, alignment
  - Transmission: Fluid, leaks
  - Electrical: Battery, alternator
  - General: Comprehensive check

### 8. **Customer Experience**

#### **Dashboard View**
- Badge shows: "🔔 1 Alert" (if unread alerts exist)
- Click "Maintenance Alerts" card to view details

#### **Alerts Page**
- Color-coded cards (Red/Orange/Blue)
- Vehicle information
- Service history
- Maintenance recommendations
- "Mark as Read" button

#### **Email Notifications** (Future Enhancement)
- Send email when alert is created
- Reminder 3 days before due date
- Overdue notification

### 9. **Example Scenarios**

#### Scenario 1: Regular Maintenance
```
Jan 1: Service completed
Mar 1: System generates INFO alert (14 days before due)
Mar 8: Alert upgraded to WARNING (7 days before due)
Mar 15: Service due date
Customer books service on Mar 10
```

#### Scenario 2: Overdue Service
```
Jan 1: Service completed
Mar 1: INFO alert generated
Mar 8: WARNING alert
Mar 15: Service due
Mar 20: OVERDUE alert (customer hasn't serviced)
```

#### Scenario 3: New Vehicle
```
Vehicle registered with no service history
System generates WARNING alert immediately
Suggests initial comprehensive service
```

### 10. **Configuration**

To change alert intervals, modify `MaintenanceAlertService.java`:

```java
// Current: 2 months
nextServiceDue = lastServiceDate.plusMonths(2);

// Change to 3 months:
nextServiceDue = lastServiceDate.plusMonths(3);

// Change to 90 days:
nextServiceDue = lastServiceDate.plusDays(90);
```

### 11. **Testing**

1. Complete a service for a vehicle
2. Manually trigger alert generation (or wait for 2 AM)
3. Check alerts appear in customer dashboard
4. Verify alert type based on days until service

### 12. **Benefits**

✅ Proactive maintenance reminders
✅ Reduces vehicle downtime
✅ Improves customer retention
✅ Automated - no manual intervention
✅ Customizable intervals
✅ Detailed maintenance suggestions

## Summary

Customers receive maintenance alerts **2 months after their last completed service**. The system automatically checks daily at 2 AM and generates alerts 14 days before the service is due. Customers can view these alerts anytime by logging into their dashboard and clicking on "Maintenance Alerts".
