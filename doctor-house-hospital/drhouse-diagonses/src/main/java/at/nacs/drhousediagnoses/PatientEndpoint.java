package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    @PostMapping
    Patient getPatient(@RequestBody Patient patient) {
        patient.setDiagnosis("Dota");
        return patient;
    }
}