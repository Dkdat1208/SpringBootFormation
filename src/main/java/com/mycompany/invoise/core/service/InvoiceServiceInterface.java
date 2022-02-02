package com.mycompany.invoise.core.service;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;

public interface InvoiceServiceInterface {

  Invoice  createInvoice(Invoice invoice);
  Iterable<Invoice> getInvoiceList();
  Invoice getInvoiceByNumber(String number);
  void setInvoiceRepositoryInterface(
          InvoiceRepositoryInterface invoiceRepositoryInterface);
}
