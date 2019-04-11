package at.nacs.drhouseaccountancy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
  Optional<Invoice> findById(Long id);

  List<Invoice> findAll();
}
