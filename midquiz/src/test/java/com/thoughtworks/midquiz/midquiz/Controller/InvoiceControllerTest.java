package com.thoughtworks.midquiz.midquiz.Controller;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.midquiz.midquiz.entity.Invoice;
import com.thoughtworks.midquiz.midquiz.exception.BaseException;
import com.thoughtworks.midquiz.midquiz.response.InvoiceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//SpringBoot1.4版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest
@AutoConfigureMockMvc
class InvoiceControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_CONTRACT_ININT_DATA.sql", "classpath:sql/INSERT_TABLE_INVOICE_ININT_DATA.sql"})
    public void should_return_invoice_list_when_finish_payment_given_btcId() throws Exception {

        MvcResult result = mockMvc.perform(
                get("/invoices")
                        .param("btcId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        List<Invoice> invoices = JSON.parseArray(content, Invoice.class);
        assertEquals(invoices.size(), 3L);
    }

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_CONTRACT_ININT_DATA.sql"})
    public void should_return_empty_invoice_list_when_no_payment_given_btcId() throws Exception {

        MvcResult result = mockMvc.perform(
                get("/invoices")
                        .param("btcId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        List<Invoice> invoices = JSON.parseArray(content, Invoice.class);
        assertEquals(invoices.size(), 0L);
    }

    @Test
    public void should_throw_exception_given_not_exist_btcId() throws Exception {

        MvcResult result = mockMvc.perform(
                get("/invoices")
                        .param("btcId", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        BaseException baseException = JSON.parseObject(content, BaseException.class);
        assertEquals(baseException.getMessage(), "no contract");
    }

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_CONTRACT_ININT_DATA.sql", "classpath:sql/INSERT_TABLE_INVOICE_ININT_DATA.sql"})
    public void should_return_invoice_when_finish_payment_given_btcId_and_iId() throws Exception {

        MvcResult result = mockMvc.perform(
                get("/invoices/1")
                        .param("btcId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        InvoiceResponse invoiceResponse = JSON.parseObject(content, InvoiceResponse.class);
        assertEquals(invoiceResponse.getPaymentId(), 1L);
    }

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_CONTRACT_ININT_DATA.sql"})
    public void should_throw_exception_when_iId_is_not_exist() throws Exception {

        MvcResult result = mockMvc.perform(
                get("/invoices/1")
                        .param("btcId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        BaseException baseException = JSON.parseObject(content, BaseException.class);
        assertEquals(baseException.getMessage(), "no invoice");
    }


}