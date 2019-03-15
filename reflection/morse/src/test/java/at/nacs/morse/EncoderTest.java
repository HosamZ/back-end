package at.nacs.morse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class EncoderTest {

    @Autowired
    Encoder encoder;

    @ParameterizedTest
    @CsvSource({
            "a,:D",
            "b,XD",
            " a   , :D "
    })
    void testEncode(String letter, String expectedEncodedLetter) {
        String actual = encoder.encode(letter);

        assertEquals(expectedEncodedLetter, actual);
    }
}