package at.nacs.configurationspring;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WordLoader {

    @Getter
    @Value("${word.load}")
    private String word;
}
