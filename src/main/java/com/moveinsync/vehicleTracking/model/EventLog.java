package com.moveinsync.vehicleTracking.model;

public class EventLog {

    private String eventType;
    private String tripId;
    private String vehicleId;
    private Double latitude;
    private Double longitude;

    public EventLog() {}

    public EventLog(String eventType, String tripId, String vehicleId) {
        this.eventType = eventType;
        this.tripId = tripId;
        this.vehicleId = vehicleId;
    }

    public EventLog(String eventType, String tripId, String vehicleId,
                    Double latitude, Double longitude) {
        this.eventType = eventType;
        this.tripId = tripId;
        this.vehicleId = vehicleId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}