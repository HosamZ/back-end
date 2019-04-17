package at.nacs.drhouseadministration.communiction;

import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvoiceClient {
  private final RestTemplate restTemplate;

  @Value("${admission.server.url}")
  private String url;

  public List<Invoice> findAll() {
    Invoice[] invoices = restTemplate.getForObject(url, Invoice[].class);
    return new ArrayList<>(Arrays.asList(invoices));
  }

  public void save(Invoice invoice) {
    restTemplate.getForObject(url, Invoice.class);
  }
}
