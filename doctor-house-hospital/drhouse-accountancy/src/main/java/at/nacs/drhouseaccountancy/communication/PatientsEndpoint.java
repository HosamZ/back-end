package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.PatientManager;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsEndpoint {

    private final PatientDTO patientDTO;
    private final Invoice invoice;
    private final PatientManager patientManager;

    @PostMapping
    void post() {
        patientManager.savePatient();
        patientManager.calculateCosts();
        patientManager.createInvoice(patientDTO);

//        invoice.
//        if (patient==null){
//            repository.save(patient);
//                    //need review not right
//        }
//        repository.save(patient);
    }

    @GetMapping("/invoices")
    List<Invoice> findAll() {
        List<Invoice> allInvoices = patientManager.findAllInvoices();
        return allInvoices;
    }

    @PutMapping("/invoices/{id}/paid")
    void updateInvoice(@RequestBody Long id) {
        patientManager.updateInvoice(invoice);
        invoice.setId(id);
        invoice.setPaid(true);
    }

}