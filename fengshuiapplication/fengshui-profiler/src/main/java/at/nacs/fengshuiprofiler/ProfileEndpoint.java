package at.nacs.fengshuiprofiler;

import at.nacs.fengshuiprofiler.domain.Match;
import at.nacs.fengshuiprofiler.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class ProfileEndpoint {

    private final RestTemplate restTemplate;

    private String url= "http://localhost:9001/sign";

    @GetMapping("/profile/{birthday}")
    Profile get(){
        Profile profile = restTemplate.getForObject(url, Profile.class);
        return profile;
    }

    @GetMapping("/match/{birthday1}/{birthday2}")
    Match gett(){
        String url2 = "http://localhost:9001/compatibility/love";
        Match matchLove = restTemplate.getForObject(url2, Match.class);
        return matchLove;
    }
}
