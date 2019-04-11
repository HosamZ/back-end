package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.Accountant;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper = new ModelMapper();
//    accountant.makeInvoice(patientDTO);
    modelMapper.map(patient, PatientDTO.class);
    restTemplate.postForEntity("/patients", patientDTO, Patient.class);
    if (patientDTO.getId() == null || patientDTO.getId().isBlank()) {//not sure
      patientRepository.save(patient);
    }
    patientRepository.save(patient);
  }

  public List<Invoice> findAllInvoices() {
    return accountant.findInvoices();
  }

  public void updateInvoice(Long id) {
//    accountant.updateOneInvoice(id);
  }

  public void save() {
//    accountant.savePatient();
  }
}