package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceManager {
  private final InvoiceRepository invoiceRepository;


}
