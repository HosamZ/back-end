package at.nacs.primenumbers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {

    Prime prime;

    public long getPrimes(Integer limitOfPrimes) {
        return IntStream.iterate(2, e -> e++)
                .filter(e->prime.isPrime(e))
                .limit(limitOfPrimes)
                .sum();
    }

}