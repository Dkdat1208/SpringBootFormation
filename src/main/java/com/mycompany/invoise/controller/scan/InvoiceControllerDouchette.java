package com.mycompany.invoise.controller.scan;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }


    @Override
    public void createInvoice() {
        System.out.println("Usage of a scanner");
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceServiceInterface.createInvoice(invoice);
    }
}
