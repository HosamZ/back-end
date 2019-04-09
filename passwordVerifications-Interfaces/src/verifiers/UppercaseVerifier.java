package verifiers;

import java.util.stream.Stream;

public class UppercaseVerifier implements Verifier {
    @Override
    public boolean verify(String password) {
        return Stream.of(password.split(""))
                .map(e -> e.charAt(0))
                .anyMatch(Character::isUpperCase);
    }
}