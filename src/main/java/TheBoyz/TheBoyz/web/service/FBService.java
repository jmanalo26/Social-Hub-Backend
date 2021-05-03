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
    private static String redirectURL = "http://localhost:4200/dashboard";
    private static String fbCode;

    public static User user;// = facebookClient.fetchObject("me", User.class);
    public static ArrayList<String> pages;
    public static ArrayList<String> ids;
    public static String currentPage;
    public static Boolean loggedIn;


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
        scope.addPermission(FacebookPermissions.PAGES_READ_ENGAGEMENT);
        scope.addPermission(FacebookPermissions.PAGES_MANAGE_POSTS);
        //scope.addPermission(FacebookPermissions.PUBLISH_TO_GROUPS);
        String login = facebookClient.getLoginDialogUrl(appID, redirectURL, scope, Parameter.with("fields", "name"));
        String logout = facebookClient.getLogoutUrl(redirectURL);
        FacebookLogin l = new FacebookLogin();
        l.setLoginDialogURL(login);
        l.setLogoutDialogURL(logout);
        return l;
    }

    public static void getAccessToken(String code){
        fbCode = code;
        FacebookClient.AccessToken a = facebookClient.obtainUserAccessToken(appID, appSecret, redirectURL, code);
        accessToken = a.getAccessToken();
        System.out.println("Access code is now: " + accessToken);
        facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);
        user = facebookClient.fetchObject("me", User.class);
        loggedIn = true;
    }

    public static Boolean checkLogin(){
        return loggedIn;
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
        Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
        f.setFriendCount(myFriends.getTotalCount().toString());
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
//        Connection<Photo> myPhotos = facebookClient.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "picture"), Parameter.with("type", "uploaded"));
//        for (Photo p: myPhotos.getData()){
//            photos.add(p.getPicture());
//        }
        Connection<Photo> myPhotos = facebookClient.fetchConnection("me/photos", Photo.class, Parameter.with("fields", "images"), Parameter.with("type", "uploaded"));
        for (Photo p: myPhotos.getData()){
            photos.add(p.getImages().get(0).getSource());
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

    public static FacebookVideos getVideos(){
        ArrayList<String> vids = new ArrayList<>();
        ArrayList<String> tb = new ArrayList<>();
        FacebookClient fb = new DefaultFacebookClient(accessToken, appSecret, Version.LATEST);
        Connection<Video> videos = fb.fetchConnection("me/videos", Video.class,  Parameter.with("fields", "source"), Parameter.with("type", "uploaded"));
        for (Video v: videos.getData()){
            System.out.println(v.getSource());
            vids.add(v.getSource());
        }

        Connection<Video> v2 = fb.fetchConnection("me/videos", Video.class,  Parameter.with("fields", "picture"), Parameter.with("type", "uploaded"));
        for (Video v: v2.getData()){
            tb.add(v.getPicture());
        }

        FacebookVideos fbVids = new FacebookVideos();
        fbVids.setSources(vids);
        fbVids.setThumbnails(tb);
        return fbVids;
    }

    public static FacebookPages getPages(){
        pages = new ArrayList<>();
        ids = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<String>();
        ArrayList<String> fans = new ArrayList<>();
        Connection<Account> myAccounts = facebookClient.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "name"));
        for (Account a: myAccounts.getData()){
            pages.add(a.getName());
            ids.add(a.getId());
        }
        Connection<Account> myAccounts2 = facebookClient.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "link"));
        for (Account a: myAccounts2.getData()){
            urls.add(a.getLink());
        }
        Connection<Account> myPhotos = facebookClient.fetchConnection("me/accounts", Account.class, Parameter.with("fields", "fan_count"));
        for (Account p: myPhotos.getData()){
            fans.add(p.getFanCount().toString());
        }

        ArrayList<String> lPages = new ArrayList<>();
        ArrayList<String> lLinks = new ArrayList<>();
        ArrayList<String> f = new ArrayList<>();
        Connection<Account> likedPages = facebookClient.fetchConnection("me/likes", Account.class, Parameter.with("fields", "name"));
        for (Account l :likedPages.getData()){
            lPages.add(l.getName());
        }
        Connection<Account> likedLinks = facebookClient.fetchConnection("me/likes", Account.class, Parameter.with("fields", "link"));
        for (Account l :likedLinks.getData()){
            lLinks.add(l.getLink());
        }
        Connection<Account> count = facebookClient.fetchConnection("me/likes", Account.class, Parameter.with("fields", "fan_count"));
        for (Account l :count.getData()){
            f.add(l.getFanCount().toString());
        }

        FacebookPages fp = new FacebookPages();
        fp.setPageNames(pages);
        fp.setPageURLs(urls);
        fp.setPageFans(fans);
        fp.setLikedNames(lPages);
        fp.setLikedLinks(lLinks);
        fp.setFanCounts(f);
        return fp;
    }

    public static FacebookPagePosts getPagePosts(){
        System.out.println(currentPage);
        currentPage = currentPage.replace("\"", "");
        ArrayList<String> posts = new ArrayList<>();
        ArrayList<String> postTimes = new ArrayList<>();
        int pageIndex = 0;
        for (String p: pages){
            if (currentPage.equals(p)){
                System.out.println("P: " + p);
                pageIndex = pages.indexOf(currentPage);
            }
        }

        String pageID = ids.get(pageIndex);
        System.out.println("PAGE: " + pages.get(pageIndex));
        System.out.println("PAGE ID: " + pageID);
        Connection<Post> pagePosts = facebookClient.fetchConnection(pageID +"/feed", Post.class);
        for (Post p: pagePosts.getData()){
            posts.add(p.getMessage());
            postTimes.add(p.getCreatedTime().toString());
        }

        FacebookPagePosts fpp = new FacebookPagePosts();
        fpp.setPagePosts(posts);
        System.out.println(posts.get(0));
        fpp.setTimes(postTimes);
        return fpp;
    }

    public static void publishPost(String name, String msg){
        int pageIndex = 0;
        ArrayList<String> pageNames = new ArrayList<>();
        ArrayList<String> pageIDs = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        Connection<Account> myAccounts = facebookClient.fetchConnection("me/accounts", Account.class);
        for (Account a: myAccounts.getData()){
            pageNames.add(a.getName());
            pageIDs.add(a.getId());
            tokens.add(a.getAccessToken());
        }

        String[] pages=  name.split(",");
        for (String p: pages){
            for (String n : pageNames){
                if (n.equals(p)){
                    System.out.println("Index found");
                    pageIndex = pageNames.indexOf(n);
                    System.out.println(pageIndex);
                    FacebookClient f = new DefaultFacebookClient(tokens.get(pageIndex), Version.LATEST);
                    f.publish(pageIDs.get(pageIndex) + "/feed", FacebookType.class, Parameter.with("message", msg));
                    System.out.println("Message published to " + pageNames.get(pageIndex));
                }
            }
        }
        /**
        for (String n: pageNames){
            if (n.equals(name)){
                System.out.println("Index found");
                pageIndex = pageNames.indexOf(n);
                System.out.println(pageIndex);
            }
        }

        //GET PAGE ACCESS TOKEN AND PUT IN CONNECTION BEFORE /FEED
        FacebookClient f = new DefaultFacebookClient(tokens.get(pageIndex), Version.LATEST);
        f.publish(pageIDs.get(pageIndex) + "/feed", FacebookType.class, Parameter.with("message", msg));
        System.out.println("Message published to page");
         **/
    }

}
