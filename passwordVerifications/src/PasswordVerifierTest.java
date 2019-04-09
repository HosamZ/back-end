import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordVerifierTest {

    private PasswordVerifier verifier = new PasswordVerifier();

    @Test
    void verify() {
        String password = "hosamM1213";

        boolean actual = verifier.verify(password);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);


    }
}