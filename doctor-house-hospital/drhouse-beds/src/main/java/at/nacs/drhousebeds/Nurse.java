package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
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

    Patient treat(Patient patient) {
        String proceduresAdministered = treatment.get(patient.getDiagnosis());
        patient.setTreatment(proceduresAdministered);
        repository.save(patient);
        return patient;
    }

//    public Patient post(Patient patient) {
//        return restTemplate.postForObject("http://localhost:9005/accountant", patient, Patient.class);
//    }
}