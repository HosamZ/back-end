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
    Map<String, String> report;
    public void sendTo(Patient patient) {
        String pharmacyurl = "http://localhost:9004";
        String bedsurl = "http://localhost:9003";
        String result = report.getOrDefault(patient.getSymptoms(), "pharmacy-section");
        patient.setSymptoms(result);
        if (result.equals("pharmacy-section")) {
            restTemplate.postForObject(pharmacyurl, patient, Patient.class);
        }
        restTemplate.postForObject(bedsurl, patient, Patient.class);
    }

    public void checkOn(Patient patient) {
        patient.setDiagnosis("lupus");
    }
}
