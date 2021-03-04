//package TheBoyz.TheBoyz.web.service;
//import TheBoyz.TheBoyz.data.model.FacebookLogin;
//import TheBoyz.TheBoyz.data.model.FacebookPhotos;
//import TheBoyz.TheBoyz.data.model.FacebookPosts;
//import TheBoyz.TheBoyz.data.model.FacebookUser;
//import com.restfb.*;
//import com.restfb.scope.FacebookPermissions;
//import com.restfb.scope.ScopeBuilder;
//import com.restfb.types.Photo;
//import com.restfb.types.Post;
//import com.restfb.types.ProfilePictureSource;
//import com.restfb.types.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Slf4j
//@Service
//public class FBService {
//
//    //Because we dont have the OAuth setup yet, we'll have to pull this token from Facebook Graph API explorer
//    //using the Jorge account
//    private static String accessToken = "EAAqDduci0a0BAIZBAkSxBcQMRQqblgkWqvsYAi8tLGEss0ILlFbZALZCHsZBZArftYJmG4sJA6tXyWCOnZAcKMqZBswNmsb8O6GQpFg3me4DPxZB8uSUhplnYwu8IkP5RuH85eBGdL6idIRj9mzc3iVZBoyTuiWAOMo54PWZBLiPSYFV7e2ZAZBBjtxvZAywFlcWg9fC7ivZCUjwX3zRkbiAT013y2FoGhkO6STGBpcHpoIvt1DQZDZD";
//    private static final DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);;
//    private static String appID = "2959296474304941";
//    private static String appSecret = "7195fbe6d20da5b6ad187dbd14c83784";
//    private static String redirectURL = "http://localhost:4200/facebook";
//
//    private static final User user = facebookClient.fetchObject("me", User.class);
//
//
//    public static DefaultFacebookClient getFacebookClient() {
//        return facebookClient;
//    }
//
//    /**
//     * Login Method, NEED VERIFICATION CODE
//     * @return login dialog URL
//     */
//    public static FacebookLogin login(){
//        ScopeBuilder scope = new ScopeBuilder();
//        scope.addPermission(FacebookPermissions.PUBLIC_PROFILE);
//        scope.addPermission(FacebookPermissions.USER_FRIENDS);
//        scope.addPermission(FacebookPermissions.USER_BIRTHDAY);
//        scope.addPermission(FacebookPermissions.EMAIL);
//        scope.addPermission(FacebookPermissions.USER_POSTS);
//        String login = facebookClient.getLoginDialogUrl(appID, redirectURL, scope, Parameter.with("fields", "name"));
//        FacebookLogin l = new FacebookLogin();
//        l.setLoginDialogURL(login);
//        return l;
//    }
//
//    public static FacebookUser getUser() {
//        FacebookUser f = new FacebookUser();
//        f.setFacebookName(user.getName());
//        //Will have to make new ID variable
//        f.setFacebookID(1);
//        f.setFacebookToken(accessToken);
//        f.setFacebookDOB(user.getBirthday());
//        User email = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "email"));
//        User pic = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "picture.type(large)"));
//        ProfilePictureSource p = pic.getPicture();
//        p.setWidth(500);
//        p.setHeight(500);
//        f.setFacebookEmail(email.getEmail());
//        f.setPhotoURL(p.getUrl());
//        System.out.println(f.getPhotoURL());
//        return f;
//    }
//
//    public static String getUserName(){
//        return user.getName();
//    }
//
//    public static String getUserID(){
//        return user.getId();
//    }
//
//    public static String getUserEmail(){
//        return user.getEmail();
//    }
//
//    public static FacebookPosts getPosts(){
//        ArrayList<String> posts = new ArrayList<>();
//        Connection<Post> myPost = facebookClient.fetchConnection("me/feed", Post.class);
//        for (Post post: myPost.getData()){
//            if (post.getMessage() != null) {
//                posts.add(post.getMessage());
//                posts.add(post.getCreatedTime().toString());
//            }
//        }
//        FacebookPosts feed = new FacebookPosts();
//        feed.setPosts(posts);
//        return feed;
//    }
//
//    public static FacebookPhotos getPhotos(){
//        ArrayList<String> photos = new ArrayList<String>();
//        Connection<Photo> myPhotos = facebookClient.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "picture"), Parameter.with("type", "uploaded"));
//        for (Photo p: myPhotos.getData()){
//            photos.add(p.getPicture());
//        }
//        FacebookPhotos ph = new FacebookPhotos();
//        ph.setPhotos(photos);
//        return ph;
//    }
//
//}
