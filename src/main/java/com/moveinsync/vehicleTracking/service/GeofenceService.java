package com.moveinsync.vehicleTracking.service;

import com.moveinsync.vehicleTracking.model.Location;

public interface GeofenceService {

    boolean checkGeofence(Location location);

}
