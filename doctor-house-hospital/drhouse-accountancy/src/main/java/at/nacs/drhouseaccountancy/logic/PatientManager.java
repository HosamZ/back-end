package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@RequiredArgsConstructor
@Service
public class PatientManager {
    private final PatientRepository repository;
    private final RestTemplate restTemplate;

    private final Patient patient;
    private ModelMapper modelMapper = new ModelMapper();
//    private PatientDTO patientdto = modelMapper.map(patient, PatientDTO.class);

    public void savePatient() {
        PatientDTO patientdto = modelMapper.map(patient, PatientDTO.class);
        restTemplate.postForEntity("/patients", patientdto, Patient.class);
        if (patientdto.getId() == null||patientdto.getId().isBlank()) {//not sure
//            UUID uuid = UUID.randomUUID();
//            patientDTO.setId(uuid.toString());
            repository.save(patient);
        }
        repository.save(patient);
    }
}
