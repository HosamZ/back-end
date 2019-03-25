package at.nacs.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDosEndpoint {

    private final ToDoRepository toDoRepository;

    @GetMapping
    List<ToDo> get() {
        return toDoRepository.findAll();
    }

    @GetMapping("/{id}")
    ToDo get(@PathVariable String id) {
        return toDoRepository.findById(id).orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo done(@PathVariable String id) {
        Optional<ToDo> byId = toDoRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        byId.get().setDone(true);
        return toDoRepository.save(byId.get());

        // find by id
        // if you find nothing, return
        // get todo from optional
        // update the done value
        // save the todo in the database
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        toDoRepository.deleteById(id);
    }
}