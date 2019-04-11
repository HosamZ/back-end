package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.Accountant;
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

  private final Invoice invoice;
  private final PatientManager patientManager;
  private final Accountant accountant;

  @PostMapping
  void post(@RequestBody PatientDTO patientDTO) {
    accountant.takeCareOfPatient(patientDTO);

  }

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