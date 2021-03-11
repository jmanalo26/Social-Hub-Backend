package TheBoyz.TheBoyz.web.service;
import TheBoyz.TheBoyz.data.model.*;
import com.restfb.*;
import com.restfb.scope.FacebookPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.*;
import com.restfb.types.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class FBService {

    //Because we dont have the OAuth setup yet, we'll have to pull this token from Facebook Graph API explorer
    //using the Jorge account
    private static String accessToken;// = "EAAqDduci0a0BAMglLPJxNkNc3wy0uHHpRr7RGwE6jTBR94bBK3AjDbGEGE3XpSpDAesqFjWeVM8TLxeALEWQqm0m06nXk9Pb0v7gMqvx0ZCY4ZAGAqmEXMMcZCKZAxibCbQxJrZBWRLPJdDTJASDWeFghr1DqJXwPzZBfbZB6DsA9gUHq8nqrpaZASyvZC0OxUOuT5tB2Mnmsh8nUZAvZACs3f2zzhfeZCqP4BhHqyVsbbZAvHgZDZD";
    public static DefaultFacebookClient facebookClient;// = new DefaultFacebookClient(accessToken, Version.LATEST);;
    private static String appID = "2959296474304941";
    private static String appSecret = "7195fbe6d20da5b6ad187dbd14c83784";
    private static String redirectURL = "http://localhost:4200/facebook";
    private static String fbCode;

    public static User user;// = facebookClient.fetchObject("me", User.class);


    public static DefaultFacebookClient getFacebookClient() {
        return facebookClient;
    }

    /**
     * Login Method, NEED VERIFICATION CODE
     * @return login dialog URL
     */
    public static FacebookLogin login(){
        facebookClient = new DefaultFacebookClient(Version.LATEST);
        ScopeBuilder scope = new ScopeBuilder();
        scope.addPermission(FacebookPermissions.PUBLIC_PROFILE);
        scope.addPermission(FacebookPermissions.USER_FRIENDS);
        scope.addPermission(FacebookPermissions.USER_BIRTHDAY);
        scope.addPermission(FacebookPermissions.EMAIL);
        scope.addPermission(FacebookPermissions.USER_POSTS);
        scope.addPermission(FacebookPermissions.PAGES_SHOW_LIST);
        scope.addPermission(FacebookPermissions.USER_MANAGED_GROUPS);
        scope.addPermission(FacebookPermissions.USER_PHOTOS);
        String login = facebookClient.getLoginDialogUrl(appID, redirectURL, scope, Parameter.with("fields", "name"));
        FacebookLogin l = new FacebookLogin();
        l.setLoginDialogURL(login);
        return l;
    }

    public static void getAccessToken(String code){
        fbCode = code;
        FacebookClient.AccessToken a = facebookClient.obtainUserAccessToken(appID, appSecret, redirectURL, code);
        accessToken = a.getAccessToken();
        System.out.println("Access code is now: " + accessToken);
        facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);
        user = facebookClient.fetchObject("me", User.class);
    }

    public static FacebookUser getUser() {
        System.out.println("Service getUser method called, Name:  " + user.getName());
        FacebookUser f = new FacebookUser();
        f.setFacebookName(user.getName());
        //Will have to make new ID variable
        f.setFacebookID(1);
        f.setFacebookToken(accessToken);
        f.setFacebookDOB(user.getBirthday());
        User email = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "email"));
        User pic = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "picture.type(large)"));
        ProfilePictureSource p = pic.getPicture();
        p.setWidth(500);
        p.setHeight(500);
        f.setFacebookEmail(email.getEmail());
        f.setPhotoURL(p.getUrl());
        System.out.println(f.getPhotoURL());
        return f;
    }

    public static String getUserName(){
        return user.getName();
    }

    public static String getUserID(){
        return user.getId();
    }

    public static String getUserEmail(){
        return user.getEmail();
    }

    public static FacebookPosts getPosts(){
        ArrayList<String> posts = new ArrayList<>();
        Connection<Post> myPost = facebookClient.fetchConnection("me/feed", Post.class);
        for (Post post: myPost.getData()){
            if (post.getMessage() != null) {
                posts.add(post.getMessage());
                posts.add(post.getCreatedTime().toString());
            }
        }
        FacebookPosts feed = new FacebookPosts();
        feed.setPosts(posts);
        return feed;
    }

    public static FacebookPhotos getPhotos(){
        ArrayList<String> photos = new ArrayList<String>();
        ArrayList<String> urls = new ArrayList<String>();
        Connection<Photo> myPhotos = facebookClient.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "picture"), Parameter.with("type", "uploaded"));
        for (Photo p: myPhotos.getData()){
            photos.add(p.getPicture());
        }
        Connection<Photo> myURLs = facebookClient.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "link"), Parameter.with("type", "uploaded"));
        for (Photo p: myURLs.getData()){
            urls.add(p.getLink());
        }
        FacebookPhotos ph = new FacebookPhotos();
        ph.setPhotos(photos);
        ph.setPhotoURLs(urls);
        return ph;
    }

    public static FacebookPages getPages(){
        ArrayList<String> pages = new ArrayList<String>();
        ArrayList<String> urls = new ArrayList<String>();
        Connection<Account> myAccounts = facebookClient.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "name"));
        for (Account a: myAccounts.getData()){
            pages.add(a.getName());
        }
        Connection<Account> myAccounts2 = facebookClient.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "link"));
        for (Account a: myAccounts2.getData()){
            urls.add(a.getLink());
        }
        FacebookPages fp = new FacebookPages();
        fp.setPageNames(pages);
        fp.setPageURLs(urls);
        return fp;
    }

}
