package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.entity.Invoice;
import com.thoughtworks.midquiz.midquiz.exception.BaseException;
import com.thoughtworks.midquiz.midquiz.repo.ContractRepository;
import com.thoughtworks.midquiz.midquiz.repo.InvoiceRepository;
import com.thoughtworks.midquiz.midquiz.response.InvoiceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class InvoiceServiceTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private ContractRepository contractRepository;

    @InjectMocks
    private InvoiceService invoiceService;


    @Test
    public void should_return_invoice_list_when_finish_payment_given_btc_id_is_existed() {
        //given
        Long btcId = 1L;
        Invoice pending = Invoice.builder().id(1L).paymentId(1L).btcId(btcId).status("PENDING").build();
        Invoice failed = Invoice.builder().id(2L).paymentId(2L).btcId(btcId).status("FAILED").build();
        Invoice success = Invoice.builder().id(3L).paymentId(3L).btcId(btcId).status("SUCCESS").build();
        List<Invoice> invoices = Arrays.asList(pending, failed, success);

        //when
        when(contractRepository.existsById(btcId)).thenReturn(true);
        when(invoiceRepository.findAllByBtcId(btcId)).thenReturn(invoices);
        List<Invoice> invoiceList = invoiceService.getInvoiceList(btcId);

        //then
        assertEquals(invoiceList.size(), 3L);

    }

    @Test
    public void should_return__empty_invoice_list_when_no_payment_given_btc_id_is_existed() {
        //given
        Long btcId = 1L;

        //when
        when(contractRepository.existsById(btcId)).thenReturn(true);
        when(invoiceRepository.findAllByBtcId(btcId)).thenReturn(Collections.emptyList());
        List<Invoice> invoiceList = invoiceService.getInvoiceList(btcId);

        //then
        assertEquals(invoiceList.size(), 0L);

    }

    @Test()
    public void should_throw_exception_given_btc_id_is_not_existed() {
        //given
        Long btcId = 1L;
        Invoice pending = Invoice.builder().id(1L).paymentId(1L).btcId(btcId).status("PENDING").build();
        Invoice failed = Invoice.builder().id(2L).paymentId(2L).btcId(btcId).status("FAILED").build();
        Invoice success = Invoice.builder().id(3L).paymentId(3L).btcId(btcId).status("SUCCESS").build();
        List<Invoice> invoices = Arrays.asList(pending, failed, success);

        //when
        when(contractRepository.existsById(btcId)).thenReturn(false);
        when(invoiceRepository.findAllByBtcId(btcId)).thenReturn(invoices);

        Throwable exception = assertThrows(BaseException.class,
                () -> {
                    invoiceService.getInvoiceList(btcId);
                });
        assertEquals(exception.getMessage(), "no contract");
    }

    @Test()
    public void should_check_invoice_detail_given_btc_id_and_invoice_id_exists() {
        //given
        Long btcId = 1L;
        Long iId = 1L;
        Invoice pending = Invoice.builder().id(1L).paymentId(1L).btcId(btcId)
                .status("PENDING").createTime(LocalDateTime.now()).build();


        //when
        when(contractRepository.existsById(btcId)).thenReturn(true);
        when(invoiceRepository.findById(btcId)).thenReturn(Optional.of(pending));

        InvoiceResponse response = invoiceService.getInvoice(btcId, iId);
        //
        assertEquals(response.getCreateTime(), pending.getCreateTime());
    }

    @Test()
    public void should_throw_exception_given_btc_id_exist_invoice_id_no_exist() {
        //given
        Long btcId = 1L;
        Long iId = 1L;

        //when
        when(contractRepository.existsById(btcId)).thenReturn(true);
        when(invoiceRepository.findById(btcId)).thenReturn(Optional.empty());

        Throwable exception = assertThrows(BaseException.class,
                () -> {
                    invoiceService.getInvoice(btcId, iId);
                });

        assertEquals(exception.getMessage(), "no invoice");
    }


}