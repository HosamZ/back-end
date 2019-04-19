package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.communiction.PatientClient;
import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PatientController {

  private final PatientClient patientClient;

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @GetMapping
  String page() {
    return "patients";
  }

  @PostMapping
  String post(@Valid Patient patient, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    patientClient.save(patient);
    return "redirect:/";
  }
}