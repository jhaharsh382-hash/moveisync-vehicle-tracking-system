
package com.moveinsync.vehicleTracking.controller;

import com.moveinsync.vehicleTracking.engine.GeofenceEngine;
import com.moveinsync.vehicleTracking.model.Location;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final GeofenceEngine geofenceEngine = new GeofenceEngine();

    @GetMapping("/test")
    public String testApi() {
        return "Vehicle Tracking System is Running Successfully!";
    }

    @PostMapping("/check-geofence")
    public String checkGeofence(@RequestBody Location location) {
        boolean inside = geofenceEngine.isInsideGeofence(location);
        if (inside) {
            return "Vehicle is inside geofence";
        } else {
            return "Vehicle is outside geofence";
        }
    }
}