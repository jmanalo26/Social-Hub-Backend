package TheBoyz.TheBoyz.web.service;

import TheBoyz.TheBoyz.data.model.*;
import TheBoyz.TheBoyz.data.repository.TwitterDataRepository;
import TheBoyz.TheBoyz.data.repository.TwitterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;
import twitter4j.Status;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * The class that makes calls to the database and to the api.
 */
@Slf4j
@RestController
public class TwitterService {

    TwitterFactory tf;
    Twitter twitter;

    private final TwitterRepository twitterRepository;
    private final TwitterDataRepository twitterDataRepository;


    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    private String twitterHandle;


    public TwitterService(TwitterRepository twitterRepository, TwitterDataRepository twitterDataRepository) {
        this.twitterRepository = twitterRepository;
        this.twitterDataRepository = twitterDataRepository;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-cB5cT5b401gAmv376yeJ7wHVfaKb1p")
                .setOAuthAccessTokenSecret("o7rkWS860O59I93JxPpS0oG2UTgDQClQeKFlUW7Mz8yY5");

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
//    public TwitterService(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, TwitterRepository twitterRepository) {
//        this.twitterRepository = twitterRepository;
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//                .setOAuthConsumerKey(consumerKey)
//                .setOAuthConsumerSecret(consumerSecret)
//                .setOAuthAccessToken(accessToken)
//                .setOAuthAccessTokenSecret(accessTokenSecret);
//
//        tf = new TwitterFactory(cb.build());
//        twitter = tf.getInstance();
//    }

    /**
     * Makes the API call the twitter api to get the number of followers the user has.
     * @return returns the number of followers the user has
     * @throws TwitterException
     */
    public Integer getFollowerCount(String handle) throws TwitterException {
        System.out.println("In teh get follower count method");
        User user = twitter.showUser(handle);
        System.out.println("This is the follower count: " + user.getFollowersCount());
        System.out.println("This is the favorites count: " + user.getFavouritesCount());
        System.out.println("This is the URL: " + user.getURL());
        int followerCount = user.getFollowersCount();
        return followerCount;
    }

    /**
     * Makes the API call the twitter api to get the number of followers the user has by their screen name.
     * @return returns the number of followers the user has
     * @throws TwitterException
     */
    public Integer getFollowerCountByScreenName() throws TwitterException {
        System.out.println("In teh get follower count method");
        User user = twitter.showUser("SocialHubClub");
        System.out.println("This is the follower count: " + user.getFollowersCount());
        System.out.println("This is the favorites count: " + user.getFavouritesCount());
        System.out.println("This is the URL: " + user.getURL());
        int followerCount = user.getFollowersCount();
        return followerCount;

    }

    /**
     * Makes the api call to get the user's timeline from their twitter.
     * @return returns a list of tweet objects.
     * @throws TwitterException
     */
    public List<Tweet> getFullTimeline() throws TwitterException {

//        List<Status> status = twitter.getHomeTimeline();
        List<String> timelineList = twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        List<String> timelineListCreator = twitter.getHomeTimeline().stream()
                .map(item -> item.getUser().getName())
//                .map(item -> item.getMediaEntities())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        List<Tweet> timelineListArray = new ArrayList<>();
        for (int i = 0; i < timelineList.size(); i++) {
            Tweet newTweet = new Tweet();
            System.out.println(timelineList.get(i));
            System.out.println(timelineListCreator.get(i));
            newTweet.setTweetText(timelineList.get(i));
            newTweet.setTweetCreatedBy(timelineListCreator.get(i));
            timelineListArray.add(newTweet);
        }
        return timelineListArray;
    }

    /**
     * Makes the twitter api call tandGets the user's latest timeline post..
     * @return returns the user's timeline
     * @throws TwitterException
     */
    public Tweet getTimeline() throws TwitterException {

        Tweet tweet = new Tweet();
//        List<Status> status = twitter.getHomeTimeline();
        List<String> timelineList = twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        List<String> timelineListCreator = twitter.getHomeTimeline().stream()
                .map(item -> item.getUser().getName())
//                .map(item -> item.getMediaEntities())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        for (int i = 0; i < timelineList.size(); i++) {
            System.out.println(timelineList.get(i));
            System.out.println(timelineListCreator.get(i));
            tweet.setTweetText(timelineList.get(i));
            tweet.setTweetCreatedBy(timelineListCreator.get(i));
        }
    return tweet;
    }

