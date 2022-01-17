package com.mycompany.invoise.service.prefix;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServicePrefix implements InvoiceServiceInterface {

    @Value("${invoice.lastNumber}")
    private  long lastNumber ;
    @Value("${invoice.prefix}")
    private String prefix ;

    @Autowired
    private InvoiceRepositoryInterface invoiceRepositoryInterface;

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }


    //Generate
    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public void  createInvoice(Invoice invoice){

       invoice.setNumber(String.valueOf(prefix+(++lastNumber)));
       invoiceRepositoryInterface.create(invoice);
    }
}
