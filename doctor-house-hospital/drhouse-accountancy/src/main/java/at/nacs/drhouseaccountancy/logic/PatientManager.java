package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.Accountant;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PatientManager {

  private final Accountant accountant;
  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;
  private final RestTemplate restTemplate;
  private final Patient patient;
  private final Map<String, String> costs;
  private final PatientRepository patientRepository;

  public void savePatient(Patient patient) {
    patientRepository.save(patient);
  }

  public void calculateCosts(String entry) {
//    accountant.makeCalculation(entry);
  }

  public void createInvoice(PatientDTO patientDTO, Patient patient) {
//    accountant.makeInvoice(patientDTO);
    modelMapper.map(patient, PatientDTO.class);
    restTemplate.postForEntity("/patients", patientdto, Patient.class);
    if (patientdto.getId() == null || patientdto.getId().isBlank()) {//not sure
      repository.save(this.patient);
    }
    repository.save(this.patient);

  }

  public List<Invoice> findAllInvoices() {
//    return accountant.findInvoices();
  }

  public void updateInvoice(Long id) {
//    accountant.updateOneInvoice(id);
  }

  public void save() {
//    accountant.savePatient();
  }
}