    /**
     * Get's the users latest status.
     * @return returns a Status object for the contents of the tweet.
     * @throws TwitterException
     */
    public Status getStatus() throws TwitterException {
        //
        System.out.println("In the get tweets method");
//            Twitter twitter = new TwitterFactory().getInstance();
        User user = twitter.showUser("SocialHubClub");
        String twitterStatus = "";
        System.out.println(user.getStatus());
        if (user.getStatus() != null) {
            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            twitterStatus = user.getStatus().getText();
        } else {
            // the user is protected
            System.out.println("@" + user.getScreenName());
        }
        System.out.println("************");
        System.out.println("returning: " + twitterStatus);
        Tweet statusTweet = new Tweet();
        statusTweet.setTweetText(user.getStatus().getText());
        statusTweet.setTweetCreatedBy(user.getName());
        return user.getStatus();
    }

    /**
     * Get's the users latest status.
     * @return returns a Tweet object for the contents of the tweet.
     * @throws TwitterException
     */
    public Tweet getStatusAsTweet() throws TwitterException {
        System.out.println("In the get tweets method");
//            Twitter twitter = new TwitterFactory().getInstance();
        User user = twitter.showUser("SocialHubClub");
        String twitterStatus = "";
        System.out.println(user.getStatus());
        if (user.getStatus() != null) {
            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            twitterStatus = user.getStatus().getText();
        } else {
            // the user is protected
            System.out.println("@" + user.getScreenName());
        }
        System.out.println("************");
        System.out.println("returning: " + twitterStatus);
        Tweet statusTweet = new Tweet();
        statusTweet.setTweetText(user.getStatus().getText());
        statusTweet.setTweetCreatedBy(user.getName());
        return statusTweet;
    }

    /**
     * Makes the api call to post a tweet to the user's twitter page.
     * @param textStatus is the content (text) of the tweet to be posted.
     * @return returns the status of that tweet.
     * @throws TwitterException
     */
    public Status postStatus(String textStatus) throws TwitterException, IOException {
        System.out.println("IN HTE POST STATUS METHOD!");
        var statusUpdate = new StatusUpdate(textStatus);
        int width = 963;    //width of the image
        int height = 640;   //height of the image
        BufferedImage image = null;
        File f = null;
        f = new File("kyleimg.jpg"); //image file path
        System.out.println(f.getName());
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(f);
        statusUpdate.setMedia(f);
        Status newStatus = twitter.updateStatus(textStatus);
        System.out.println(newStatus.getText());
        return newStatus;
    }

    /**
     * Makes the api call to post a tweet to the user's twitter page.
     * @param textStatus is the content (text) of the tweet to be posted.
     * @return
     * @throws TwitterException
     */
    public Tweet postUserStatus(String textStatus) throws TwitterException, IOException {

        System.out.println("IN HTE POST USER STATUS METHOD!");
        var statusUpdate = new StatusUpdate(textStatus);
        int width = 963;    //width of the image
        int height = 640;   //height of the image
        BufferedImage image = null;
        File f = null;
        f = new File("src/download.jpg"); //image file path
        System.out.println(f.getName());
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(f);
        statusUpdate.setMedia(f);
        Status newStatus = twitter.updateStatus(statusUpdate);
//        System.out.println(newStatus.getText());


//        Status newStatus = twitter.updateStatus(textStatus);
        Tweet newTweet = new Tweet();
        newTweet.setTweetCreatedBy(newStatus.getUser().getScreenName());
        newTweet.setTweetText(textStatus);
        System.out.println(newStatus.getText());
        return newTweet;
    }

