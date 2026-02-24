package com.example.TicketReservationSystemAPI.repository;

import com.example.TicketReservationSystemAPI.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByEventId(Long eventId);
}
