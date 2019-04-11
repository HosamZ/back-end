package verifiers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotNullVerifierTest {

    @ParameterizedTest
    @CsvSource({
            "hosaM123,true",
            ",false",
    })
    void checkForNullCase(String password, boolean expected) {
        NotNullVerifier notNullVerifier = new NotNullVerifier();

        boolean actual = notNullVerifier.verify(password);

        assertEquals(expected, actual);
    }
}