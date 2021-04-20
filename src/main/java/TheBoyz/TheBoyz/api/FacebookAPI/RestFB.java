package TheBoyz.TheBoyz.api.FacebookAPI;
import TheBoyz.TheBoyz.data.model.FacebookPosts;
import com.restfb.*;
import com.restfb.scope.FacebookPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.*;
import static com.restfb.logging.RestFBLogger.CLIENT_LOGGER;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IGNORE THIS CLASS, THIS IS FOR TESTING PURPOSES ONLY
 */
public class RestFB extends DefaultFacebookClient{

    private static String appID = "2959296474304941";
    private static String appSecret = "7195fbe6d20da5b6ad187dbd14c83784";
    private static String redirectURI = "http://localhost:4200";
    /**
     * Main application
     * @param args Args
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        String accessToken = "EAAqDduci0a0BAPbcWRcqMg0ZCZB8GnS97e4q4eoZAZBjWWwNwFfoAF8RI8jweDjzOeDb4mEwm0XOzwYZA8wP7ZBinJFDPSRnCV3pGxWIcNlGcOM6ZBLx5zBgGngdcvZCvWPYBIc8aScSd869a0IeqxrJThWb8kRyudzQlUnZCTsUqemO7v5NH42RQn62msUGSmkIZBNLqh1XdiReCQJU2ZBzl1DAYH0fysbpoX7BTkjvwdtYAZDZD";
       FacebookClient facebookClient = new DefaultFacebookClient(accessToken, appSecret, Version.LATEST);
       String pageID = "101710815360723";
        Connection<Post> pagePosts = facebookClient.fetchConnection(pageID +"/feed", Post.class);
        for (Post p: pagePosts.getData()){
            System.out.println(p.getMessage());
            System.out.println(p.getCreatedTime().toString());
        }
        //logout();
        //getUser();
        /**
        Connection<Post> feed = fb.fetchConnection("101710815360723/feed", Post.class, Parameter.with("limit", 1));

        for (List<Post> feedConnectionPage : feed) {
            for (Post post : feedConnectionPage) {
                System.out.println(post.getMessage());
            }
        }

        Connection<Account> myAccounts = fb.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "name"));
        for (Account a: myAccounts.getData()){
            System.out.println(a.getName() + "; " + a.getId());
        }


        //getPages(fb);
        //start();
        //FacebookClient.AccessToken a = getAccessToken();
        //System.out.println(a);
         **/
    }

    public static void logout(){
        DefaultFacebookClient facebookClient = new DefaultFacebookClient(Version.LATEST);
        ScopeBuilder scope = new ScopeBuilder();
        scope.addPermission(FacebookPermissions.PUBLIC_PROFILE);
        scope.addPermission(FacebookPermissions.USER_FRIENDS);
        scope.addPermission(FacebookPermissions.USER_BIRTHDAY);
        scope.addPermission(FacebookPermissions.EMAIL);
        scope.addPermission(FacebookPermissions.USER_POSTS);
        scope.addPermission(FacebookPermissions.PAGES_SHOW_LIST);
        scope.addPermission(FacebookPermissions.USER_MANAGED_GROUPS);
        scope.addPermission(FacebookPermissions.USER_PHOTOS);
        String login = facebookClient.getLoginDialogUrl(appID, redirectURI, scope, Parameter.with("fields", "name"));
        String logout = facebookClient.getLogoutUrl("https://www.google.com/");
        System.out.println(login);
        System.out.println(logout);
    }

    public static void getPages(FacebookClient fb){
        Connection<Photo> myPhotos = fb.fetchConnection("me/likes", Photo.class, Parameter.with("fields", "picture.type(large){url}"));
        System.out.println(myPhotos);
        for (Photo p: myPhotos.getData()){
            System.out.println(p.getPicture());
        }
    }

    public static void getAlbum(FacebookClient fb){
        Connection<Photo> myPhotos = fb.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "link"), Parameter.with("type", "uploaded"));
        for (Photo p: myPhotos.getData()){
            System.out.println(p.getLink());
        }
    }

    public static void logIn(String redirectURI, String appID, String appSecret, FacebookClient f) throws IOException {

        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(FacebookPermissions.PUBLIC_PROFILE);
        scopeBuilder.addPermission(FacebookPermissions.USER_FRIENDS);
        scopeBuilder.addPermission(FacebookPermissions.USER_BIRTHDAY);
        scopeBuilder.addPermission(FacebookPermissions.EMAIL);
        scopeBuilder.addPermission(FacebookPermissions.USER_POSTS);

        String loginDialogURLString = f.getLoginDialogUrl(appID,
                redirectURI, scopeBuilder);
        URL url = new URL(loginDialogURLString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int code = connection.getResponseCode();
        System.out.println(code);
    }


   // public static FacebookClient.AccessToken getAccessToken(){
       // WebRequestor wr = new DefaultWebRequestor();
        //WebRequestor.Response accessTokenResponse = wr.executeGet(
        //        "https://graph.facebook.com/oauth/access_token?client_id=" + appID + "&redirect_uri=" + redirectURI
         //               + "&client_secret=" + appSecret + "&code=" + code);

        //return DefaultFacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
    //}

    /**
     * Given the access token, retrieve logged in user's information
     * NEED TO LOOK INTO GETTING USER ACCESS TOKEN
     */
    public static void getUser() throws IOException, URISyntaxException {
        DefaultFacebookClient facebookClient = new DefaultFacebookClient(Version.LATEST);
        ScopeBuilder scope = new ScopeBuilder();
        scope.addPermission(FacebookPermissions.PUBLIC_PROFILE);
        scope.addPermission(FacebookPermissions.EMAIL);
        String login = facebookClient.getLoginDialogUrl(appID, redirectURI, scope, Parameter.with("fields", "name"));
        System.out.println("This is the loginURI");
        System.out.println(login);
        URL url = new URL(login);
        URLConnection con = url.openConnection();
        System.out.println( "orignal url: " + con.getURL() );
        con.connect();
        System.out.println( "connected url: " + con.getURL() );
        InputStream is = con.getInputStream();
        System.out.println( "redirected url: " + con.getURL() );
        is.close();

        /**
        facebookClient.obtainUserAccessToken(appID, appSecret, redirectURI, 0);
        User user = facebookClient.fetchObject("me", User.class);
        System.out.println("User Name: " + user.getName());
        System.out.println("ID: " + user.getId());

        getEmail(user, facebookClient);
        getLocation(user, facebookClient);
        getBirthday(user, facebookClient);
        getFriendsList(facebookClient);
        getPosts(facebookClient);
         **/
    }

    /**
     * Retrieve User Email
     * @param user User entity object
     * @param fb Facebook Client with User access token
     */
    public static void getEmail(User user, FacebookClient fb){
        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "email"));
        System.out.println("Email: " + user.getEmail());
    }

    /**
     * Get User Location
     * @param user User entity object
     * @param fb Facebook Client with User access token
     */
    public static void getLocation(User user, FacebookClient fb){
        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "location"));
        System.out.println("Location: " + user.getLocation().getName());
        System.out.println("Location ID: " + user.getLocation().getId());
    }

    /**
     * Get User Birthday
     * @param user User entity object
     * @param fb Facebook Client with User access token
     */
    public static void getBirthday(User user, FacebookClient fb){
        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "birthday"));
        System.out.println("Birthday: " + user.getBirthday());
    }

    /**
     * Get User Friends list, this will only obtain friends associated with our app.
     * @param fb Facebook Client with User access token
     */
    public static void getFriendsList(FacebookClient fb){
        Connection<User> myFriends = fb.fetchConnection("me/friends", User.class);
        System.out.println(myFriends.getTotalCount());
        for (User friend: myFriends.getData()){
            System.out.println("Friend Name: " + friend.getName());
            System.out.println("Friend ID: " + friend.getId());
        }
    }

    /**
     * Get User Friends list, this will only obtain friends associated with our app.
     * @param fb Facebook Client with User access token
     */
    public static void getPosts(FacebookClient fb){
        Connection<Post> myPost = fb.fetchConnection("me/feed", Post.class);
        for (Post post: myPost.getData()){
            if (post.getMessage() != null) {
                System.out.println(post.getMessage());
            }
        }
    }

}
