package at.nacs.primenumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @Test
    void sum() {
        int primeRange = 100;

        long actual = primeAdder.getPrimesSum(primeRange);
        long expected = 24133;

        assertEquals(expected, actual);
    }
}