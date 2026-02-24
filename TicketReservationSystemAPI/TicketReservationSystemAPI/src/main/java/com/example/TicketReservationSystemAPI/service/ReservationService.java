package com.example.TicketReservationSystemAPI.service;

import com.example.TicketReservationSystemAPI.model.enums.ReservationStatus;
import com.example.TicketReservationSystemAPI.model.Event;
import com.example.TicketReservationSystemAPI.model.Reservation;
import com.example.TicketReservationSystemAPI.repository.EventRepository;
import com.example.TicketReservationSystemAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Long eventId, String customerName, int seats) {
        Event event = eventRepository.findById(eventId).orElseThrow();

        if (event.getAvailableSeats() < seats) {
            throw new RuntimeException("Not enough seats available.");
        }

        event.setAvailableSeats(event.getAvailableSeats() - seats);
        eventRepository.save(event);

        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setSeatsReserved(seats);
        reservation.setEvent(event);
        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setStatus(ReservationStatus.PENDING.name());

        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        Reservation res = reservationRepository.findById(reservationId).orElseThrow();
        res.setStatus(ReservationStatus.CANCELLED.name());

        Event event = res.getEvent();
        event.setAvailableSeats(event.getAvailableSeats() + res.getSeatsReserved());
        eventRepository.save(event);

        reservationRepository.save(res);
    }

    public List<Reservation> getReservationsByEvent(Long eventId) {
        return reservationRepository.findByEventId(eventId);
    }
}
