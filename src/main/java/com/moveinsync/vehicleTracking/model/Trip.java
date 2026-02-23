package com.moveinsync.vehicleTracking.model;

public class Trip {
    private String tripId;
    private boolean active;
    private Location lastLocation;

    public Trip(String tripId) {
        this.tripId = tripId;
        this.active = true;
    }

    public String getTripId() { return tripId; }
    public boolean isActive() { return active; }
    public void endTrip() { this.active = false; }

    public Location getLastLocation() { return lastLocation; }
    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
}