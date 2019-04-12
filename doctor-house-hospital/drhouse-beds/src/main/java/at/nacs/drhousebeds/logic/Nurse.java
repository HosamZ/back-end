package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import at.nacs.drhousebeds.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Nurse {

  private final PatientRepository repository;
  private final RestTemplate restTemplate;

  private final Map<String, String> treatment;


  public Patient treat(Patient patient) {
    String proceduresAdministered = treatment.get(patient.getDiagnosis());
    patient.setTreatment(proceduresAdministered);
    repository.save(patient);
    return patient;
  }

//  public void sendToAccountancy(Patient patient) {
//    restTemplate.postForEntity("http://localhost/9005/patients", patient, Patient.class);
//  }

//    public Patient post(Patient patient) {
//        return restTemplate.postForObject("http://localhost:9005/accountant", patient, Patient.class);
//    }
}