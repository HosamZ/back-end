package at.nacs.todolist;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public ToDo findById(String id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo done(String id) {
        Optional<ToDo> byId = toDoRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        byId.get().setDone(true);
        return toDoRepository.save(byId.get());
    }

    public void delete(String id) {
        toDoRepository.deleteById(id);
    }
}
