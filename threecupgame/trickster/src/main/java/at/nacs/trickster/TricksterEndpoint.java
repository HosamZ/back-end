package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TricksterEndpoint {

    private final CupClient cupClient;

    @GetMapping("/play")
    String play(){
        cupClient.play();
        return "The game has started!";
    }

    @GetMapping("/choose/{number}")
    boolean hasCoinOrNot(@PathVariable int number){
        return cupClient.choose(number);
    }

}
