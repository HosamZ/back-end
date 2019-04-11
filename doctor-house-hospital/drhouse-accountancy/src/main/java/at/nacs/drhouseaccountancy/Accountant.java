package at.nacs.drhouseaccountancy;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.logic.PatientManager;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;

  public void makeInvoice(PatientDTO patientDTO) {
    
  }
}
