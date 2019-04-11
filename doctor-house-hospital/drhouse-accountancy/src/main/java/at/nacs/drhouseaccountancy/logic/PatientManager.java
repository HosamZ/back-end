package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.Accountant;
import at.nacs.drhouseaccountancy.persistence.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientManager {

  private final Map<String, String> costs;
  private final PatientRepository repository;
  private final RestTemplate restTemplate;
  private final Accountant accountant;

  private final Patient patient;
  private ModelMapper modelMapper = new ModelMapper();
  private Invoice invoice;

  public void savePatient() {
    PatientDTO patientdto = modelMapper.map(patient, PatientDTO.class);
    restTemplate.postForEntity("/patients", patientdto, Patient.class);
    if (patientdto.getId() == null || patientdto.getId().isBlank()) {//not sure
      repository.save(patient);
    }
    repository.save(patient);
  }

  public void calculateCosts() {


  }

  public void createInvoice(PatientDTO patientDTO) {
    accountant.makeInvoice(patientDTO);
    invoice = new Invoice();
    invoice.setDiagnosis(patientDTO.getDiagnosis());
    invoice.setSymptoms(patientDTO.getSymptoms());
    String medicineOrTreatment = getMedicineOrTreatment(patientDTO);
    invoice.setProvided(medicineOrTreatment);
    invoice.setPaid(false);
    isMedicineOrTreatment(patientDTO, invoice, medicineOrTreatment);
    invoiceRepository.save(invoice);
  }

  private void isMedicineOrTreatment(PatientDTO patientDTO, Invoice invoice, String medicineOrTreatment) {
    Kind medicine = Kind.MEDICINE;
    Kind treatment = Kind.TREATMENT;
    if (medicineOrTreatment.equals(patientDTO.getMedicine())) {
      invoice.setKind(medicine);
    }
    invoice.setKind(treatment);
  }

  private String getMedicineOrTreatment(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return patientDTO.getTreatment();
    }
    return patientDTO.getMedicine();
  }

  public List<Invoice> findAllInvoices() {
    List<Invoice> allByInvoice = repository.findAllByInvoice();
    return allByInvoice;
  }

  public void updateInvoice(Long id) {
    Optional<Invoice> byId = invoiceRepository.findById(id);
    byId.get().setPaid(true);
    invoiceRepository.save(invoice);
  }
}