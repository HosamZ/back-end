package at.nacs.thecodiattissecretorder.initialise;

import at.nacs.thecodiattissecretorder.domain.model.User;
import at.nacs.thecodiattissecretorder.domain.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitialiser {

  @Bean
  ApplicationRunner initializeUser(PasswordEncoder encoder, UserRepository repository) {
    return args -> {
      User user = createUser(encoder);
      if (repository.existsByUsername(user.getUsername())) {
        return;
      }
      repository.save(user);
    };
  }

  private User createUser(PasswordEncoder encoder) {
    return User.builder()
               .username("chief")
               .password(encoder.encode("chief"))
               .authorities(Set.of("ROLE_ADMIN", "ROLE_USER"))
               .build();
  }
}

//@Configuration
//public class UserInitialiser {
//
//  @Bean
//  ApplicationRunner initialiseUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//    return args -> {
//      User user = new User();
//      user.setUsername("admin");
//      user.setPassword(passwordEncoder.encode("admin"));
//      user.getAuthorities().add("ADMIN");
//      user.setAdmin(true);
//     // userRepository.save(user);
//    };
//  }
//}
//

