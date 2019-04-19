package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.communiction.InvoiceClient;
import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

  private final InvoiceClient invoiceClient;

  @ModelAttribute("invoices")
  List<Invoice> find() {
    return invoiceClient.findAll();
  }

  @ModelAttribute("invoice")
  Invoice invoice() {
    return new Invoice();
  }

  @GetMapping
  String page() {
    return "invoices";
  }

  @PostMapping("/paid")
  String markAsDone(@RequestParam Long id) {
    invoiceClient.markAsPaid(id);
    return "redirect:/invoices";
  }
}
