package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.*;
import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "/api/twitter/followers/{handle}")
    public ResponseEntity<Integer> getFollowerCount(@PathVariable String handle) throws TwitterException {
        System.out.println("in the Twitter controller for get followers");
       return new ResponseEntity<>(twitterService.getFollowerCount(handle), HttpStatus.OK);
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

//    /**
//     * Gets the user's current status tweet.
//     * @return returns the Status
//     * @throws TwitterException
//     */
//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping(value = "/api/twitter/brief-status/{userId}")
//    public ResponseEntity<BriefStatus> getBriefStatus(@PathVariable String userId) throws TwitterException {
//        System.out.println("in the twitter controller for status");
//        System.out.println("*************");
//        System.out.println(twitterService.getStatus());
//        return new ResponseEntity<>(twitterService.getBriefStatus(), HttpStatus.OK);
//    }
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/api/twitter/send/twitter-data")
    public ResponseEntity<TwitterData> saveTwitterData(@RequestBody TwitterData twitterData) throws NoSuchAlgorithmException, TwitterException {
        System.out.println("hit hte controller for twitter data");
        return new ResponseEntity<>(twitterService.captureTwitterData(twitterData), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/get/twitter-data/{userId}")
    public ResponseEntity<TwitterData> getTwitterData(@PathVariable String userId) throws TwitterException {
        System.out.println("*************");
        System.out.println(userId);
        return new ResponseEntity<>(twitterService.getTwitterData(userId), HttpStatus.OK);
    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/user-timeline/{twitterHandle}")
    public List<BriefStatus> getUserTimeline(@PathVariable String twitterHandle) throws TwitterException {
        System.out.println("XXXXXXXXXXX");
        System.out.println("GETTING TIMELINE FROM TWITTER CONTROLLER");
        System.out.println("*************");
        System.out.println("000000");
        System.out.println(twitterHandle);
//        System.out.println(twitterService.getStatus());
//        return this.twitterService.getUserTimeline(twitterHandle);

        return this.twitterService.getUserTimeline(twitterHandle);
    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/get-friends-list/{handle}")
    public List<String> getFriends(@PathVariable String handle) throws TwitterException {
        return twitterService.getFriends(handle);

//        return new ResponseEntity<>(twitterService.getStatus(), HttpStatus.OK);
    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/most-recent-post/{handle}")
    public ResponseEntity<BriefStatus> getMostRecentPost(@PathVariable String handle) throws TwitterException {
        System.out.println(twitterService.getStatus());
        return new ResponseEntity<>(twitterService.getBriefStatus(handle), HttpStatus.OK);

    }

    /**
     * Gets the user's current status tweet.
     * @return returns the Status
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/twitter/get-rankings/{handle}")
    public List<TwitterRanking> getRankingList(@PathVariable String handle) throws TwitterException {

        return twitterService.getRankingList(handle);

    }

}
