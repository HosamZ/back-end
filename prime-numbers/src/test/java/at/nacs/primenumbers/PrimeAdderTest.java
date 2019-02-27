package at.nacs.primenumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @Test
    void sum() {
        long primes = primeAdder.getPrimesSum(100);

        System.out.println(primes);

    }
}