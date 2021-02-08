package TheBoyz.TheBoyz.api.twitterAPI;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class TwitterMethods {

    TwitterApiConnection configurationBuilder;
    TwitterFactory tf;
    Twitter twitter;

    public TwitterMethods(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-cB5cT5b401gAmv376yeJ7wHVfaKb1p")
                .setOAuthAccessTokenSecret("o7rkWS860O59I93JxPpS0oG2UTgDQClQeKFlUW7Mz8yY5");

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
    public void getFollowers() throws TwitterException {

        long id = twitter.getId();
        twitter.getFollowersList(1,2);
    }

    public void getTimeline() throws TwitterException {

//        List<Status> status = twitter.getHomeTimeline();
        List<String> timelineList = twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        for (int i = 0; i < timelineList.size(); i++) {
            System.out.println(timelineList.get(i));
        }

    }

    public void getFavorites() throws TwitterException {
        List<Status> userFavorites = twitter.getFavorites();

        System.out.println();
        System.out.println("this is the number of favorites: " + userFavorites.size());
        for (Status stat : userFavorites) {
            System.out.println(stat.getFavoriteCount());
        }
    }

    public void getFollowerCount() throws TwitterException {
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
    }
    public void getId() throws TwitterException {
        long Id = twitter.getId();
        System.out.println("this is the ID: " + Id);
    }

    public void showUser() throws TwitterException {
        System.out.println("In the show user method" +
                "****************");
//            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.showUser("SocialHubClub");

            if (user.getStatus() != null) {
                System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            } else {
                // the user is protected
                System.out.println("@" + user.getScreenName());
            }
        }

    public void searchUser() throws TwitterException {
        System.out.println("In the search user method");
        int page = 1;
        ResponseList<User> users;
        do {
            users = twitter.searchUsers("SocialHubClub", page);
            for (User user : users) {
                if (user.getStatus() != null) {
                    System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                } else {
                    // the user is protected
                    System.out.println("@" + user.getScreenName());
                }
            }
            page++;
        } while (users.size() != 0 && page < 50);
        System.out.println("done.");
        System.exit(0);
    }

    public void lookUpUser(String userSearched) throws TwitterException {
        System.out.println("In the search user method");
        ResponseList<User> users = twitter.lookupUsers("SocialHubClub".split(","));
        for (User user : users) {
            if (user.getStatus() != null) {
                System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            } else {
                // the user is protected
                System.out.println("@" + user.getScreenName());
            }
        }
        System.out.println("Successfully looked up users [" + userSearched + "].");
    }
}
