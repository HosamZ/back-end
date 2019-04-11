package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.Nurse;
import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

  private final Nurse nurse;

  @PostMapping
  Patient post(@RequestBody Patient patient) {
    return nurse.treat(patient);
  }

//    @PostMapping
//    void postToAccountancy(@RequestBody Patient patient) {
//        nurse.sendToAccountancy(patient);
//    }
}