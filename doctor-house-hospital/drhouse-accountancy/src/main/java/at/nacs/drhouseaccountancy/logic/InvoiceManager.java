package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.configuration.PricesConfiguration;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.domain.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
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


  public Invoice createInvoice(PatientDTO patientDTO, Patient patient) {
    // TODO replace with builder
    Invoice invoice = new Invoice();
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
    return invoice;
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

  public void markAsPaid(Long id) {
    Optional<Invoice> byId = invoiceRepository.findById(id);
    // TODO Check if empty then return
    Invoice invoice = byId.get();
    invoice.setPaid(true);
    invoiceRepository.save(invoice);
  }

  public Double calculateCosts(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return pricesConfiguration.getPrices().get(patientDTO.getTreatment());
    }
    return pricesConfiguration.getPrices().get(patientDTO.getMedicine());
  }
}
