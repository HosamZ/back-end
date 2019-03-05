package at.nacs.configurationspring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("objects")
@Setter
@Getter
public class BallerinaLoader {

    private List<Ballerina> ballerinas;
}