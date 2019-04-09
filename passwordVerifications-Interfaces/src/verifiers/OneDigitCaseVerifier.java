package verifiers;

import java.util.stream.Stream;

public class OneDigitCaseVerifier implements Verifier {
    @Override
    public boolean verify(String password) {
        return Stream.of(password.split(""))
                .flatMap(Stream::of)
                .map(e -> e.charAt(0))
                .anyMatch(Character::isDigit);
    }
}