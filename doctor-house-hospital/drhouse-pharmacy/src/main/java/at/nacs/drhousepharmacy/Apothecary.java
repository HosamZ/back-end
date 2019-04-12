package at.nacs.drhousepharmacy;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("pharmacy")
public class Apothecary {
  private final PatientRepository repository;
  @Setter
  private Map<String, String> meditation;

  public Patient meditate(Patient patient) {
    String sicknessResult = meditation.getOrDefault(patient.getDiagnosis(), "painkiller");
    patient.setMedicine(sicknessResult);
    repository.save(patient);
    return patient;
  }

}