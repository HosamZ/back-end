package at.nacs.primenumbers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {
    private final Prime prime;

    public long getPrimesSum(Integer limitOfPrimes) {
        return IntStream.iterate(2, e -> e + 1)
                .filter(prime::isPrime)
                .limit(limitOfPrimes)
                .sum();
    }
}