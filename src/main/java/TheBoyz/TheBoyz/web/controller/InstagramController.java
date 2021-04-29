package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.repository.InstagramRepository;
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

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/user/newInstaUser/{user}/{password}")
    public void getUserLogIn(@PathVariable String user,@PathVariable String password) throws IOException {
        InstaUser newUser = new InstaUser();
        System.out.println("running bio change");
        newUser.setUsername(user);
        newUser.setPassword(password);
        instagramService.saveUser(newUser);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(value = "/api/instagram/user")
    public ResponseEntity<InstagramUserInfo> getUser() throws IOException {
//        InstaUser user = instagramService.getUserByID(id)


        InstaUser user = new InstaUser();


        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        InstagramUserInfo insta = instagramService.getUserAccount(user);
        return new ResponseEntity<InstagramUserInfo>(insta, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/bioChange")
    public void changeBio(@RequestBody String bio) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running bio change");
        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        instagramService.changeBio(user, bio);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(value = "/api/instagram/userSearch")
    public ResponseEntity<InstagramUserInfo> userSearch(@RequestParam(value = "user") String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running user search");
        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        return new ResponseEntity<>(instagramService.getSearchUserAccount(user, userSearch), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/followingStatus")
    public boolean checkFollowingStatus(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("checking following status");
        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        boolean status = instagramService.followingStatus(user, userSearch);
        return status;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/followUserSearch")
    public void followUserSearch(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("Followed User");
        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        instagramService.followSearchUserAccount(user, userSearch);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/unfollowUserSearch")
    public void unfollowUserSearch(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("Unfollowed User");
        user.setInstaId(2);
        user.setUsername("thesocialhubclub");
        user.setPassword("Capstone2021");
        instagramService.unfollowSearchUserAccount(user, userSearch);
    }
}


