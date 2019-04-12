package at.nacs.drhouseaccountancy;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.logic.PatientManager;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final PatientConverter converter;
  private final InvoiceManager invoiceManager;


  public void post(PatientDTO patientDTO) {
    Patient patient = converter.convert(patientDTO);
    patientManager.savePatient(patient);
    invoiceManager.createInvoice(patientDTO, patient);

  }
}
