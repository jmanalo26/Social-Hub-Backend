package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.*;
import TheBoyz.TheBoyz.web.service.FBService;
import com.restfb.json.Json;
import com.restfb.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@Slf4j
@RestController
@RequestMapping("facebook/")
public class FacebookController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "verify")
    public void getAccessToken(@RequestBody String code) {
        System.out.println("Inside FB get access token method" );
        code = code.replace("\"", "");
        System.out.println(code);
        FBService.getAccessToken(code);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "login")
    public ResponseEntity<FacebookLogin> login() {
        System.out.println("Inside FB Controller Login");
        return new ResponseEntity<FacebookLogin>(FBService.login(), HttpStatus.OK);}

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "username")
    public ResponseEntity<FacebookUser> getUser(){
        return new ResponseEntity<>(FBService.getUser(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "feed")
    public ResponseEntity<FacebookPosts> getUserPosts(){
        return new ResponseEntity<>(FBService.getPosts(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "photos")
    public ResponseEntity<FacebookPhotos> getUserPhotos(){
        return new ResponseEntity<>(FBService.getPhotos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "accounts")
    public ResponseEntity<FacebookPages> getPages(){
        return new ResponseEntity<>(FBService.getPages(), HttpStatus.OK);
    }

}
