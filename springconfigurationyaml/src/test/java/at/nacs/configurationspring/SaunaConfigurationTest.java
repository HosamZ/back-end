package at.nacs.configurationspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaunaConfigurationTest {


    @Autowired
    SaunaConfiguration saunaConfiguration;

    @Test
    void testTemperature() {
        int temperature = saunaConfiguration.getTemperature();

        Assertions.assertEquals(14, temperature);
    }

    @Test
    void testAvailableSeats() {
        int availableSeats = saunaConfiguration.getAvailableSeats();

        Assertions.assertEquals(4, availableSeats);
    }
}