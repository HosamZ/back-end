package at.nacs.morse;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("translation")
public class Encoder {

    @Setter
    private Map<String, String> morse;

    public String encode(String letter) {
        return morse.get(letter.toLowerCase());
    }
}
