package at.nacs.primenumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeAdderTest {

    private static final int EXPECTED_SUM = 24133;
    private static final int PRIME_RANGE = 100;
    @Autowired
    PrimeAdder primeAdder;

    @Test
    void sum() {
        long actual = primeAdder.getPrimesSum(PRIME_RANGE);

        long expected = EXPECTED_SUM;

        assertEquals(expected, actual);
    }
}