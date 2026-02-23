package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.model.EventLog;
import com.moveinsync.vehicleTracking.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TripService {

    private Map<String, String> tripStatus = new HashMap<>();

    @Autowired
    private EventService eventService;

    public String startTrip(String tripId) {

        if (tripStatus.containsKey(tripId)) {
            return "Trip already started!";
        }

        tripStatus.put(tripId, "ACTIVE");

        eventService.logEvent(
                new EventLog("TRIP_STARTED", tripId, "V101")
        );

        return "Trip " + tripId + " started successfully.";
    }

    public String updateLocation(String tripId, Location location) {

        if (!tripStatus.containsKey(tripId)) {
            return "Trip not found!";
        }

        eventService.logEvent(
                new EventLog(
                        "LOCATION_UPDATED",
                        tripId,
                        "V101",
                        location.getLatitude(),
                        location.getLongitude()
                )
        );

        return "Location updated for trip " + tripId;
    }

    public String endTrip(String tripId) {

        if (!tripStatus.containsKey(tripId)) {
            return "Trip not found!";
        }

        tripStatus.remove(tripId);

        eventService.logEvent(
                new EventLog("TRIP_ENDED", tripId, "V101")
        );

        return "Trip " + tripId + " ended successfully.";
    }
}