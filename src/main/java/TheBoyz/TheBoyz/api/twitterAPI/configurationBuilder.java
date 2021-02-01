package TheBoyz.TheBoyz.api.twitterAPI;

//import com.jayway.jsonpath.Configuration;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;


public class configurationBuilder {


    public static void main(String[] args) throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-cB5cT5b401gAmv376yeJ7wHVfaKb1p")
                .setOAuthAccessTokenSecret("o7rkWS860O59I93JxPpS0oG2UTgDQClQeKFlUW7Mz8yY5");

           TwitterFactory tf = new TwitterFactory(cb.build());
          Twitter twitter = tf.getInstance();


        List<Status> status = twitter.getHomeTimeline();
        List<Status> userFavorites = twitter.getFavorites();
//       ID followers = twitter.getFollowersList();
//        for(Status st: status){
//            System.out.println(st.getUser().getName() + "__________" + st.getText());
//        }
        System.out.println();
        System.out.println("this is the number of favorites: " + userFavorites.size());
        for(Status stat: userFavorites){
            System.out.println(stat.getFavoriteCount());
        }
        System.out.println(userFavorites.get(0).getText());
//        Status newStatus = twitter.updateStatus("This tweet created and sent through IntelliJ");
//        System.out.println(newStatus.getText());
//        System.out.println(newStatus.getUser());
//        System.out.println(newStatus.getFavoriteCount());

        List<String> timelineList = twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
        System.out.println(timelineList.size());
        for(int i = 0; i < timelineList.size(); i++){
            System.out.println(timelineList.get(i));
        }
//       String statusMessage = createTweet("generate");
//        System.out.println(("this is the status message"));
//        System.out.println(statusMessage);
    }

//    public static String createTweet(String tweet) throws TwitterException {
//        Twitter twitter = tf.getInstance();
////        Twitter twitter = getTwitterinstance();
//
//        Status status = twitter.updateStatus("Created this tweet in IntelliJ :)");
//        System.out.println("status: " + status);
//        return status.getText();
//    }
}
