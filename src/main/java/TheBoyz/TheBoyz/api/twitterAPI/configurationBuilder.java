package TheBoyz.TheBoyz.api.twitterAPI;

//import com.jayway.jsonpath.Configuration;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class configurationBuilder {

//    static Twitter twitter;
//    static TwitterFactory tf;

    public static void main(String[] args) throws TwitterException {

//        Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-pXydTnS7C4TlMA5pXgwFlvRyfu3Uxl")
                .setOAuthAccessTokenSecret("QirzXP0zM8CvPuHGrFYa0J473ppyOneWCqSwVEpt1zaLA");

           TwitterFactory tf = new TwitterFactory(cb.build());
          Twitter twitter = tf.getInstance();
//        Status status = twitter.updateStatus("creating baeldung API");

        List<Status> status = twitter.getHomeTimeline();
//        for(Status st: status){
//            System.out.println(st.getUser().getName() + "__________" + st.getText());
//        }
        Status newStatus = twitter.updateStatus("This tweet created and sent through IntelliJ");
        System.out.println(newStatus.getText());
        System.out.println(newStatus.getUser());
        System.out.println(newStatus.getFavoriteCount());


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
