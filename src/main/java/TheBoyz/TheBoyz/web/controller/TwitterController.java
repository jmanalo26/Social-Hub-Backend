package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.BriefStatus;
import TheBoyz.TheBoyz.data.model.SecureTwitter;
import TheBoyz.TheBoyz.data.model.Tweet;
import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Slf4j
@RestController
/**
 * The Controller for all calls related to Twitter.
 */
public class TwitterController {

    private final TwitterService twitterService;

    /**
     * The constructor for the twitter controller.
     * @param twitterService The service to make calls to the API and Database.
     */
    public TwitterController(final TwitterService twitterService){
        this.twitterService = twitterService;
    }

    /**
     * gets the user's number of followers.
     * @return returns the number of followers the user has.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/followers")
    public ResponseEntity<Integer> getFollowerCount() throws TwitterException {
        System.out.println("in the tiwtter controller for get followers");
       return new ResponseEntity<>(twitterService.getFollowerCount(), HttpStatus.OK);
    }

    /**
     * Gets the user's tweets from their timeline.
     * @return returns the user's tweets.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/get-tweets")
    public ResponseEntity<Tweet> getTweets() throws TwitterException {
        System.out.println("In the Twitter controller for tweets");
        return new ResponseEntity<>(twitterService.getTimeline(), HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/full-timeline")
    public List<Tweet> viewTimeLine() throws TwitterException {
        log.info("************ ");
        return this.twitterService.getFullTimeline();
    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/status")
    public ResponseEntity<Status> getStatus() throws TwitterException {
        System.out.println("in the tiwtter controller for status");
        System.out.println("*************");
        System.out.println(twitterService.getStatus());
        return new ResponseEntity<>(twitterService.getStatus(), HttpStatus.OK);
    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/brief-status/{userId}")
    public ResponseEntity<BriefStatus> getBriefStatus(@PathVariable String userId) throws TwitterException {
        System.out.println("in the twitter controller for status");
        System.out.println("*************");
        System.out.println(twitterService.getStatus());
        return new ResponseEntity<>(twitterService.getBriefStatus(), HttpStatus.OK);
    }
    /**
     * Gets the current status as a tweet.
     * @return returns the user's tweet as a tweet object
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/status-tweet")
    public ResponseEntity<Tweet> getStatusAsTweet() throws TwitterException {
        System.out.println("*************");
        System.out.println(twitterService.getStatusAsTweet());
        return new ResponseEntity<>(twitterService.getStatusAsTweet(), HttpStatus.OK);
    }
    /**
     * Gets the current status as a status json object.
     * @return returns the user's tweet.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/twitter/post-status")
    public ResponseEntity<Status> postStatus(@RequestBody Tweet tweet) throws TwitterException {
        return new ResponseEntity<>(twitterService.postStatus(tweet.getTweetText()), HttpStatus.OK);

    }

    /**
     * Gets the current status as a status json object.
     * @return returns the user's tweet.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/twitter/post")
    public ResponseEntity<Tweet> postUserStatus(@RequestBody Tweet tweet) throws TwitterException {
        return new ResponseEntity<>(twitterService.postUserStatus(tweet.getTweetText()), HttpStatus.OK);

    }

    /**
     * Gets the current status as a status json object.
     * @return returns the user's tweet.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/twitter/capture/tokens")
    public ResponseEntity<SecureTwitter> captureTokens(@RequestBody SecureTwitter secureTwitter) throws NoSuchAlgorithmException {
        return new ResponseEntity<>(twitterService.captureTokensByObject(secureTwitter), HttpStatus.OK);
    }

    /**
     * Gets the current status as a tweet.
     * @return returns the user's tweet as a tweet object
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/secure/check/{userId}")
    public ResponseEntity<Integer> checkTwitterRegistered(@PathVariable String userId) throws TwitterException {
        System.out.println("*************");
//        System.out.println(twitterService.getStatusAsTweet());
        return new ResponseEntity<>(twitterService.checkTwitterRegistered(userId), HttpStatus.OK);
    }
}
