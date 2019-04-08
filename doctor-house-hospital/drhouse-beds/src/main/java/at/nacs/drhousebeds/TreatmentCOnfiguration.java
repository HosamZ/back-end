package at.nacs.drhousebeds;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Configuration
@ConfigurationProperties("dataset")
public class TreatmentCOnfiguration {

    @Setter
    @Getter
    private Map<String, String> treatment;

    @Bean
    Map<String, String> treatment(){
        return treatment;
    }
}
