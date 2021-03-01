package TheBoyz.TheBoyz.web.service;
import TheBoyz.TheBoyz.data.model.FacebookPosts;
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

    //Because we dont have the OAuth setup yet, we'll have to pull this token from Facebook Graph API explorer
    //using the Jorge account
    private static String accessToken = "EAAqDduci0a0BAO9NadkjaUboH3VlK3eXsTZCaVWtYuLZB8jZCSabSzK15wpj2at8OgjFRDoBkOk3sbNK0gOOGIYaeMkUnoE2thdBSNXyi5KFHS3D70nHetncgksdZAW10quCKmqPpgAE607nm2kR8r6CalfA8BZB7hYmQIGrjSUVm1VuBtBQE468wSH48X8wuonAWLBPDB1xAvw9XjyVmPmRIlPl4ZARpqg03blLSd3gZDZD";
    private static final DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.LATEST);;
    private static final User user = facebookClient.fetchObject("me", User.class);


    public static DefaultFacebookClient getFacebookClient() {
        return facebookClient;
    }

    public static FacebookUser getUser() {
        FacebookUser f = new FacebookUser();
        f.setFacebookName(user.getName());
        //Will have to make new ID variable
        f.setFacebookID(1);
        f.setFacebookToken(accessToken);
        f.setFacebookDOB(user.getBirthday());
        User email = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "email"));
        User pic = facebookClient.fetchObject(user.getId(), User.class, Parameter.with("fields", "picture"));
        f.setFacebookEmail(email.getEmail());
        f.setPhotoURL(pic.getPicture().getUrl());
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

}