    /**
     * Makes the api call to post a tweet to the user's twitter page.
     * @param content is the content (text) of the tweet to be posted.
     * @throws TwitterException
     */
    public Status postStatusWithContent(Status content) throws TwitterException {

        Status newStatus = twitter.updateStatus(String.valueOf(content.getQuotedStatus()));
        System.out.println(newStatus.getText());
        System.out.println(newStatus.getUser());
        System.out.println(newStatus.getFavoriteCount());
        return newStatus;
    }

    /**
     * Get the user's status as a breif object of only the important attributes.
     * @return
     * @throws TwitterException
     */
    public BriefStatus getBriefStatus(String handle) throws TwitterException {
        User user = twitter.showUser(handle);
        String twitterStatus = "";
        System.out.println(user.getStatus());
        if (user.getStatus() != null) {
            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            twitterStatus = user.getStatus().getText();
        } else {
            System.out.println("@" + user.getScreenName());
        }
        System.out.println("************");
        System.out.println("returning: " + twitterStatus);
        user.get400x400ProfileImageURL();
        Tweet statusTweet = new Tweet();
        BriefStatus briefStatusTweet = new BriefStatus();
        briefStatusTweet.setCreatedAt(user.getStatus().getCreatedAt());
        briefStatusTweet.setFavoriteCount(user.getStatus().getFavoriteCount());
        briefStatusTweet.setHandle(user.getName());
        briefStatusTweet.setScreenName(user.getScreenName());
        briefStatusTweet.setRetweetCount(user.getStatus().getRetweetCount());
        briefStatusTweet.setText(user.getStatus().getText());
        statusTweet.setTweetText(user.getStatus().getText());
        statusTweet.setTweetCreatedBy(user.getName());
        return briefStatusTweet;
    }

    public void captureTokens(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret){

    }

    public SecureTwitter captureTokensByObject(SecureTwitter secureTwitter) throws NoSuchAlgorithmException {

        System.out.println(secureTwitter.getConsumerKey());
        System.out.println(secureTwitter.getConsumerSecret());
        System.out.println(secureTwitter.getAccessToken());
        System.out.println(secureTwitter.getAccessTokenSecret());
        System.out.println(secureTwitter.getUserId());
        System.out.println(secureTwitter.getTwitterHandle());
        SecureTwitter searchedSecure = twitterRepository.findSecureTwitterByUserId(Integer.valueOf(secureTwitter.getUserId()));
        if(searchedSecure == null){
            System.out.println("the user id does not exist in the db, saving secure infromation");
            setTwitterTokens(secureTwitter);
            twitterRepository.save(secureTwitter);

            return secureTwitter;
        } else {
            twitterRepository.save(secureTwitter);

            hashObject(secureTwitter);
            return searchedSecure;
        }
    }

    public Integer checkTwitterRegistered(String userId){
        SecureTwitter searchedSecure = twitterRepository.findSecureTwitterByUserId(Integer.valueOf(userId));
        if(searchedSecure != null){
            return searchedSecure.getUserId();
        }
        return -1;
    }

    public void setTwitterTokens(SecureTwitter secureTwitter){
        System.out.println("Setting the twitter tokens");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(secureTwitter.getConsumerKey())
                .setOAuthConsumerSecret(secureTwitter.getConsumerSecret())
                .setOAuthAccessToken(secureTwitter.getAccessToken())
                .setOAuthAccessTokenSecret(secureTwitter.getAccessTokenSecret());

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        return hex;
    }

    public SecureTwitter hashObject(SecureTwitter secureTwitter) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String input = secureTwitter.getConsumerKey();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setConsumerKey(hex);

        input = secureTwitter.getConsumerSecret();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setConsumerSecret(hex);

        input = secureTwitter.getAccessToken();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setAccessToken(hex);

        input = secureTwitter.getAccessTokenSecret();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setAccessTokenSecret(hex);
        System.out.println(hex.length());

