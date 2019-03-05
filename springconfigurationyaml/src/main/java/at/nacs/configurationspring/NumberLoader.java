package at.nacs.configurationspring;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NumberLoader {

    @Value("${number.load}")
    @Getter
    private int number;

}
