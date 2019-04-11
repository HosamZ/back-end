package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceEndpoint {

  private final InvoiceManager invoiceManager;

  @GetMapping("/invoices")
  List<Invoice> findAll() {
    return invoiceManager.findAllInvoices();
  }

  @PutMapping("/invoices/{id}/paid")
  void updateInvoice(@RequestBody Long id) {
    invoiceManager.updateInvoice(id);
  }
}