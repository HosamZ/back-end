package at.nacs.ex2amazinghelloworld;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
@RequiredArgsConstructor
public class Hello {

    public String getName() {
        return "Hello";
    }
}