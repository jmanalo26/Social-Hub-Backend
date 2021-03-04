//package TheBoyz.TheBoyz.api.FacebookAPI;
//import TheBoyz.TheBoyz.data.service.FacebookService;
//import TheBoyz.TheBoyz.web.service.FBService;
//import com.restfb.*;
//import com.restfb.scope.FacebookPermissions;
//import com.restfb.scope.ScopeBuilder;
//import com.restfb.types.Post;
//import com.restfb.types.User;
//
///**
// * IGNORE THIS CLASS, THIS IS FOR TESTING PURPOSES ONLY
// */
//public class RestFB {
//
//    private static String appID = "2959296474304941";
//    private static String appSecret = "7195fbe6d20da5b6ad187dbd14c83784";
//    private static String redirectURI = "https://www.facebook.com/connect/login_success.html#";
//    /**
//     * Main application
//     * @param args Args
//     */
//    public static void main(String[] args){
//        String accessToken = "EAAqDduci0a0BANuTAZCCDVTkMfe70kYCfV0gtBeKl6TJcJzZBIzGbeCGemUS4qc7VErSqmZC2RW05xPapn8pZALvAtlp2LZBd2utzbadQQkmwrZAZCxdFZCuwTkZChMl1pYohUE44YVdgGDZAjIGj7ZCqq7RvpfIoOkkhmeHbyZC9U2LXNk9uibSM91G7wj2EOwqy75nZBnZBLPzVMTZB8UnlTaGIJvxWYsLVRPz42whISsVdEQiQZDZD";
//        getUser();
//        //FacebookClient.AccessToken a = getAccessToken();
//        //System.out.println(a);
//    }
//
//    public static void logIn(String redirectURI, String appID, String appSecret, FacebookClient f) {
//
//        ScopeBuilder scopeBuilder = new ScopeBuilder();
//        scopeBuilder.addPermission(FacebookPermissions.PUBLIC_PROFILE);
//        scopeBuilder.addPermission(FacebookPermissions.USER_FRIENDS);
//        scopeBuilder.addPermission(FacebookPermissions.USER_BIRTHDAY);
//        scopeBuilder.addPermission(FacebookPermissions.EMAIL);
//        scopeBuilder.addPermission(FacebookPermissions.USER_POSTS);
//
//        String loginDialogURLString = f.getLoginDialogUrl(appID,
//                redirectURI, scopeBuilder);
//        //FacebookClient.AccessToken at = f.obtainUserAccessToken(appID, appSecret, redirectURI, <verification-code>);
//    }
//
//
//   // public static FacebookClient.AccessToken getAccessToken(){
//       // WebRequestor wr = new DefaultWebRequestor();
//        //WebRequestor.Response accessTokenResponse = wr.executeGet(
//        //        "https://graph.facebook.com/oauth/access_token?client_id=" + appID + "&redirect_uri=" + redirectURI
//         //               + "&client_secret=" + appSecret + "&code=" + code);
//
//        //return DefaultFacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
//    //}
//
//    /**
//     * Given the access token, retrieve logged in user's information
//     * NEED TO LOOK INTO GETTING USER ACCESS TOKEN
//     */
//    public static void getUser(){
//        DefaultFacebookClient facebookClient = new DefaultFacebookClient(Version.LATEST);
//        ScopeBuilder scope = new ScopeBuilder();
//        scope.addPermission(FacebookPermissions.PUBLIC_PROFILE);
//        scope.addPermission(FacebookPermissions.EMAIL);
//        String login = facebookClient.getLoginDialogUrl(appID, redirectURI, scope, Parameter.with("fields", "name"));
//        System.out.println("This is the loginURI");
//        System.out.println(login);
//
//        /**
//        facebookClient.obtainUserAccessToken(appID, appSecret, redirectURI, 0);
//        User user = facebookClient.fetchObject("me", User.class);
//        System.out.println("User Name: " + user.getName());
//        System.out.println("ID: " + user.getId());
//
//        getEmail(user, facebookClient);
//        getLocation(user, facebookClient);
//        getBirthday(user, facebookClient);
//        getFriendsList(facebookClient);
//        getPosts(facebookClient);
//         **/
//    }
//
//    /**
//     * Retrieve User Email
//     * @param user User entity object
//     * @param fb Facebook Client with User access token
//     */
//    public static void getEmail(User user, FacebookClient fb){
//        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "email"));
//        System.out.println("Email: " + user.getEmail());
//    }
//
//    /**
//     * Get User Location
//     * @param user User entity object
//     * @param fb Facebook Client with User access token
//     */
//    public static void getLocation(User user, FacebookClient fb){
//        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "location"));
//        System.out.println("Location: " + user.getLocation().getName());
//        System.out.println("Location ID: " + user.getLocation().getId());
//    }
//
//    /**
//     * Get User Birthday
//     * @param user User entity object
//     * @param fb Facebook Client with User access token
//     */
//    public static void getBirthday(User user, FacebookClient fb){
//        user = fb.fetchObject(user.getId(), User.class, Parameter.with("fields", "birthday"));
//        System.out.println("Birthday: " + user.getBirthday());
//    }
//
//    /**
//     * Get User Friends list, this will only obtain friends associated with our app.
//     * @param fb Facebook Client with User access token
//     */
//    public static void getFriendsList(FacebookClient fb){
//        Connection<User> myFriends = fb.fetchConnection("me/friends", User.class);
//        for (User friend: myFriends.getData()){
//            System.out.println("Friend Name: " + friend.getName());
//            System.out.println("Friend ID: " + friend.getId());
//        }
//    }
//
//    /**
//     * Get User Friends list, this will only obtain friends associated with our app.
//     * @param fb Facebook Client with User access token
//     */
//    public static void getPosts(FacebookClient fb){
//        Connection<Post> myPost = fb.fetchConnection("me/feed", Post.class);
//        for (Post post: myPost.getData()){
//            if (post.getMessage() != null) {
//                System.out.println(post.getMessage());
//            }
//        }
//    }
//
//}
