package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Service
@ConfigurationProperties("doctor")
public class DrHouse {

  private final RestTemplate restTemplate;

  @Setter
  private Map<String, String> report;

  @Setter
  private Map<String, String> sections;

  @Value("${pharmacy.url}")
  private String pharmacyurl;

  @Value("${beds.url}")
  private String bedsurl;

  public void sendTo(Patient patient) {
    String diagnosis = report.get(patient.getSymptoms());
    patient.setDiagnosis(diagnosis);
    String result = sections.getOrDefault(diagnosis, "pharmacy-section");
    if (result.equals("pharmacy-section")) {
      restTemplate.postForObject(pharmacyurl, patient, Patient.class);
    } else {
      restTemplate.postForObject(bedsurl, patient, Patient.class);
    }
  }

  public void observe(Patient patient) {
    patient.setDiagnosis("lupus");
  }
}
