package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.persistence.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceEndpoint {

  private final Invoice invoice;

  @GetMapping("/invoices")
  List<Invoice> findAll() {
    return patientManager.findAllInvoices();
  }

  @PutMapping("/invoices/{id}/paid")
  void updateInvoice(@RequestBody Long id) {
    patientManager.updateInvoice(id);
    invoice.setId(id);
    invoice.setPaid(true);
  }

}
