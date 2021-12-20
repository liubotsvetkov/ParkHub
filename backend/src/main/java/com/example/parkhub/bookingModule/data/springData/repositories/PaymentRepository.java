package com.example.parkhub.bookingModule.data.springData.repositories;

import com.example.parkhub.bookingModule.data.springData.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
