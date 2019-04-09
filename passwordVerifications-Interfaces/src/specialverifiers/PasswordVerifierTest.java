package specialverifiers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordVerifierTest {
    @ParameterizedTest
    @CsvSource({
            "hosAm12345,true",
            "null,false",
            "WWWWWWWWW1w,true",
            "123456wW,true",
            "12345678WNULL,false"
    })
    void verifyConditions(String password, boolean expected) {
        PasswordVerifier verifier = new PasswordVerifier();

        boolean actual = verifier.verifyConditions(password);

        Assertions.assertEquals(expected, actual);
    }
}