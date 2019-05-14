package at.nacs.thecodiattissecretorder.logic;

import at.nacs.thecodiattissecretorder.domain.model.User;
import at.nacs.thecodiattissecretorder.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager {
  private final UserRepository repository;


  public List<User> findAll() {
    return repository.findAll();
  }

  public void save(User user) {
    repository.save(user);
  }
}
