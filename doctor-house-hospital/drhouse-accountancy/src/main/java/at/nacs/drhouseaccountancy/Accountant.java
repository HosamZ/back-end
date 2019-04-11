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
  // private final Map<String, String> costs;


  public void post(PatientDTO patientDTO) {
    Patient patient = converter.convert(patientDTO);
    patientManager.savePatient(patient);
    // patientManager.calculateCosts();
    //patientManager.createInvoice(patientDTO, patient);
    invoiceManager.createInvoice(patientDTO, patient);

  }

  public void makeInvoice(PatientDTO patientDTO) {
    //  invoiceManager.createInvoice(patientDTO);
  }
//
//  public void updateOneInvoice(Long id) {
//    invoiceManager.update(id);
//  }

//  public void saveOnePatient() {
//    patientManager.save();
//
//  }
//
//  public List<Invoice> findInvoices() {
//    return invoiceManager.findAll();
//  }
//
//  public void savePatient() {
//
//
//  }

  public void makeCalculation(String entry) {


  }


}
