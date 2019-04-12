package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientManager {

  private final PatientRepository patientRepository;

  public void savePatient(Patient patient) {
    patientRepository.save(patient);
  }

//  public void save() {
////    accountant.savePatient();
//  }
}