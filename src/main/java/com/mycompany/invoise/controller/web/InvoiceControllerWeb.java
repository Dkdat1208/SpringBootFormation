package com.mycompany.invoise.controller.web;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface invoiceServiceInterface ;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    public void createInvoice(){

        String customerName =  "Tesla";
        Invoice invoice =  new Invoice();
        invoice.setCustomerName(customerName);

        invoiceServiceInterface.createInvoice(invoice);

    }

    @RequestMapping("/invoice-home")
    public  @ModelAttribute("invoices") List<Invoice> displayHome(){

        System.out.println("la methode display Home a été invoquée");
        List<Invoice> invoices =  invoiceServiceInterface.getInvoiceList();
        return invoices;
    }
}
