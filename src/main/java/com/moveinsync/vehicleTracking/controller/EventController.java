package com.moveinsync.vehicleTracking.controller;

import com.moveinsync.vehicleTracking.model.EventLog;
import com.moveinsync.vehicleTracking.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventLog> getAllEvents() {
        return eventService.getAllEvents();
    }
}
