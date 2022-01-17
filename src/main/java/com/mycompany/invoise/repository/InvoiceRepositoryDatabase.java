package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements  InvoiceRepositoryInterface{

    public void create(Invoice invoice){
        System.out.println("Database : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());

    }
}
