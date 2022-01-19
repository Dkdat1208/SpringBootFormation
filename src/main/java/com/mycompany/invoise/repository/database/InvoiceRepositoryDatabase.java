package com.mycompany.invoise.repository.database;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    public void create(Invoice invoice){
        System.out.println("Database : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());

    }

    @Override
    public List<Invoice> list() {
        Invoice invoiceEdf =  new Invoice();
        invoiceEdf.setNumber("NUM_1");
        invoiceEdf.setCustomerName("EDF");

        Invoice invoiceSfr =  new Invoice();
        invoiceSfr.setNumber("NUM_2");
        invoiceSfr.setCustomerName("SFR");

        return List.of(invoiceEdf,invoiceSfr);
    }
}
