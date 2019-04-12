package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.PricesConfiguration;
import at.nacs.drhouseaccountancy.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;
  //  private Map<String, Double> prices;
  private final PricesConfiguration pricesConfiguration;
  private Invoice invoice;

  public void createInvoice(PatientDTO patientDTO, Patient patient) {
    invoice = new Invoice();
    invoice.setDiagnosis(patientDTO.getDiagnosis());
    invoice.setSymptoms(patientDTO.getSymptoms());
    String medicineOrTreatment = getMedicineOrTreatment(patientDTO);
    invoice.setProvided(medicineOrTreatment);
    invoice.setPaid(false);
    invoice.setTimestamp(LocalDateTime.now());
    invoice.setCost(calculateCosts(patientDTO));
    invoice.setKind(isMedicineOrTreatment(patientDTO));
    invoice.setPatient(patient);
    invoiceRepository.save(invoice);

  }

  private String getMedicineOrTreatment(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return patientDTO.getTreatment();
    }
    return patientDTO.getMedicine();
  }

  private Kind isMedicineOrTreatment(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return Kind.TREATMENT;
    }
    return Kind.MEDICINE;
  }

//  public List<Invoice> findAll() {
//    List<Invoice> allByInvoice = invoiceRepository.findAll();
//    return allByInvoice;
//
//  }

  public List<Invoice> findAllInvoices() {
    return invoiceRepository.findAll();
  }

  public void updateInvoice(Long id) {
    Optional<Invoice> byId = invoiceRepository.findById(id);
    byId.get().setPaid(true);
    invoiceRepository.save(invoice);
  }

  public Double calculateCosts(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return pricesConfiguration.getPrices().get(patientDTO.getTreatment());
    }
    return pricesConfiguration.getPrices().get(patientDTO.getMedicine());
//    accountant.makeCalculation(entry);

  }
}
