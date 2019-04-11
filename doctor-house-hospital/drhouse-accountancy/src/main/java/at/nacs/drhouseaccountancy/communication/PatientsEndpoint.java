package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.PatientManager;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsEndpoint {

  private final PatientDTO patientDTO;
  private final Invoice invoice;
  private final PatientManager patientManager;

  @PostMapping
  void post() {
    patientManager.savePatient();
    patientManager.calculateCosts();
    patientManager.createInvoice(patientDTO);
  }

  @GetMapping("/invoices")
  List<Invoice> findAll() {
    List<Invoice> allInvoices = patientManager.findAllInvoices();
    return allInvoices;
  }

  @PutMapping("/invoices/{id}/paid")
  void updateInvoice(@RequestBody Long id) {
    patientManager.updateInvoice(id);
    invoice.setId(id);
    invoice.setPaid(true);
  }

}