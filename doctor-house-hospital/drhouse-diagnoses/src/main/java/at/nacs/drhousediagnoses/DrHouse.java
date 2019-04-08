package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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

    public void sendTo(Patient patient) {
        String pharmacyurl = "http://localhost:9004/patients";
        String bedsurl = "http://localhost:9003/patients";
        String diagnosis = report.get(patient.getSymptoms());
        String result = sections.getOrDefault(diagnosis, "pharmacy-section");
        patient.setDiagnosis(diagnosis);
        if (result.equals("pharmacy-section")) {
            restTemplate.postForObject(pharmacyurl, patient, Patient.class);
        }
        restTemplate.postForObject(bedsurl, patient, Patient.class);
    }

    public void observe(Patient patient) {
        patient.setDiagnosis("lupus");
    }
}
