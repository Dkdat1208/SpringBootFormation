package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Customer;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb  {
    @Autowired
    private InvoiceServiceInterface invoiceServiceInterface ;
    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }
    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

@PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results){
       if(results.hasErrors()){
           return  "invoice-create-form";
       }

        Invoice invoice =  new Invoice();
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceServiceInterface.createInvoice(invoice);
        return "invoice-created" ;
    }

    @GetMapping("/home")
    public  String  displayHome(Model model){
        System.out.println("la methode display Home a été invoquée");
        model.addAttribute("invoices", invoiceServiceInterface.getInvoiceList());
        return "invoice-home";
    }

//    public  ModelAndView  displayHome(){
//        System.out.println("la methode display Home a été invoquée");
//        ModelAndView modelAndView  = new ModelAndView("invoice-home");
//        modelAndView.addObject("invoices", invoiceServiceInterface.getInvoiceList());
//        return modelAndView;
//    }

  /*  @GetMapping("/{id}")
    public String  displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("la methode displayInvoice  a été invoquée");
        model.addAttribute("invoice", invoiceServiceInterface.getInvoiceByNumber(number));
        return "invoice-details";
    }*/

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute  InvoiceForm invoice){
        return "invoice-create-form";
    }
}
