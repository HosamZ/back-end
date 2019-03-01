package at.nacs.primenumbers;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
public class Prime {

    public boolean isPrime(Integer candidate)  {
        if (candidate < 2) {
            return false;
        }
        return IntStream.range(2, candidate)
                .noneMatch(e -> nonPrimeNumber(candidate, e));
    }

    private boolean nonPrimeNumber(int candidate, int divisor) {
        return candidate % divisor == 0;
    }
}