package at.nacs.morse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/morseendpoint")
@RequiredArgsConstructor
public class MorseEndpoint {

    private final Morse morse;

    @PostMapping
    List<String> enocde(@RequestBody String message){
        Map<String, String> morseCode1 =morse.getTranslate();
        String lowerCaseMsg = message.toLowerCase();
        return Arrays.stream(lowerCaseMsg.split(""))
                .flatMap(Stream::of)
                .filter(morseCode1::containsKey)
                .map(morseCode1::get)
                .collect(Collectors.toList());
    }
}