package at.nacs.configurationspring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sauna")
@Getter
@Setter
public class SaunaConfiguration {

    private int temperature;
    private int availableSeats;

}
