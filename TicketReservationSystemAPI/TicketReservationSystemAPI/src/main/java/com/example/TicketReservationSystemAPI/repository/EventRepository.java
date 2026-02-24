package com.example.TicketReservationSystemAPI.repository;

import com.example.TicketReservationSystemAPI.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
