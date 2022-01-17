package com.mycompany.invoise.controller;

import com.mycompany.invoise.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {
    void createInvoice();
    void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface);
}
