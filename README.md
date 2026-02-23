# Real-Time Vehicle Tracking & Geofence Automation System

**Author:** Harsh Jha – jhaharsh382-hash(https://github.com/jhaharsh382)

---

## Overview

This project is a **real-time Vehicle Tracking and Geofence Automation System**, designed to optimize enterprise transport operations for Moveinsync.

Key features include:
- **Live GPS Tracking:** Continuously streams vehicle locations in real-time.
- **Geofence Automation:** Detects vehicle entry/exit at designated zones such as pickup points and office premises.
- **Automatic Trip Management:** Automatically closes trips when vehicles enter office geofences.
- **Operational Efficiency:** Reduces manual intervention and provides live visibility for transport managers.

This system ensures accurate vehicle monitoring, timely notifications, and streamlined transport operations.

---

## Features

1. **Real-Time Location Tracking** – Track vehicles on a live map using GPS coordinates.
2. **Geofence Notifications** – Detect arrivals at pickup points and office geofences automatically.
3. **Trip Automation** – Close trips automatically when vehicles enter office geofences.
4. **RESTful API Support** – Provides endpoints to manage vehicles and locations.

---

## Getting Started

### Prerequisites
- Java 17+
- Maven or Gradle
- IntelliJ IDEA (or any Java IDE)

### Running the Application
1. Open the project in **IntelliJ IDEA**.
2. Run the main class: `VehicleTrackingApplication`.
3. Open a browser and visit: `http://localhost:8080/` (displays a home message).
4. Test GET endpoints:
    - `/vehicle/` – List all vehicles
    - `/location/` – Get latest vehicle locations

**Note:** POST, PUT, and DELETE requests can be tested via **Postman** or a frontend form.

---

## API Endpoints

| Method | Endpoint        | Description                     |
|--------|----------------|---------------------------------|
| GET    | `/vehicle/`     | List all vehicles               |
| GET    | `/location/`    | Get latest locations of vehicles|
| POST   | `/vehicle/`     | Add a new vehicle               |
| PUT    | `/vehicle/{id}` | Update vehicle details          |
| DELETE | `/vehicle/{id}` | Remove a vehicle                |

---
## Technology Stack
- **Java** – Backend language
- **Spring Boot** – REST API and application framework
- **Maven/Gradle** – Project management and dependencies
---

## Future Enhancements
- Integration with **live map visualization** (e.g., Google Maps).
- Push notifications for **driver arrival alerts**.
- Analytics dashboard for **fleet performance monitoring**.  