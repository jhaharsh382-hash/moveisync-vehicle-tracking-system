package com.moveinsync.vehicleTracking.controller;

import com.moveinsync.vehicleTracking.model.Location;
import com.moveinsync.vehicleTracking.service.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController {

    private TripService tripService = new TripService();
    @PostMapping("/start/{tripId}")
    public String startTrip(@PathVariable String tripId) {
        return tripService.startTrip(tripId);
    }
    @PostMapping("/update/{tripId}")
    public String updateLocation(
            @PathVariable String tripId,
            @RequestBody Location location) {

        return tripService.updateLocation(tripId, location);
    }
    @PostMapping("/end/{tripId}")
    public String endTrip(@PathVariable String tripId) {
        return tripService.endTrip(tripId);
    }
}