        return secureTwitter;
    }

    public TwitterData captureTwitterData(TwitterData twitterData) throws NoSuchAlgorithmException, TwitterException {
        System.out.println("hit the capture twitter data in the service");

        System.out.println(twitterData.getUserId());
        System.out.println(twitterData.getTwitterHandle());
        User user = twitter.showUser(twitterData.getTwitterHandle());
        if(user == null){
            System.out.println("the twitter user wasnt found by the handle given");
            return null;
        }
        int followerCount = twitter.showUser(twitterData.getTwitterHandle()).getFollowersCount();
        System.out.println("follower count: " + followerCount);
        twitterData.setFollowerCount(followerCount);

        if (user.getStatus() != null) {

            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            System.out.println("found the twitter data from the api");
            System.out.println(twitter.showUser(twitterData.getTwitterHandle()).getStatus().getText());

        } else {
            System.out.println("@" + user.getScreenName());
        }
        TwitterData searchedTwitterData = twitterDataRepository.findByUserId(twitterData.getUserId());
        if(searchedTwitterData == null){
            System.out.println("the twitter searched is null");
            twitterDataRepository.save(twitterData);

        } else {
            System.out.println("found existing twitter data for the user... deleting...");
            twitterDataRepository.delete(searchedTwitterData);
            twitterDataRepository.save(twitterData);
        }
        System.out.println("this is the follower count for twitter data object: " + twitterData.getFollowerCount());
        return twitterData;


    }

    public TwitterData getTwitterData(String userId) {
       TwitterData searchData = twitterDataRepository.findByUserId(Integer.valueOf(userId));
       if(searchData == null){
           return null;
       }
       return searchData;
    }

    /**
     * Get the user's status as a breif object of only the important attributes.
     * @return
     * @throws TwitterException
     */
    public List<BriefStatus> getUserTimeline(String twitterHandle) throws TwitterException {
        System.out.println("IN THE GET USER TIMELINE...");
        User user = twitter.showUser(twitterHandle);
        ResponseList<Status> userTimeline = twitter.getUserTimeline(twitterHandle);
        List<BriefStatus> userTimelineBrief = new ArrayList<>();
//        System.out.println("the length of timeline: " + userTimeline.size());

        int numOfRetweets = 0;
        int numOfFavorites = 0;
        BriefStatus mostRetweeted = new BriefStatus();
        BriefStatus mostFavorited = new BriefStatus();

        for (int i = 0; i < userTimeline.size(); i++) {
            BriefStatus bs = new BriefStatus();
            bs.setRetweetCount(userTimeline.get(i).getRetweetCount());
            if (userTimeline.get(i).getRetweetCount() > numOfRetweets) {
                numOfRetweets = userTimeline.get(i).getRetweetCount();

                System.out.println("num of retweets: " + numOfRetweets);
                mostRetweeted.setRetweetCount(userTimeline.get(i).getRetweetCount());
                mostRetweeted.setText(userTimeline.get(i).getText());
//                System.out.println(userTimeline.get(i).getText());
                mostRetweeted.setScreenName(userTimeline.get(i).getUser().getName());
                mostRetweeted.setHandle(userTimeline.get(i).getUser().getScreenName());
                mostRetweeted.setFavoriteCount(userTimeline.get(i).getFavoriteCount());
                mostRetweeted.setCreatedAt(userTimeline.get(i).getCreatedAt());
            }
            if (userTimeline.get(i).getFavoriteCount() > numOfFavorites) {
                System.out.println("true ");
                numOfFavorites = userTimeline.get(i).getFavoriteCount();

                System.out.println("numOfFavorites: :" + numOfFavorites);
                mostFavorited.setRetweetCount(userTimeline.get(i).getRetweetCount());
                mostFavorited.setText(userTimeline.get(i).getText());
//                System.out.println(userTimeline.get(i).getText());
                mostFavorited.setScreenName(userTimeline.get(i).getUser().getName());
                mostFavorited.setHandle(userTimeline.get(i).getUser().getScreenName());
                mostFavorited.setFavoriteCount(userTimeline.get(i).getFavoriteCount());
                mostFavorited.setCreatedAt(userTimeline.get(i).getCreatedAt());
            }

            bs.setText(userTimeline.get(i).getText());
            bs.setScreenName(userTimeline.get(i).getUser().getName());
            bs.setHandle(userTimeline.get(i).getUser().getScreenName());
            bs.setFavoriteCount(userTimeline.get(i).getFavoriteCount());
            bs.setCreatedAt(userTimeline.get(i).getCreatedAt());
            userTimelineBrief.add(bs);
        }
        System.out.println(userTimelineBrief.size());
        if (numOfFavorites != 0) {
            userTimelineBrief.add(0, mostFavorited);
        }
        if (numOfRetweets != 0) {
            userTimelineBrief.add(1, mostRetweeted);

        }
        System.out.println(userTimelineBrief.size());


        System.out.println(userTimelineBrief.get(0).getText());
        System.out.println(userTimelineBrief.get(0).getRetweetCount());

        return userTimelineBrief;
    }


