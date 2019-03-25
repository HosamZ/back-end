package at.nacs.twitterboardprogram;

import at.nacs.twitterboardprogram.domain.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetRepository extends MongoRepository<Tweet,String> {
    void findByTimeStamp();

}
