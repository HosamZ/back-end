package at.nacs.drhouseadministration.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
//    registry.addViewController("/").setViewName("home");
    registry.addViewController("/patients").setViewName("patients");
    registry.addViewController("/invoices").setViewName("invoices");
  }

}
