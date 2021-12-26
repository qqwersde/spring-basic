package com.thoughtworks.midquiz.midquiz.repo;

import com.thoughtworks.midquiz.midquiz.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByBtcId(Long btcId);
}
