package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.Kind;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;
  private Invoice invoice;
  private final Map<String, Double> costs;

  public void createInvoice(PatientDTO patientDTO) {
    invoice = new Invoice();
    invoice.setDiagnosis(patientDTO.getDiagnosis());
    invoice.setSymptoms(patientDTO.getSymptoms());
    String medicineOrTreatment = getMedicineOrTreatment(patientDTO);
    invoice.setProvided(medicineOrTreatment);
    invoice.setPaid(false);
    invoice.setCost(calculateCosts(patientDTO));
    invoice.setKind(isMedicineOrTreatment(patientDTO));
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
      return costs.get(patientDTO.getTreatment());
    }
    return costs.get(patientDTO.getMedicine());
//    accountant.makeCalculation(entry);

  }
}
