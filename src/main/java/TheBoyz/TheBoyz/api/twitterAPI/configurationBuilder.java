package TheBoyz.TheBoyz.api.twitterAPI;

//import com.jayway.jsonpath.Configuration;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;


public class configurationBuilder {

    static Twitter twitter;
    static TwitterFactory tf;

    public static void main(String[] args) throws TwitterException {

//        Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eIU7C0LHUKJQvjVdXDwA9jHZs")
                .setOAuthConsumerSecret("vnULF3JtDalYGqKd8gcWqvMQKNmwIurcFvDIHserRo1V8bGFtD")
                .setOAuthAccessToken("1355356841413406720-cB5cT5b401gAmv376yeJ7wHVfaKb1p")
                .setOAuthAccessTokenSecret("o7rkWS860O59I93JxPpS0oG2UTgDQClQeKFlUW7Mz8yY5");

           TwitterFactory tf = new TwitterFactory(cb.build());
          Twitter twitter = tf.getInstance();
//          getFriendsIds(tf, twitter);
        User user = twitter.showUser("SocialHubClub");
        System.out.println(user.getStatus().getText());
//        try {
////            Log.i("act twitter...........", "ModifiedCustomTabBarActivity.class");
//            // final JSONArray twitterFriendsIDsJsonArray = new JSONArray();
////            IDs ids =twitter.getFriendsIDs(-1);// ids
//            IDs ids =twitter.getFriendsIDs("SocialHubClub",-1);
//
//            // for (long id : ids.getIDs()) {
//            do {
//                for (long id : ids.getIDs()) {
//
//
//                    String ID = "followers ID #" + id;
//                    String[] firstname = ID.split("#");
//                    String first_Name = firstname[0];
//                    String Id = firstname[1];
//                    System.out.println(ID);
//                    System.out.println(firstname);
//                    System.out.println(first_Name);
//                    System.out.println(id);
////                    Log.i("split...........", first_Name + Id);
//
//                    String Name = twitter.showUser(id).getName();
//                    String screenname = twitter.showUser(id).getScreenName();
//                    System.out.println(Name);
//                    System.out.println(screenname);
//
//
//                    //            Log.i("id.......", "followers ID #" + id);
//                    //          Log.i("Name..", mTwitter.mTwitter.showUser(id).getName());
//                    //          Log.i("Screen_Name...", mTwitter.mTwitter.showUser(id).getScreenName());
//                    //          Log.i("image...", mTwitter.mTwitter.showUser(id).getProfileImageURL());
//
//
//                }
//            } while (ids.hasNext());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        twitter.getfoll
//        Page<User> user2 = (Page<User>) twitter.getFollowersList("SocialHubClub", 1, 1);
//        System.out.println(user2.);
//        ResponseList<Status> userTimeline = twitter.getUserTimeline("SocialHubClub");
//        System.out.println("This is the size: " + userTimeline.size());
//        for(int i =0; i < userTimeline.size(); i++){
//            System.out.println(userTimeline.get(i).getText());
//            System.out.println(userTimeline.get(i).getUser().getName());
//            System.out.println(userTimeline.get(i).getUser().getScreenName());
//            System.out.println(userTimeline.get(i).getRetweetCount());
//            System.out.println(userTimeline.get(i).getFavoriteCount());
//            System.out.println(userTimeline.get(i).getCreatedAt());
////            System.out.println(userTimeline.get(i).getUser().getStatus().getText().toString());
//            System.out.println();
//
//        }

        ResponseList<User> userFollowerList = twitter.getFollowersList("SocialHubClub", -1, 1);
        System.out.println("THE SIZE OF THE FOLLOWER LIST");
        System.out.println(userFollowerList.size());
        for(int i =0; i< userFollowerList.size(); i++){
            userFollowerList.get(i).getName();
        }

       IDs ids = twitter.getFriendsIDs("SocialHubClub", -1);
        System.out.println("THE LENGTH OF THE FRIENDS IDS");
        System.out.println(ids.getIDs().length);
        for(int i =0; i < ids.getIDs().length; i++){
            System.out.println(ids.getIDs());
            System.out.println("ID: " + ids.getIDs()[i]);
            System.out.println("TWITTER SHOW USER GET ID: " + twitter.showUser(ids.getIDs()[i]));
            System.out.println("SCREEN NAME: " + twitter.showUser(ids.getIDs()[i]).getScreenName());
//            System.out.println(twitter.showUser(ids.getIDs()[i]).getName());


        }

        List<User> users = twitter.getFriendsList("SocialHubClub", -1);
        System.out.println("USERS FRIENDS LIST LENGTH: " +  users.size());

        for(int i =0; i < users.size(); i++){
            System.out.println(users.get(i).getScreenName());
            String friendScreenName = users.get(i).getScreenName();

            System.out.println(users.get(i).getName());
            System.out.println(users.get(i).getFollowersCount());
            System.out.println(users.get(i).getStatus().getText());
            System.out.println(users.get(i).getStatus().getRetweetCount());
            System.out.println(users.get(i).getStatus().getFavoriteCount());
            System.out.println(users.get(i).getFavouritesCount());
            System.out.println("friends count: " + users.get(i).getFriendsCount());
            System.out.println("followers count: " + users.get(i).getFollowersCount());
            System.out.println();

//            ResponseList<Status> friendTimeline  = twitter.getUserTimeline(friendScreenName);

        }
//        do
//        {
//            for (long i : ids.getIDs())
//            {
//                System.out.println("follower ID #" + i);
//                System.out.println(twitter.showUser(i).getName());
//            }
//        }while(ids.hasNext());







//        Status status = twitter.updateStatus("creating baeldung API");

//        List<Status> status = twitter.getHomeTimeline();
//        List<Status> userFavorites = twitter.getFavorites();
////       ID followers = twitter.getFollowersList();
////        for(Status st: status){
////            System.out.println(st.getUser().getName() + "__________" + st.getText());
////        }
//        System.out.println();
//        System.out.println("this is the number of favorites: " + userFavorites.size());
//        for(Status stat: userFavorites){
//            System.out.println(stat.getFavoriteCount());
//        }
//        System.out.println(userFavorites.get(0).getText());
//        Status newStatus = twitter.updateStatus("This tweet created and sent through IntelliJ");
//        System.out.println(newStatus.getText());
//        System.out.println(newStatus.getUser());
//        System.out.println(newStatus.getFavoriteCount());

//       List<String> timelineList = twitter.getHomeTimeline().stream()
//                .map(item -> item.getText())
//                .collect(Collectors.toList());
//        System.out.println(timelineList.size());
//       for(int i = 0; i < timelineList.size(); i++){
//           System.out.println(timelineList.get(i));
//       }
//       String statusMessage = createTweet("generate");
//        System.out.println(("this is the status message"));
//        System.out.println(statusMessage);
    }



