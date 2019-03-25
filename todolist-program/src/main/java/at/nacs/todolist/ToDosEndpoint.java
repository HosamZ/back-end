package at.nacs.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDosEndpoint {
    private final ToDoManager manager;

    @GetMapping
    List<ToDo> get() {
        manager.getAll();
    }

    @GetMapping("/{id}")
    ToDo get(@PathVariable String id) {
        return manager.findById(id);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return manager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo done(@PathVariable String id) {
        return manager.done(id);
        // find by id
        // if you find nothing, return
        // get todo from optional
        // update the done value
        // save the todo in the database
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        manager.delete(id);
    }
}