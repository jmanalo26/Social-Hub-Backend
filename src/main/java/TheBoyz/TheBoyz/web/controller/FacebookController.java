package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.FacebookLogin;
import TheBoyz.TheBoyz.data.model.FacebookPhotos;
import TheBoyz.TheBoyz.data.model.FacebookPosts;
import TheBoyz.TheBoyz.data.model.FacebookUser;
import TheBoyz.TheBoyz.web.service.FBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("facebook/")
public class FacebookController {

    @GetMapping(value = "login")
    public ResponseEntity<FacebookLogin> login() {
        return new ResponseEntity<FacebookLogin>(FBService.login(), HttpStatus.OK);}

    @GetMapping(value = "username")
    public ResponseEntity<FacebookUser> getUser(){
        return new ResponseEntity<>(FBService.getUser(), HttpStatus.OK);
    }

    @GetMapping(value = "feed")
    public ResponseEntity<FacebookPosts> getUserPosts(){
        return new ResponseEntity<>(FBService.getPosts(), HttpStatus.OK);
    }

    @GetMapping(value = "photos")
    public ResponseEntity<FacebookPhotos> getUserPhotos(){
        return new ResponseEntity<>(FBService.getPhotos(), HttpStatus.OK);
    }

}
