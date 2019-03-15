package at.nacs.morse;

import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndpoint {

    private final Encoder encoder;



    @PostMapping
    String encode(@RequestBody String letter) {
        return encoder.encode(letter);
    }
}