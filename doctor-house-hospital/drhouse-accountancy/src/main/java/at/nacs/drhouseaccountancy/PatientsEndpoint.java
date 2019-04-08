package at.nacs.drhouseaccountancy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsEndpoint {

    private final PatientDTO patientDTO;
    private final PatientRepository repository;
    private final RestTemplate restTemplate;
    private final Invoice invoice;
    private final Patient patient;

    @PostMapping
    void post() {
        restTemplate.postForEntity("/patients", patientDTO, Patient.class);
        if (patient.getId()==null){
            UUID uuid = UUID.randomUUID();
            patientDTO.setId(uuid.toString());
            repository.save(patient);
        }
        repository.save(patient);

//        invoice.
//        if (patient==null){
//            repository.save(patient);
//                    //need review not right
//        }
//        repository.save(patient);
        Invoice invoice = new Invoice();
        invoice.setCost();
        invoice.setDiagnosis();
        invoice.setId();
        invoice.setKind();
        invoice.setProvided();

    }

    @GetMapping
    List<Patient> findAll(){
        List<Patient> allPatient = repository.findAll();

//        return allInvoices;
        return allPatient;
    }
}
