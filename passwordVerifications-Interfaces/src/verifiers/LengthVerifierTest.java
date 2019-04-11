package verifiers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthVerifierTest {
    @ParameterizedTest
    @CsvSource({
            "hosaM123,true",
            "sssssss,false",
            "qs,false",
            "1234567,false"
    })
    void checkPasswordLength(String password, boolean expected) {
        LengthVerifier verifier = new LengthVerifier();

        boolean actual = verifier.verify(password);

        assertEquals(expected, actual);
    }
}