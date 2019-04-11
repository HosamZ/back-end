import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordVerifierTest {

    private PasswordVerifier verifier = new PasswordVerifier();

    @Test
    void verify() {
        String password = "hosaM123";

        boolean actual = verifier.verify(password);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);


    }
}