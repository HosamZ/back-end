package at.nacs.todolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoManager manager;

    ToDo toDo = ToDo.builder().title("test Todo").build();

    @BeforeEach
    void before() {
        toDoRepository.deleteAll();
    }

    @Test
    void save() {
        ToDo savedTodo = manager.save(toDo);

        assertThat(savedTodo).isNotNull();
        assertThat(savedTodo.getId()).isNotEmpty();
        assertThat(savedTodo.getTitle()).isEqualTo("test Todo");
        assertThat(savedTodo.isDone()).isFalse();
    }
}