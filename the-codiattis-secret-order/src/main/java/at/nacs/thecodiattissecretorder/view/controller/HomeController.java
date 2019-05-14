package at.nacs.thecodiattissecretorder.view.controller;

import at.nacs.thecodiattissecretorder.domain.model.User;
import at.nacs.thecodiattissecretorder.logic.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
  private final UserManager userManager;

  @ModelAttribute("users")
  List<User> users() {
    return userManager.findAll();
  }

  @GetMapping
  String page() {
    return "home";
  }

  @RolesAllowed("ROLE_ADMIN")
  @PostMapping
  String save(User user) {
    userManager.save(user);
    return "redirect:/";
  }
}