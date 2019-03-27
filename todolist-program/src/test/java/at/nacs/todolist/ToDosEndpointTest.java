package at.nacs.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {
    //endpoint don`t know about database

    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    String url = "/todos";

    @Test
    void correctCallTimes(){
    }

    @Test
    void find() {
        testRestTemplate.getForObject(url, ToDo[].class);

        verify(toDoManager).findAll();
    }

    @Test
    void findById() {
        ToDo[] toDo = testRestTemplate.getForObject(url, ToDo[].class);
        List<ToDo> all = toDoRepository.findAll();
//        System.out.println("=====1: "+toDo1);
//        String id = toDo1.getId();
//        ToDo toDo2 = toDoRepository.findById(id).get();
//        System.out.println("=====2: "+toDo2);
//        assertThat(toDo2.getId()).isEqualTo(toDo1.getId());


        // mock repo so when findById then return a test todo
        // testresttemplate to findById by id

        // assert that title equals
        // verify manager.findbyid called once
    }

    @Test
    void post() {
    }

    @Test
    void done() {
    }

}