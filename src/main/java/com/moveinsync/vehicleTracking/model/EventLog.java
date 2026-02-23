package com.moveinsync.vehicleTracking.model;

import java.time.LocalDateTime;

public class EventLog {

    private String vehicleId;
    private String tripId;
    private String eventType;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

    public EventLog(String vehicleId, String tripId, String eventType,
                    double latitude, double longitude) {
        this.vehicleId = vehicleId;
        this.tripId = tripId;
        this.eventType = eventType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = LocalDateTime.now();
    }

    public String getVehicleId() { return vehicleId; }
    public String getTripId() { return tripId; }
    public String getEventType() { return eventType; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
