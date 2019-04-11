package at.nacs.drhouseaccountancy;

import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class PatientConverter {
  public Patient convert(PatientDTO patientDTO) {
    return Patient.builder()
                  .name(patientDTO.getName())
                  .uuid(patientDTO.getId())
                  .build();

  }
}