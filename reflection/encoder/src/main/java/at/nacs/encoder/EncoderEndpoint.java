package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndpoint {
    private final MorseClient morseClient;

    @PostMapping
    String letter(@RequestBody String plainText){
        return Stream.of(plainText)
                .map(e -> plainText.replaceAll(" ",""))
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .map(letter -> morseClient.send(letter))
                .collect(Collectors.joining());
    }
    //ToDo post here
}