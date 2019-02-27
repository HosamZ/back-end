package at.nacs.primenumbers;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
public class Prime {

    public boolean isPrime(Integer candidate) throws IllegalStateException {
        return IntStream.range(2, candidate)
                .noneMatch(e -> ifPrime(candidate, e));
    }

    private boolean ifPrime(int candidate, int divisor) {
        return candidate % divisor == 0;
    }
}