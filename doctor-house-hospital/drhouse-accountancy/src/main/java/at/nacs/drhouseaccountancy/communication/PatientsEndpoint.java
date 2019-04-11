package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.Accountant;
import at.nacs.drhouseaccountancy.logic.PatientManager;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsEndpoint {

  private final PatientManager patientManager;
  private final Accountant accountant;

  @PostMapping
  void post(@RequestBody PatientDTO patientDTO) {
    accountant.takeCareOfPatient(patientDTO);

  }
}