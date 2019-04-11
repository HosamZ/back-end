package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PatientManager {

    private final Map<String, String> costs;
    private final PatientRepository repository;
    private final RestTemplate restTemplate;

    private final Patient patient;
    private ModelMapper modelMapper = new ModelMapper();
//    private PatientDTO patientdto = modelMapper.map(patient, PatientDTO.class);

    public void savePatient() {
        PatientDTO patientdto = modelMapper.map(patient, PatientDTO.class);
        restTemplate.postForEntity("/patients", patientdto, Patient.class);
        if (patientdto.getId() == null || patientdto.getId().isBlank()) {//not sure
            repository.save(patient);
        }
        repository.save(patient);
    }

    public void calculateCosts() {


    }

    public void createInvoice() {

    }

    public List<Invoice> findAllInvoices() {
        List<Invoice> allByInvoice = repository.findAllByInvoice();
        return allByInvoice;
    }

}
