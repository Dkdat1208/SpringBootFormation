package com.mycompany.invoise.core.controller.keyboard;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyBoard implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    public String  createInvoice(Invoice invoice){

        System.out.println( "What is the customer name ?" );
        Scanner sc  = new Scanner(System.in);
        String customerName =  sc.nextLine();
         invoice =  new Invoice();
        invoice.setCustomerName(customerName);
        invoiceServiceInterface.createInvoice(invoice);

        return  null ;

    }
}
