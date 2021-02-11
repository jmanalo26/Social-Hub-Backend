package TheBoyz.TheBoyz.web.service;

import TheBoyz.TheBoyz.data.model.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TwitterService {

    TwitterFactory tf;
    Twitter twitter;

    public TwitterService() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-cB5cT5b401gAmv376yeJ7wHVfaKb1p")
                .setOAuthAccessTokenSecret("o7rkWS860O59I93JxPpS0oG2UTgDQClQeKFlUW7Mz8yY5");

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public Integer getFollowerCount() throws TwitterException {
        System.out.println("In teh get follower count method");
//            Twitter twitter = new TwitterFactory().getInstance();
        User user = twitter.showUser("SocialHubClub");
        System.out.println("This is the follower count: " + user.getFollowersCount());
        System.out.println("This is the favorites count: " + user.getFavouritesCount());
        System.out.println("This is the URL: " + user.getURL());
        int followerCount = user.getFollowersCount();
        return followerCount;
//        if (user.getStatus() != null) {
//            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
//        } else {
//            // the user is protected
//            System.out.println("@" + user.getScreenName());
//        }
//        return -1;
    }

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
    public Status getStatus() throws TwitterException {
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

}
