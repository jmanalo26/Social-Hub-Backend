package TheBoyz.TheBoyz.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

@Slf4j
@Service
public class TwitterService {

    TwitterFactory tf;
    Twitter twitter;
    public TwitterService(){
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
}
