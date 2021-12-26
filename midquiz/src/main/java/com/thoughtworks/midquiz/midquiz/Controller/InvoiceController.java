package com.thoughtworks.midquiz.midquiz.Controller;


import com.thoughtworks.midquiz.midquiz.Model.Invoice;
import com.thoughtworks.midquiz.midquiz.Serveice.InvoiceService;
import com.thoughtworks.midquiz.midquiz.response.InvoiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {


    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("")
    public List<Invoice> getEducationByIdRestful(@RequestParam("btcId") Long btcId) {
        return invoiceService.getInvoiceList(btcId);
    }

    @GetMapping("/{iId}")
    public InvoiceResponse getInvoiceDetail(@RequestParam("btcId") Long btcId, @PathVariable Long iId) {
        return invoiceService.getInvoice(btcId, iId);
    }

}