//    /**
//     * Get the user's status as a breif object of only the important attributes.
//     * @return
//     * @throws TwitterException
//     */
//    public List<BriefStatus> getUserTimeline(String twitterHandle) throws TwitterException {
//        System.out.println( "IN THE GET USER TIMELINE...");
//        User user = twitter.showUser(twitterHandle);
//        ResponseList<Status> userTimeline = twitter.getUserTimeline(twitterHandle);
//        List<BriefStatus> userTimelineBrief = new ArrayList<>();
////        System.out.println("the length of timeline: " + userTimeline.size());
//
//        for(int i = 0; i < userTimeline.size(); i++){
//            System.out.println(userTimeline.get(i).getText());
//            BriefStatus bs = new BriefStatus();
//            bs.setRetweetCount(userTimeline.get(i).getRetweetCount());
//            bs.setText(userTimeline.get(i).getText());
//            bs.setScreenName(userTimeline.get(i).getUser().getName());
//            bs.setHandle(userTimeline.get(i).getUser().getScreenName());
//            bs.setFavoriteCount(userTimeline.get(i).getFavoriteCount());
//            bs.setCreatedAt(userTimeline.get(i).getCreatedAt());
//            userTimelineBrief.add(bs);
//        }
//        System.out.println(userTimelineBrief.size());
//
//        System.out.println(userTimelineBrief.get(0).getText());
//        System.out.println(userTimelineBrief.get(0).getRetweetCount());
//
//        return userTimelineBrief;


//        String twitterStatus = "";
//        System.out.println(user.getStatus());
//        if (user.getStatus() != null) {
//            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
//            twitterStatus = user.getStatus().getText();
//        } else {
//            System.out.println("@" + user.getScreenName());
//        }
//        System.out.println("************");
//        System.out.println("returning: " + twitterStatus);
//        user.get400x400ProfileImageURL();
//        Tweet statusTweet = new Tweet();
//        BriefStatus briefStatusTweet = new BriefStatus();
//        briefStatusTweet.setCreatedAt(user.getStatus().getCreatedAt());
//        briefStatusTweet.setFavoriteCount(user.getStatus().getFavoriteCount());
//        briefStatusTweet.setHandle(user.getName());
//        briefStatusTweet.setScreenName(user.getScreenName());
//        briefStatusTweet.setRetweetCount(user.getStatus().getRetweetCount());
//        briefStatusTweet.setText(user.getStatus().getText());
//        statusTweet.setTweetText(user.getStatus().getText());
//        statusTweet.setTweetCreatedBy(user.getName());
//        return userTimeline;
//    }

    public List<String> getFriends(String handle) throws TwitterException {
        System.out.println(handle);
//        User user = twitter.showUser(handle);
//        twitter.getFriendsIDs(handle, -1);
        List<User> users = twitter.getFriendsList(handle, -1);
        System.out.println("USERS FRIENDS LIST LENGTH: " +  users.size());
        Collections.sort(users, Comparator.comparing(User::getFollowersCount));


        List<String> friendsList = new ArrayList<>();
        for(int i =0; i < users.size(); i++){
            friendsList.add(users.get(i).getScreenName());
            System.out.println(users.get(i).getScreenName());
            System.out.println(users.get(i).getFollowersCount());
        }
        return friendsList;
    }

