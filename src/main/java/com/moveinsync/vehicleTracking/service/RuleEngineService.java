package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.engine.GeofenceEngine;
import com.moveinsync.vehicleTracking.model.EventLog;
import com.moveinsync.vehicleTracking.model.Location;

public class RuleEngineService {

    private final GeofenceEngine geofenceEngine = new GeofenceEngine();
    private final EventService eventService = new EventService();

    public void processLocation(String vehicleId, String tripId,
                                Location location,
                                double pickupLat, double pickupLon) {

        if (geofenceEngine.isInsidePickupGeofence(location, pickupLat, pickupLon)) {
            eventService.logEvent(
                    new EventLog(vehicleId, tripId, "PICKUP_ARRIVED",
                            location.getLatitude(), location.getLongitude())
            );
        }
        if (geofenceEngine.isInsideOfficeGeofence(location)) {
            eventService.logEvent(
                    new EventLog(vehicleId, tripId, "TRIP_COMPLETED",
                            location.getLatitude(), location.getLongitude())
            );
        }
    }
}