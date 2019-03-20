package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/patients";

    @Test
    void testPatient() {
        Patient patient = Patient.builder().id("123").name("samer").symptoms("wasting time on PC").diagnosis("Dota").build();

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);
        System.out.println(actual);
        assertThat(restTemplate.postForObject(url, patient, String.class));
    }
}