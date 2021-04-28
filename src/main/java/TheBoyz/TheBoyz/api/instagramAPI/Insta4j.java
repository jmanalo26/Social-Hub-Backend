package TheBoyz.TheBoyz.api.instagramAPI;

import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsSetBiographyRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Insta4j {
    public static void main(String[] args) throws IOException {
//        OkHttpClient httpClient = new OkHttpClient.Builder().build();
//        IGClient client  = IGClient.builder()
//                .username("hbb_disposable")
//                .password("yaga186")
//                .client(httpClient)
//                .login();
//        IGResponse response = new AccountsSetBiographyRequest("Test boi!").execute(client).join();
//        System.out.println(response.getStatus());



        Instagram4j instagram = Instagram4j.builder().username("thesocialhubclub").password("Capstone2021").build();
        instagram.setup();
        instagram.login();
//        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest("thesocialhubclub"));
//        System.out.println(usernameResult.getUser().getFollower_count());

        int width = 344;    //width of the image
        int height = 284;   //height of the image
        BufferedImage image = null;
        File f = new File("download.jpg"); //image file path

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(f);

        ImageIO.write(image, "jpg", new File("test.jpg"));

        File test = new File("test.jpg");

        instagram.sendRequest(new InstagramUploadPhotoRequest(test,"new post" ));
        System.out.println("Picture Posted");


//        InstagramSearchUsernameResult githubResult = instagram.sendRequest(new InstagramSearchUsernameRequest("github"));
//
////        instagram.sendRequest(new InstagramFollowRequest(githubResult.getUser().getPk()));
//        System.out.println(instagram.sendRequest(new InstagramGetFriendshipRequest(githubResult.getUser().getPk())).following);

//
//        InstagramUserInfo searchInstagramUser = new InstagramUserInfo();
//        searchInstagramUser.setFollowerCount(usernameResult.getUser().follower_count);
//        searchInstagramUser.setFollowingCount(usernameResult.getUser().following_count);
//        searchInstagramUser.setMediaCount(usernameResult.getUser().media_count);
//        searchInstagramUser.setProfilePicUrl(usernameResult.getUser().profile_pic_url);
//        searchInstagramUser.setInstaBio(usernameResult.getUser().biography);
//        searchInstagramUser.setDisplayName(usernameResult.getUser().full_name);
//        searchInstagramUser.setUserName(usernameResult.getUser().username);
//
//
//        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
//                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
//        ArrayList<String> followerFeed = new ArrayList<String>();
//        for (InstagramUserSummary account : followersResult.getUsers()) {
//            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
//        }
//        System.out.println(followerFeed.size());
//        searchInstagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));

//
//
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



//        InstagramFeedResult test = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));

//
//        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
//                new InstagramGetUserFollowingRequest(usernameResult.getUser().getPk()));
//        for (InstagramUserSummary user : followersResult.getUsers()) {
//            System.out.println(user.full_name + " " + user.pk);


//        System.out.println(usernameResult.getUser().getFollower_count());
//        System.out.println(usernameResult.getUser().getBiography());
//        System.out.println(usernameResult.getUser().getMedia_count());
//        System.out.println(usernameResult.getUser().getProfile_pic_url());
//        System.out.println(usernameResult.getUser().getExternal_url());
//        System.out.println(usernameResult.getUser().hd_profile_pic_url_info.url);
//        System.out.println(usernameResult.getUser().toString());

//        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
//        for (InstagramFeedItem post : postList.getItems()) {
//            System.out.println(post.getCaption().getText());
//            System.out.println(post.image_versions2.getCandidates());
//            System.out.println(post.getComments());
//
//        }

    }
}


