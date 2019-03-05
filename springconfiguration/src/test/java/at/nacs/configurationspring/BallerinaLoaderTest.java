package at.nacs.configurationspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader ballerinaLoader;

    @Test
    void getBallerinas() {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        System.out.println(ballerinas);
        assertEquals(5, ballerinas.size());
    }
}