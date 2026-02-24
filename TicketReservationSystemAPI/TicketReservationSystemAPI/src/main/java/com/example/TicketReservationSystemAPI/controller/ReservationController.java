package com.example.TicketReservationSystemAPI.controller;

import com.example.TicketReservationSystemAPI.model.Reservation;
import com.example.TicketReservationSystemAPI.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.getReservation(id).orElseThrow();
    }

    @PostMapping("/event/{eventId}")
    public Reservation create(@PathVariable Long eventId, @RequestBody Map<String, Object> body) {
        String name = body.get("customerName").toString();
        int seats = Integer.parseInt(body.get("seats").toString());
        return reservationService.createReservation(eventId, name, seats);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        reservationService.cancelReservation(id);
    }

    @GetMapping("/event/{eventId}")
    public List<Reservation> byEvent(@PathVariable Long eventId) {
        return reservationService.getReservationsByEvent(eventId);
    }
}
