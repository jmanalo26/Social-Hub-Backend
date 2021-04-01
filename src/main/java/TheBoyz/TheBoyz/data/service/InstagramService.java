package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.repository.InstagramRepository;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsSetBiographyRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowingRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.*;
import org.springframework.stereotype.Service;
import com.github.instagram4j.instagram4j.IGClient;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Service
public class InstagramService {



    private final InstagramRepository instagramRepository;

    public InstagramService(InstagramRepository instagramRepository) {
        this.instagramRepository = instagramRepository;
    }

//    @Transactional(readOnly = true)
//    public void findByUsername(final String username, final Integer page, final Integer limit){
//        instagramRepository.findByUsername(username, PageRequest.of(page, limit));
//    }



    public InstagramUserInfo getUserAccount(@NotNull InstaUser user) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest(user.getUsername()));

        InstagramUserInfo instagramUser = new InstagramUserInfo();
        instagramUser.setFollowerCount(usernameResult.getUser().follower_count);
        instagramUser.setFollowingCount(usernameResult.getUser().following_count);
        instagramUser.setMediaCount(usernameResult.getUser().media_count);
        instagramUser.setProfilePicUrl(usernameResult.getUser().profile_pic_url);
        instagramUser.setInstaBio(usernameResult.getUser().biography);
        instagramUser.setDisplayName(usernameResult.getUser().full_name);
        instagramUser.setUserName(usernameResult.getUser().username);


        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
        ArrayList<String> followerFeed = new ArrayList<String>();
        for (InstagramUserSummary account : followersResult.getUsers()) {
            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
        }
        System.out.println(followerFeed.size());
        instagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));


        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
        ArrayList<String> imageFeed = new ArrayList<String>();
        ArrayList<String> imageFeedCaption = new ArrayList<String>();
        ArrayList<String> imageFeedComment = new ArrayList<String>();
        System.out.println(postList.getItems().size());
        for(InstagramFeedItem post : postList.getItems()) {

            imageFeed.add(post.image_versions2.getCandidates().toString());
            System.out.println(post.image_versions2.getCandidates().toString());
            imageFeedCaption.add(post.getCaption().getText());
            imageFeedComment.add(post.toString());
        }

        instagramUser.setImageFeed(imageFeed.toArray(String[]::new));
        instagramUser.setImageFeedCaption(imageFeedCaption.toArray(String[]::new));
        instagramUser.setImageFeedComment(imageFeedComment.toArray(String[]::new));


        return instagramUser;
    }

    public void changeBio(InstaUser user, String bio) throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        IGClient client  = IGClient.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .client(httpClient)
                .login();
        IGResponse response = new AccountsSetBiographyRequest(bio).execute(client).join();
        System.out.println(response.getStatus());
    }

    public InstagramUserInfo getSearchUserAccount(@NotNull InstaUser user, String userSearch) throws IOException {

        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));

        InstagramUserInfo searchInstagramUser = new InstagramUserInfo();
        searchInstagramUser.setFollowerCount(usernameResult.getUser().follower_count);
        searchInstagramUser.setFollowingCount(usernameResult.getUser().following_count);
        searchInstagramUser.setMediaCount(usernameResult.getUser().media_count);
        searchInstagramUser.setProfilePicUrl(usernameResult.getUser().profile_pic_url);
        searchInstagramUser.setInstaBio(usernameResult.getUser().biography);
        searchInstagramUser.setDisplayName(usernameResult.getUser().full_name);
        searchInstagramUser.setUserName(usernameResult.getUser().username);


        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
        ArrayList<String> followerFeed = new ArrayList<String>();
        for (InstagramUserSummary account : followersResult.getUsers()) {
            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
        }
        System.out.println(followerFeed.size());
        searchInstagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));



//        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
//        ArrayList<String> imageFeed = new ArrayList<String>();
//        ArrayList<String> imageFeedCaption = new ArrayList<String>();
//        ArrayList<String> imageFeedComment = new ArrayList<String>();
//        System.out.println(postList.getItems().size());
//        for(InstagramFeedItem post : postList.getItems()) {
//
//            imageFeed.add(post.image_versions2.getCandidates().toString());
//            System.out.println(post.image_versions2.getCandidates().toString());
//            imageFeedCaption.add(post.getCaption().getText());
//            imageFeedComment.add(post.toString());
//        }
//
//        searchInstagramUser.setImageFeed(imageFeed.toArray(String[]::new));
//        searchInstagramUser.setImageFeedCaption(imageFeedCaption.toArray(String[]::new));
//        searchInstagramUser.setImageFeedComment(imageFeedComment.toArray(String[]::new));



        return searchInstagramUser;
    }

    public InstaUser saveUser(InstaUser user) {
        InstaUser userSH = instagramRepository.findInstaUserByUsername(user.getUsername());
        if (userSH == null) {
            System.out.println("in save User");
            instagramRepository.save(user);
        }
        return user;
    }

    public InstaUser getUserByID(int id) {
        InstaUser userSH = instagramRepository.findInstaUserByInstaId(id);

        return userSH;
    }

}
