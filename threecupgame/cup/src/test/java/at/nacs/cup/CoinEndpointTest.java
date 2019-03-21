package at.nacs.cup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CoinEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    private String url = "/coin";

    @AfterEach
    void reset() {
        testRestTemplate.delete(url);
    }

    @Test
    void putCoin() {
        testRestTemplate.put(url, null);

        boolean actual = testRestTemplate.getForObject(url, Boolean.class);

        assertThat(actual).isTrue();
    }

    @Test
    void inOrNot() {
        Boolean actual = testRestTemplate.getForObject(url, boolean.class);

        assertThat(actual).isFalse();
    }

    @Test
    void deleteCoin() {
        testRestTemplate.delete(url);

        Boolean actual = testRestTemplate.getForObject(url, boolean.class);

        assertThat(actual).isFalse();
    }
}