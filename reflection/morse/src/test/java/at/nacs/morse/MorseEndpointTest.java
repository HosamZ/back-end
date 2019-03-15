package at.nacs.morse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MorseEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/morse";

    @Test
    public void encode() {
        String letter = "a";

        String actual = restTemplate.postForObject(url, letter, String.class);
        String expected = ":D";

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotNull();
    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "a,.-",
//            "b,-..."
//    })
//    void postLetter(String letter, String encodedLetter) {
////        MorseEndpoint morseEndpoint = new MorseEndpoint(letter,encodedLetter);
////        String expected = restTemplate.postForObject(url, encoder, String.class);
////        assertThat().isEqualTo(expected);
//
//
//    }
}