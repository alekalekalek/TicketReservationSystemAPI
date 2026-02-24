package com.example.TicketReservationSystemAPI.repository;

import com.example.TicketReservationSystemAPI.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