//    public List<TwitterRanking> getRankingList(String handle) throws TwitterException {
//        System.out.println("getting the ranking list...");
//        System.out.println(handle);
//        long cursor = -1;
////        List<TwitterRanking> twitterRankingList = new ArrayList<>();
////        List<User> users = twitter.getFriendsList(handle, -1);
////        users.add(twitter.showUser(handle));
////        List<User> users;
//        PagableResponseList<User> users;
//        List<TwitterRanking> twitterRankingList = new ArrayList<>();
//        int incrementor = 0;
//        do {
//            System.out.println("cursor.... " + cursor);
//            System.out.println("incrementor: " + incrementor);
//            incrementor += 1;
//            users = twitter.getFriendsList(handle, -1);
//            for(int i =0; i < users.size(); i++){
//                TwitterRanking tR = new TwitterRanking();
//                tR.setFollowerCount(users.get(i).getFollowersCount());
//                tR.setName(users.get(i).getScreenName());
//                System.out.println(users.get(i).getScreenName());
//                System.out.println(users.get(i).getFollowersCount());
//                twitterRankingList.add(tR);
//            }
//        } while ((cursor = users.getNextCursor()) != 0);
//        users.add(twitter.showUser(handle));
//        System.out.println("USERS FRIENDS LIST LENGTH: " +  users.size());
//        Collections.sort(users, Comparator.comparing(User::getFollowersCount));
//
//
////        for(int i =0; i < users.size(); i++){
////            TwitterRanking tR = new TwitterRanking();
////            tR.setFollowerCount(users.get(i).getFollowersCount());
////            tR.setName(users.get(i).getScreenName());
////            System.out.println(users.get(i).getScreenName());
////            System.out.println(users.get(i).getFollowersCount());
////            twitterRankingList.add(tR);
////        }
//        return twitterRankingList;
//    }

    public List<TwitterRanking> getRankingList(String handle) throws TwitterException {
        System.out.println("getting the ranking list...");
        System.out.println(handle);
        long cursor = -1;
        List<TwitterRanking> twitterRankingList = new ArrayList<>();
        List<User> users = twitter.getFriendsList(handle, -1);
        users.add(twitter.showUser(handle));
        System.out.println("USERS FRIENDS LIST LENGTH: " +  users.size());
        Collections.sort(users, Comparator.comparing(User::getFollowersCount));


        for(int i =0; i < users.size(); i++){
            TwitterRanking tR = new TwitterRanking();
            tR.setFollowerCount(users.get(i).getFollowersCount());
            tR.setName(users.get(i).getScreenName());
            System.out.println(users.get(i).getScreenName());
            System.out.println(users.get(i).getFollowersCount());
            twitterRankingList.add(tR);
        }
        return twitterRankingList;
    }

    public SecureTwitter getTwitterTokens(String id){
        SecureTwitter searchedSecure = twitterRepository.findSecureTwitterByUserId(Integer.valueOf(id));
        if(searchedSecure != null){
            setTwitterTokens(searchedSecure);
            return searchedSecure;
        }
        SecureTwitter nullSecure = new SecureTwitter();

        return nullSecure;
    }

    /**
     * Makes the api call to post a tweet to the user's twitter page.
     * @param textStatus is the content (text) of the tweet to be posted.
     * @return
     * @throws TwitterException
     */
    public Tweet postUserStatusWithContent(String textStatus, File file) throws TwitterException, IOException {

        System.out.println("IN THE POST USER STATUS  with content...!");
        var statusUpdate = new StatusUpdate(textStatus);
//        f = new File("src/download.jpg"); //image file path
        System.out.println(file.getName());
        statusUpdate.setMedia(file);
        Status newStatus = twitter.updateStatus(statusUpdate);
//        System.out.println(newStatus.getText());


//        Status newStatus = twitter.updateStatus(textStatus);
        Tweet newTweet = new Tweet();
        newTweet.setTweetCreatedBy(newStatus.getUser().getScreenName());
        newTweet.setTweetText(textStatus);
        System.out.println(newStatus.getText());
        return newTweet;
    }
}
