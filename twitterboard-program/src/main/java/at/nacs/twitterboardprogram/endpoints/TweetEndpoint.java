package at.nacs.twitterboardprogram.endpoints;

import at.nacs.twitterboardprogram.TweetRepository;
import at.nacs.twitterboardprogram.domain.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TweetEndpoint {

    private final TweetRepository tweetRepository;

    @GetMapping
    List<Tweet> get(){
        tweetRepository.findByTimeStamp();
    }

}
