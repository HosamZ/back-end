package verifiers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneDigitCaseVerifierTest {

    @ParameterizedTest
    @CsvSource({
            "hosaM123,true",
            "sadsadsadS,false",
    })
    void checkForNullCase(String password, boolean expected) {
        OneDigitCaseVerifier oneDigitCaseVerifier = new OneDigitCaseVerifier();

        boolean actual = oneDigitCaseVerifier.verify(password);

        assertEquals(expected, actual);
    }
}