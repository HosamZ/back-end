package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CupClient {

    private final RestTemplate restTemplate;
    private Random random = new Random();

    private final List<String> cups;

    public String play() {
        //remove all coins from 3 cups:
        cups.forEach(e -> restTemplate.delete(e));
//        restTemplate.delete("http://localhost:/coin");

        //put one coin in a random cup
        int cupNumber = random.nextInt(3);
        String url = cups.get(cupNumber);
        restTemplate.put(url, void.class);

        return "The game has started!";
    }

    public boolean choose(@PathVariable int number) {
        String url = cups.get(number);
        Boolean hasCoin = restTemplate.getForObject(url, Boolean.class);
        return hasCoin;
    }

//    GET to /choose/{number} -> contacts the cup application number number and
//    returns the boolean that it returns explaining whether the coin is there or not.
}