package com.mycompany.invoise.core.entity.repository.database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.entity.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Invoice invoice){
        System.out.println("Database : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());

    }

    @Override
    public List<Invoice> list() {
     return  jdbcTemplate.query("SELECT  INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
             (rs, rowNum) -> new Invoice(String.valueOf( rs .getLong("INVOICE_NUMBER")) ,rs.getString("CUSTOMER_NAME")));
    }
    @Override
    public Invoice getById(String number) {
        Invoice invoiceEdf =  new Invoice();
        invoiceEdf.setNumber(number);
        invoiceEdf.setCustomerName("EDF");
        invoiceEdf.setOrderNumber("ON_002");
        return  invoiceEdf ;
    }
}
