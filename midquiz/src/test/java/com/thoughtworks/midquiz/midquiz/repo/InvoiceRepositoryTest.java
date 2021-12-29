package com.thoughtworks.midquiz.midquiz.repo;

import com.thoughtworks.midquiz.midquiz.entity.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_INVOICE_ININT_DATA.sql"})
    public void should_return_list_given_btc_id() {
        Long btcId = 1L;
        List<Invoice> invoicesList = invoiceRepository.findAllByBtcId(btcId);

        assertEquals(invoicesList.size(), 3L);
    }

    @Test
    public void should_return_empty_list_given_btc_id() {
        Long btcId = 1L;
        List<Invoice> invoicesList = invoiceRepository.findAllByBtcId(btcId);

        assertEquals(invoicesList.size(), 0L);
    }

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_INVOICE_ININT_DATA.sql"})
    public void should_return_invoice_given_btc_id_exist() {
        Long id = 1L;
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        assertEquals(invoice.get().getBtcId(), 1L);
    }

    @Test
    public void should_return_null_given_btc_id_exist() {
        Long id = 1L;
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        assertEquals(invoice.isPresent(), false);
    }
}