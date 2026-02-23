package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.engine.GeofenceEngine;
import com.moveinsync.vehicleTracking.model.Location;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GeofenceServiceImpl implements GeofenceService {

    private final GeofenceEngine geofenceEngine = new GeofenceEngine();

    @Override
    @Cacheable("geofenceCache")  // Caching for performance (case study requirement)
    public boolean checkGeofence(Location location) {

        // Fault Tolerance (system failure handling)
        if (location == null) {
            throw new RuntimeException("Location cannot be null");
        }

        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude value");
        }

        if (location.getLongitude() < -180 || location.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude value");
        }

        // Core Logic (uses your existing GeoFenceEngine)
        boolean isInside = geofenceEngine.isInsideGeofence(location);

        // System Monitoring (logs)
        System.out.println("Vehicle Location: Lat=" + location.getLatitude() +
                ", Lon=" + location.getLongitude());
        System.out.println("Geofence Result: " + (isInside ? "INSIDE" : "OUTSIDE"));

        return isInside;
    }
}