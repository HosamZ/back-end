package at.nacs.primenumbers;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
public class PrimeAdder {
    Prime prime;

    public long getPrimesSum(Integer limitOfPrimes) {
        return IntStream.iterate(2, e -> ++e)
                .filter(prime::isPrime)
                .limit(limitOfPrimes)
                .sum();
    }
}