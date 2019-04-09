package specialverifiers;

import verifiers.*;

import java.util.Arrays;
import java.util.List;

public class PasswordVerifier {

    public boolean verifyConditions(String password) {
        List<Verifier> verifiers = getVerifiers();
        long counter = verifiers.stream()
                .map(e -> e.verify(password))
                .filter(e -> e == true)
                .count();
        if (counter >= 3 && verifiers.get(0).verify(password)) {
            return true;
        }
        return false;
    }

    private List<Verifier> getVerifiers() {
        return Arrays.asList(new LowercaseVerifier(), new LengthVerifier()
                , new NotNullVerifier(), new OneDigitCaseVerifier(), new UppercaseVerifier()
        );
    }
}