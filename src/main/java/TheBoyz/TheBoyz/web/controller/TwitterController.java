package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.Tweet;
import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Status;
import twitter4j.TwitterException;

@Slf4j
@RestController
public class TwitterController {

    private final TwitterService twitterService;

    public TwitterController(final TwitterService twitterService){
        this.twitterService = twitterService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/followers")
    public ResponseEntity<Integer> getFollowerCount() throws TwitterException {
        System.out.println("in the tiwtter controller for get followers");
       return new ResponseEntity<>(twitterService.getFollowerCount(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/get-tweets")
    public ResponseEntity<Tweet> getTweets() throws TwitterException {
        System.out.println("in the tiwtter controller for tweets");
        return new ResponseEntity<>(twitterService.getTimeline(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/status")
    public ResponseEntity<Status> getStatus() throws TwitterException {
        System.out.println("in the tiwtter controller for status");
        System.out.println("*************");
        System.out.println(twitterService.getStatus());
        return new ResponseEntity<>(twitterService.getStatus(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/status-tweet")
    public ResponseEntity<Tweet> getStatusAsTweet() throws TwitterException {
        System.out.println("*************");
        System.out.println(twitterService.getStatusAsTweet());
        return new ResponseEntity<>(twitterService.getStatusAsTweet(), HttpStatus.OK);
    }
}
