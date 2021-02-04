package TheBoyz.TheBoyz.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;
import twitter4j.User;

@Slf4j
@Service
public class TwitterService {


    public Integer getFollowerCount() throws TwitterException {
        System.out.println("In teh get follower count method");
//            Twitter twitter = new TwitterFactory().getInstance();
        User user = twitter.showUser("SocialHubClub");
        System.out.println("This is the follower count: " + user.getFollowersCount());
        System.out.println("This is the favorites count: " + user.getFavouritesCount());
        System.out.println("This is the URL: " + user.getURL());
        if (user.getStatus() != null) {
            System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
        } else {
            // the user is protected
            System.out.println("@" + user.getScreenName());
        }
        return -1;
    }
}
