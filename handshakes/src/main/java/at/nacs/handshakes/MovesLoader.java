package at.nacs.handshakes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("shop")
public class MovesLoader {
    @Setter
    @Getter
    private Map<Integer, String> moves;
}