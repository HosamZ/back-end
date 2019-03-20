package at.nacs.drhouseadmission;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    String url = "/patients";

    @Test
    void add() {
        Patient patient = Patient.builder().name("ahmad").symptoms("cancer").build();

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        System.out.println(actual);


    }
}