package at.nacs.primenumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeTest {

    @Autowired
    Prime prime;

    @ParameterizedTest
    @CsvSource({
            "true, 2",
            "true, 5",
            "true, 13",
            "false, 28",
            "false, 22"
    })
    @Test
    void isPrime(boolean expected, int number) {
        boolean result = prime.isPrime(number);

        assertEquals(expected, result);
    }
}