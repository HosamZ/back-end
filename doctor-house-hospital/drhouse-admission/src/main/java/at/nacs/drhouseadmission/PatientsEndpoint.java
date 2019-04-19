package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {
  private final Admission admission;

  @PostMapping
  Patient addmission(@RequestBody Patient patient) {
    admission.assignId(patient);
    return patient;
  }
}