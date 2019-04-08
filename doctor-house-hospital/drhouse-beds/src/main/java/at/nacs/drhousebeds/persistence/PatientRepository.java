package at.nacs.drhousebeds.persistence;

import at.nacs.drhousebeds.persistence.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}