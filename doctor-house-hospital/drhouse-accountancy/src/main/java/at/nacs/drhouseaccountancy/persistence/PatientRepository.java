package at.nacs.drhouseaccountancy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  List<Invoice> findAllByInvoice();
}
