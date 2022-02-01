package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceServiceInterface ;
    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }
    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }
@PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return  invoiceServiceInterface.createInvoice(invoice);
    }

    @GetMapping
    public Iterable<Invoice> list(Model model){
        System.out.println("la methode display Home a été invoquée");
        return  invoiceServiceInterface.getInvoiceList();
    }

//    public  ModelAndView  displayHome(){
//        System.out.println("la methode display Home a été invoquée");
//        ModelAndView modelAndView  = new ModelAndView("invoice-home");
//        modelAndView.addObject("invoices", invoiceServiceInterface.getInvoiceList());
//        return modelAndView;
//    }

    @GetMapping("/{id}")
    public  Invoice  get(@PathVariable("id") String number){
        System.out.println("la methode displayInvoice  a été invoquée");
        return  invoiceServiceInterface.getInvoiceByNumber(number);
    }

    /*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute  InvoiceForm invoice){
        return "invoice-create-form";
    }*/
}
