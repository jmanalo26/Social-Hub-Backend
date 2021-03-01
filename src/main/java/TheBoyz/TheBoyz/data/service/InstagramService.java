package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.repository.InstagramRepository;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.stereotype.Service;

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



        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
        ArrayList<String> imageFeed = new ArrayList<String>();
        System.out.println(postList.getItems().size());
        for(InstagramFeedItem post : postList.getItems()) {
            System.out.println(post.caption);
            imageFeed.add(post.getImage_versions2().candidates.toString());
        }

        instagramUser.setImageFeed(imageFeed.toArray(String[]::new));



        return instagramUser;
    }

}
