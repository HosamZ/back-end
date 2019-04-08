package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class Admission {

    private final RestTemplate restTemplate;

    @Value("${hospital.url}")
    private String url;

    public void assignId(Patient patient) {
        patient.setId(randomUUID().toString());
        restTemplate.postForObject(url, patient, Patient.class);
    }
}