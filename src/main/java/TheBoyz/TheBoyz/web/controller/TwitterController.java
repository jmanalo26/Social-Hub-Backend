package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@Slf4j
@RestController
public class TwitterController {

    private final TwitterService twitterService;


    public TwitterController(final TwitterService twitterService){
        this.twitterService = twitterService;
    }
    @GetMapping(value = "/api/twitter/followers")
    public ResponseEntity<Integer> getFollowerCount() throws TwitterException {
       return ResponseEntity<>(twitterService.getFollowerCount(), HttpStatus.OK);

    }

}
