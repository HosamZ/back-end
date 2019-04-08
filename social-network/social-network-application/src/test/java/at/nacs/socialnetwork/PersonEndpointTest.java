package at.nacs.socialnetwork;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    Person personwithnofriends;

    @Setter
    Person personwithfriends;

    @SpyBean
    PersonManager manager;

    @MockBean
    PersonRepository repository;

    private String url = "/persons";

    @Test
    void findAll() {
        testRestTemplate.getForObject(url, Person[].class);

        verify(manager).findAll();
    }

    @Test
    void findPersonsOneFriend() {
        testRestTemplate.getForObject(url + "/friends/with", Person[].class);

        verify(manager).findAllPersonsWithFriend();
    }

    @Test
    void findPersonsWithNoFriends() {
        testRestTemplate.getForObject(url + "/friends/without", Person[].class);

        verify(manager).findAllPersonsWithNoFriend();
    }

    @Test
    void save() {
        testRestTemplate.postForEntity(url, personwithfriends, Person.class);
//        verify(manager).;
    }

    @Test
    void testMakefriends() {
        Long id1 = 1L;
        Long id2 = 2L;

        testRestTemplate.put(url + "/" + id1 + "/friend/" + id2, void.class);

        verify(manager).makeFriend(id1, id2);
    }

    @Test
    void unfriend() {
        Long id1 = 1L;
        Long id2 = 2L;

        testRestTemplate.put(url + "/" + id1 + "/unfriend/" + id2, void.class);

        verify(manager).makeUnfriend(id1, id2);
    }
}