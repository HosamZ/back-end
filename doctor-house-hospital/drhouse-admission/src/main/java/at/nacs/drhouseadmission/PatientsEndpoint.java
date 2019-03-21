package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static java.lang.String.valueOf;
import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final RestTemplate restTemplate;

    @Value("${hospital.url}")
    private String url;

    @PostMapping
    Patient addmission(@RequestBody Patient patient) {
        patient.setId(randomUUID().toString());
        restTemplate.postForObject(url, patient, Patient.class);
        return patient;
    }
}