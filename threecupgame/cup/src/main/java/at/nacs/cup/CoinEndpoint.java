package at.nacs.cup;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CoinEndpoint {

    private final Cup cup;

    @GetMapping
    Boolean isHasCoin() {
        return cup.isHasCoin();
    }

    @PutMapping
    void putCoin() {
        cup.setHasCoin(true);
    }

    @DeleteMapping
    void deleteCoin() {
        cup.setHasCoin(false);
    }
}