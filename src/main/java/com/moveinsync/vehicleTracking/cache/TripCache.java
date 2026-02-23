
package com.moveinsync.vehicleTracking.cache;

import com.moveinsync.vehicleTracking.model.Trip;
import java.util.HashMap;
import java.util.Map;

public class TripCache {

    private Map<String, Trip> activeTrips = new HashMap<>();

    public void addTrip(Trip trip) {
        activeTrips.put(trip.getTripId(), trip);
    }

    public Trip getTrip(String tripId) {
        return activeTrips.get(tripId);
    }

    public void removeTrip(String tripId) {
        activeTrips.remove(tripId);
    }
}