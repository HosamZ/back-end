package at.nacs.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {

  private final ToDoRepository toDoRepository;

  public List<ToDo> findAll() {
    return toDoRepository.findAll();
  }

  public ToDo findById(String id) {
    return toDoRepository.findById(id).orElse(null);
  }

  public ToDo save(ToDo toDo) {
    return toDoRepository.save(toDo);
  }

  public ToDo done(String id) {//void?
    Optional<ToDo> byId = toDoRepository.findById(id);
    if (byId.isEmpty()) {
      return null;
    }
    ToDo toDo = byId.get();
    toDo.setDone(true);
    return toDoRepository.save(toDo);
  }

  public void delete(String id) {
    toDoRepository.deleteById(id);
  }

}
