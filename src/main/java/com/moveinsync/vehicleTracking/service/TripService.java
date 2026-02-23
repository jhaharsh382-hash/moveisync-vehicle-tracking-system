package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.cache.TripCache;
import com.moveinsync.vehicleTracking.engine.GeofenceEngine;
import com.moveinsync.vehicleTracking.model.Location;
import com.moveinsync.vehicleTracking.model.Trip;

public class TripService {

    private TripCache tripCache = new TripCache();
    private GeofenceEngine geofenceEngine = new GeofenceEngine();
    public String startTrip(String tripId) {
        Trip trip = new Trip(tripId);
        tripCache.addTrip(trip);
        return "Trip started with ID: " + tripId;
    }
    public String updateLocation(String tripId, Location location) {
        Trip trip = tripCache.getTrip(tripId);

        if (trip == null) {
            return "Trip not found!";
        }

        if (!trip.isActive()) {
            return "Trip already closed!";
        }

        trip.setLastLocation(location);
        if (geofenceEngine.isInsideGeofence(location)) {
            trip.endTrip();
            tripCache.removeTrip(tripId);
            return "Trip auto-closed: Vehicle reached geofence.";
        }

        return "Location updated successfully.";
    }
    public String endTrip(String tripId) {
        Trip trip = tripCache.getTrip(tripId);

        if (trip == null) {
            return "Trip not found!";
        }

        trip.endTrip();
        tripCache.removeTrip(tripId);
        return "Trip ended manually.";
    }
}
