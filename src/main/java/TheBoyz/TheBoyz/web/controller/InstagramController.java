package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.service.InstagramService;

import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class InstagramController {

    private final InstagramService instagramService;


    public InstagramController(final InstagramService instagramService){
        this.instagramService = instagramService;
    }

    @GetMapping(value = "/api/instagram/user")
    public ResponseEntity<InstagramUserInfo> getUser() throws IOException {
        InstaUser user =  new InstaUser();

        user.setInstaId(1);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        InstagramUserInfo insta = instagramService.getUserAccount(user);
        return new ResponseEntity<InstagramUserInfo>(insta, HttpStatus.OK);
    }




}
