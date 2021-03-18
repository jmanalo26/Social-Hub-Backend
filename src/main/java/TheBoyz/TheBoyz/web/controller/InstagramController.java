package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.service.InstagramService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class InstagramController {

    private final InstagramService instagramService;


    public InstagramController(final InstagramService instagramService) {
        this.instagramService = instagramService;
    }

    @GetMapping(value = "/api/instagram/user")
    public ResponseEntity<InstagramUserInfo> getUser() throws IOException {
        InstaUser user = new InstaUser();

        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        InstagramUserInfo insta = instagramService.getUserAccount(user);
        return new ResponseEntity<InstagramUserInfo>(insta, HttpStatus.OK);
    }

    @PostMapping(value = "/api/instagram/bioChange")
    public void changeBio(@RequestBody String bio) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running bio change");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        instagramService.changeBio(user, bio);
    }

    @PostMapping(value = "/api/instagram/userSearch")
    public ResponseEntity<InstagramUserInfo> userSearch(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running bio change");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        InstagramUserInfo insta = instagramService.getSearchUserAccount(user, userSearch);
        return new ResponseEntity<InstagramUserInfo>(insta, HttpStatus.OK);
    }
}


