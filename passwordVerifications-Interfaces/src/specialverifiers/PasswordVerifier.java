package specialverifiers;

import verifiers.*;

import java.util.List;

import static java.util.Arrays.asList;

public class PasswordVerifier {

    public boolean verifyConditions(String password) {
        List<Verifier> verifiers = getVerifiers();
        long counter = verifiers.stream()
                .map(e -> e.verify(password))
                .filter(e -> e == true)
                .count();
        if (counter >= 3 && isOneLowercaseAtLeast(password, verifiers.get(0))) {
            return true;
        }
        return false;
    }

    private boolean isOneLowercaseAtLeast(String password, Verifier verifier) {
        return verifier.verify(password);
    }

    private List<Verifier> getVerifiers() {
        return asList(new LowercaseVerifier(), new LengthVerifier()
                , new NotNullVerifier(), new OneDigitCaseVerifier(), new UppercaseVerifier()
        );
    }
}