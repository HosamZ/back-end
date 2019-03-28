package at.nacs.drhousebeds;

import at.nacs.drhousebeds.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("treatment")
public class Nurse {

    private final PatientRepository repository;
    private final RestTemplate restTemplate;

    @Setter
    private Map<String, String> treatment;

    Patient treat(Patient patient) {
        String result = treatment.getOrDefault(patient.getDiagnosis(), "lupus");
        patient.setTreatment(result);
        repository.save(patient);
        return patient;
    }

    public Patient post(Patient patient) {
        return restTemplate.postForObject("http://localhost:9000/accountant", patient, Patient.class);
    }
}