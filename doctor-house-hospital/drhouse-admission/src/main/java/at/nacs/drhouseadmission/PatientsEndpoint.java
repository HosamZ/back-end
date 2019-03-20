package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final RestTemplate restTemplate;

//    String url= "http://localhost:9002/patients";

    @Value("${hospital.url}")
    private String url;

    @PostMapping
    Patient add(@RequestBody Patient patient) {
        patient.setId(valueOf(Math.random()));
        restTemplate.postForObject(url, patient, Patient.class);
        return patient;
    }
}