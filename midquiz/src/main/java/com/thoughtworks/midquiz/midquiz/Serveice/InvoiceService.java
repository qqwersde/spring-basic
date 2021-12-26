package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.Model.Invoice;
import com.thoughtworks.midquiz.midquiz.exception.BaseException;
import com.thoughtworks.midquiz.midquiz.repo.ContractRepository;
import com.thoughtworks.midquiz.midquiz.repo.InvoiceRepository;
import com.thoughtworks.midquiz.midquiz.repo.PaymentRepository;
import com.thoughtworks.midquiz.midquiz.response.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final ContractRepository contractRepository;

    private final InvoiceRepository invoiceRepository;

    private final PaymentRepository paymentRepository;

    public List<Invoice> getInvoiceList(Long btcId) {
        validContract(btcId);
        return invoiceRepository.findAllByBtcId(btcId);
    }

    public InvoiceResponse getInvoice(Long btcId, Long iId) {
        validContract(btcId);
        Optional<Invoice> invoice = invoiceRepository.findById(iId);
        return invoice.map(item -> {
            InvoiceResponse build = InvoiceResponse.builder().id(item.getId())
                    .paymentId(item.getPaymentId())
                    .createTime(item.getCreateTime()).build();
            return build;
        }).orElseThrow(() -> new BaseException("no invoice", HttpStatus.BAD_REQUEST));
    }

    private void validContract(Long btcId) {
        boolean exists = contractRepository.existsById(btcId);
        if (!exists) {
            throw new BaseException("no contract", HttpStatus.BAD_REQUEST);
        }
    }

}
