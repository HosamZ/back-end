package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoicesEndpoint {

  private final InvoiceManager invoiceManager;

  @GetMapping
  List<Invoice> findAll() {
    return invoiceManager.findAllInvoices();
  }

  @PutMapping("/{id}/paid")
  void paid(@PathVariable Long id) {
    invoiceManager.markAsPaid(id);
  }
}