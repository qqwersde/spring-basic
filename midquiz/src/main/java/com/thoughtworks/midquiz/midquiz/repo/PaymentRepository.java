package com.thoughtworks.midquiz.midquiz.repo;

import com.thoughtworks.midquiz.midquiz.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
