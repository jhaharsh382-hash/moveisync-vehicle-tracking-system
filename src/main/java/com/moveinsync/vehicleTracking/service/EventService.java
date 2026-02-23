package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.model.EventLog;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    private final List<EventLog> eventLogs = new ArrayList<>();

    public void logEvent(EventLog event) {
        eventLogs.add(event);
        System.out.println("EVENT LOGGED: " + event.getEventType() +
                " | Trip: " + event.getTripId() +
                " | Vehicle: " + event.getVehicleId());
    }

    public List<EventLog> getAllEvents() {
        return eventLogs;
    }
}
