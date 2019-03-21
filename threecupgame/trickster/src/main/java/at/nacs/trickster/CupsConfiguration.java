package at.nacs.trickster;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("server")
public class CupsConfiguration {

    @Setter
    List<String> cups;

    @Bean
    List<String> cups(){
        return cups;
    }
}
