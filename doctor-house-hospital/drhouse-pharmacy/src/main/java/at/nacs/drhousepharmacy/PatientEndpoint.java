package at.nacs.drhousepharmacy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientEndpoint {

  private final Apothecary apothecary;
  private final RestTemplate restTemplate;

  @PostMapping
  Patient post(@RequestBody Patient patient) {
    apothecary.meditate(patient);
    restTemplate.postForObject("http://localhost:9005/patients", patient, Patient.class);
    return patient;
  }
}