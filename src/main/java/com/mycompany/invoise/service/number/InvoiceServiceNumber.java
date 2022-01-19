package com.mycompany.invoise.service.number;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private static long lastNumber = 0L;
    private InvoiceRepositoryInterface invoiceRepositoryInterface ;

    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public void  createInvoice(Invoice invoice){

       invoice.setNumber(String.valueOf(++lastNumber));
       invoiceRepositoryInterface.create(invoice);
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepositoryInterface.list();
    }
}
