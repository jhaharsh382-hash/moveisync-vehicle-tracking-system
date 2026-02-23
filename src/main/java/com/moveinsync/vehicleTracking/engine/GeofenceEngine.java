package com.moveinsync.vehicleTracking.engine;

import com.moveinsync.vehicleTracking.model.Location;

public class GeofenceEngine {

    private static final double OFFICE_LAT = 12.9716;
    private static final double OFFICE_LON = 77.5946;
    private static final double OFFICE_RADIUS = 0.5; // km

    private static final double PICKUP_RADIUS = 0.1; // 100 meters

    // Compatibility method (fixes your error)
    public boolean isInsideGeofence(Location location) {
        return isInsideOfficeGeofence(location);
    }

    public boolean isInsideOfficeGeofence(Location location) {
        double distance = calculateDistance(
                location.getLatitude(),
                location.getLongitude(),
                OFFICE_LAT,
                OFFICE_LON
        );
        return distance <= OFFICE_RADIUS;
    }

    public boolean isInsidePickupGeofence(Location location,
                                          double pickupLat,
                                          double pickupLon) {

        double distance = calculateDistance(
                location.getLatitude(),
                location.getLongitude(),
                pickupLat,
                pickupLon
        );
        return distance <= PICKUP_RADIUS;
    }

    private double calculateDistance(double lat1, double lon1,
                                     double lat2, double lon2) {
        double dx = lat1 - lat2;
        double dy = lon1 - lon2;
        return Math.sqrt(dx * dx + dy * dy) * 111;
    }
}