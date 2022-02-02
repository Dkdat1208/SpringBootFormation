package com.mycompany.invoise.core.service.number;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.CustomerRepositoryInterface;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    @Autowired
    private InvoiceRepositoryInterface invoiceRepositoryInterface ;

    @Autowired
    private CustomerRepositoryInterface  customerRepositoryInterface ;

    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepositoryInterface.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepositoryInterface.findById(number).orElseThrow();
    }
    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public Invoice  createInvoice(Invoice invoice){
        customerRepositoryInterface.save(invoice.getCustomer());
        return invoiceRepositoryInterface.save(invoice);
    }

}
