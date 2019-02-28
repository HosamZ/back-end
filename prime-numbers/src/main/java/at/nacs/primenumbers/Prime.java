package at.nacs.primenumbers;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
public class Prime {

    public boolean isPrime(Integer candidate) throws IllegalArgumentException {
        if (candidate.equals(1)||candidate.equals(0)){
            return false;
        }
        return IntStream.range(2, candidate)
                .peek(e -> System.out.println(e))
                .noneMatch(e -> nonPrimeNumber(candidate, e));
    }

    private boolean nonPrimeNumber(int candidate, int divisor) {
        return candidate % divisor == 0;
    }
}