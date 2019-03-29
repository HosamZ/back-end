package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final DrHouse drHouse;
    @PostMapping
    Patient Diagnose(@RequestBody Patient patient) {
        drHouse.checkOn(patient);
        drHouse.sendTo(patient);
        return patient;
    }
}