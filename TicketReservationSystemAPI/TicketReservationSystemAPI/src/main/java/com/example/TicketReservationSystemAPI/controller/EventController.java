package com.example.TicketReservationSystemAPI.controller;

import com.example.TicketReservationSystemAPI.model.Event;
import com.example.TicketReservationSystemAPI.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getById(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
