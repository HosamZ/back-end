package at.nacs.primenumbers;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
@Builder
public class Prime {

    public boolean isPrime(Integer candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(e -> elseTORENAME(candidate, e));
    }

    private boolean elseTORENAME(int candidate, int divisor) {
        return candidate % divisor == 0;
    }
}