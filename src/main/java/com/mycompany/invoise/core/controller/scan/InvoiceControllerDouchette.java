package com.mycompany.invoise.core.controller.scan;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

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
    public String  createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");
         invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceServiceInterface.createInvoice(invoice);
        return  null ;
    }
}
