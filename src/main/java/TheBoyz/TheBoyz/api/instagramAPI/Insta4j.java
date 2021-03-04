package TheBoyz.TheBoyz.api.instagramAPI;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.ImageMeta;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

import java.io.IOException;

public class Insta4j {
    public static void main(String[] args) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username("thesocialhubclub").password("Capstone2021").build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest("thesocialhubclub"));

        System.out.println(usernameResult.getUser().getFollower_count());
        System.out.println(usernameResult.getUser().getBiography());
        System.out.println(usernameResult.getUser().getMedia_count());
        System.out.println(usernameResult.getUser().getProfile_pic_url());

        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
        for(InstagramFeedItem post : postList.getItems()) {
            System.out.println(post.getImage_versions2().candidates);
        }

    }

}

