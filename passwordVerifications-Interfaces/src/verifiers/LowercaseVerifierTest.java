package verifiers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowercaseVerifierTest {
    @ParameterizedTest
    @CsvSource({
            "hosaM123,true",
            "HOSAMm123,true",
            "HHHHHHHHH121,false",
            "12345678,false"
    })
    void checkOneLowercase(String password, boolean expected) {
        LowercaseVerifier verifier = new LowercaseVerifier();

        boolean actual = verifier.verify(password);

        assertEquals(expected, actual);
    }
}