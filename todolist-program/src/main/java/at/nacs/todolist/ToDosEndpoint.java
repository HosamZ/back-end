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
    List<ToDo> find() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    ToDo findById(@PathVariable String id) {
        return manager.findById(id);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return manager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo done(@PathVariable String id) {
        return manager.done(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        manager.delete(id);
    }
}


// find by id
// if you find nothing, return
// findById todo from optional
// update the done value
// save the todo in the database