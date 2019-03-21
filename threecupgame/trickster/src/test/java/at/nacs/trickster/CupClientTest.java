package at.nacs.trickster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class CupClientTest {

    @MockBean
    CupsConfiguration cupsConfiguration;

    @Autowired
    CupClient cupClient;



    @Test
    void play() {
        List<String> cups = cupsConfiguration.cups;
        System.out.println(cups.toString());

//        System.out.println("!!!!!!!!"+trickster);
//        boolean choose = trickster.choose(1);
//
//        System.out.println(choose);

    }
    @Test
    void choose() {
    }
}