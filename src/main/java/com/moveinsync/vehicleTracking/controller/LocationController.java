package com.moveinsync.vehicleTracking.controller;
import com.moveinsync.vehicleTracking.model.Location;
import com.moveinsync.vehicleTracking.service.RuleEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final RuleEngineService ruleEngineService = new RuleEngineService();
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateLocation(
            @RequestParam String vehicleId,
            @RequestParam String tripId,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double pickupLat,
            @RequestParam double pickupLon
    ) {
        Location location = new Location(latitude, longitude);

        ruleEngineService.processLocation(
                vehicleId,
                tripId,
                location,
                pickupLat,
                pickupLon
        );

        return "Location processed successfully | Vehicle: " + vehicleId +
                " | Trip: " + tripId +
                " | Lat: " + latitude +
                " | Lon: " + longitude;
    }
}