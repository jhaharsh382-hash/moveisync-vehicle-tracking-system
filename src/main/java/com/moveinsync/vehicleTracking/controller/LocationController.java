package com.moveinsync.vehicleTracking.controller;

import com.moveinsync.vehicleTracking.model.Location;
import com.moveinsync.vehicleTracking.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private TripService tripService;

    @PostMapping("/update/{tripId}")
    public String updateLocation(
            @PathVariable String tripId,
            @RequestBody Location location) {

        return tripService.updateLocation(tripId, location);
    }
}