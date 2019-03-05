package at.nacs.configurationspring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("library")
public class BookShopLoader {

    @Setter
    @Getter
    private Map<String, Integer> books;

}