    private static void getFriendsIds(TwitterFactory tf, Twitter twitter) {
        try {
//            Log.i("act twitter...........", "ModifiedCustomTabBarActivity.class");
            // final JSONArray twitterFriendsIDsJsonArray = new JSONArray();
//            IDs ids =twitter.getFriendsIDs(-1);// ids
            IDs ids =twitter.getFriendsIDs("SocialHubClub",-1);

            // for (long id : ids.getIDs()) {
            do {
                for (long id : ids.getIDs()) {


                    String ID = "followers ID #" + id;
                    String[] firstname = ID.split("#");
                    String first_Name = firstname[0];
                    String Id = firstname[1];
                    System.out.println(ID);
                    System.out.println(firstname);
                    System.out.println(first_Name);
                    System.out.println(id);
//                    Log.i("split...........", first_Name + Id);

                    String Name = twitter.showUser(id).getName();
                    String screenname = twitter.showUser(id).getScreenName();
                    System.out.println(Name);
                    System.out.println(screenname);


                    //            Log.i("id.......", "followers ID #" + id);
                    //          Log.i("Name..", mTwitter.mTwitter.showUser(id).getName());
                    //          Log.i("Screen_Name...", mTwitter.mTwitter.showUser(id).getScreenName());
                    //          Log.i("image...", mTwitter.mTwitter.showUser(id).getProfileImageURL());


                }
            } while (ids.hasNext());

        } catch (Exception e) {
            e.printStackTrace();
        }
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

//    TwitterFactory twf = new TwitterFactory();
//    Twitter twitter = twf.getInstance();
//twitter.setOAuthConsumer("key", "secret"); //"key" and "secret" are
//        off course replaced with valid values
//
//        String token = //retrieve token from the database
//        String tokenSecret = //retrieve tokenSecret from the database
//        AccessToken accessToken = new AccessToken(token, tokenSecret);
//        twitter.setOAuthAccessToken(accessToken);
