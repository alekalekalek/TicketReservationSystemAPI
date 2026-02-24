package com.example.TicketReservationSystemAPI.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private LocalDateTime dateTime;
    private int totalSeats;
    private int availableSeats;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Event() {}

    public Event(Long id, String name, String location, LocalDateTime dateTime, int totalSeats, int availableSeats, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}