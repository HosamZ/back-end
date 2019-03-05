package at.nacs.configurationspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberLoaderTest {


    @Autowired
    NumberLoader loader;

    @Test
    void getNumber() {

        int number = loader.getNumber();

        Assertions.assertEquals(369, number);
    }
}