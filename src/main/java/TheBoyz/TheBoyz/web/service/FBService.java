package TheBoyz.TheBoyz.web.service;
import TheBoyz.TheBoyz.data.model.FacebookUser;
import com.restfb.*;
import com.restfb.types.Post;
import com.restfb.types.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class FBService {

    private static String accessToken = "EAAqDduci0a0BAJKvZCWBWqOconyjrg1m8iaY5gVDUc6Gqo1vSS1xpu4a5DlnRYHd2UIYdGaMMbgxT6UmZA1G78Pm7MM9Jk2dB01ZA6ZAviYTi82wI3TJjNeXrf3jKDwrzDL6FfoZCZCZCYZBzaO6QQpZBIcTpZApj8ZCbVsokgx7zpuQkiDuZBmYzHRidUmRAMbiJmvrnN0gV8SNutloKkbBQZAMmDoTHxVW72rB7RYMkZAL4QkQZDZD";
    private static final DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);;
    private static final User user = facebookClient.fetchObject("me", User.class);


    public static DefaultFacebookClient getFacebookClient() {
        return facebookClient;
    }

    public static FacebookUser getUser() {
        FacebookUser f = new FacebookUser();
        f.setFacebookName(user.getName());
        f.setFacebookID(1);
        f.setFacebookToken(accessToken);
        f.setFacebookDOB(user.getBirthday());
        f.setFacebookEmail(user.getEmail());
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

    public static ArrayList<String> getPosts(){
        ArrayList<String> posts = new ArrayList<>();
        Connection<Post> myPost = facebookClient.fetchConnection("me/feed", Post.class);
        for (Post post: myPost.getData()){
            if (post.getMessage() != null) {
                posts.add(post.getMessage());
            }
        }
        return posts;
    }

}
