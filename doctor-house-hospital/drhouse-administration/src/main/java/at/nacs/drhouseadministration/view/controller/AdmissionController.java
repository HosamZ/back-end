package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.communiction.InvoiceClient;
import at.nacs.drhouseadministration.communiction.PatientClient;
import at.nacs.drhouseadministration.view.model.Invoice;
import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AdmissionController {

  private final PatientClient patientClient;
  private final InvoiceClient invoiceClient;

  @ModelAttribute("invoices")
  List<Invoice> find() {
    return invoiceClient.findAll();
  }

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @GetMapping
  String page() {
    return "patients";
  }

  @GetMapping
  String invoicePage() {return "invoices";}

  @PostMapping("/patients")
  String post(@Valid Patient patient, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    patientClient.save(patient);
    return "redirect:/";
  }

  @PostMapping("/invoices")
  String post(@Valid Invoice invoice, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    invoiceClient.save(invoice);
    return "redirect:/";
  }
}