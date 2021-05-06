package TheBoyz.TheBoyz.web.controller;
import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.OnePosts;
import TheBoyz.TheBoyz.data.model.Tweet;
import TheBoyz.TheBoyz.data.service.InstagramService;
import TheBoyz.TheBoyz.data.service.OnePostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class OnePostController {

    final OnePostService onePostService;
    final InstagramService instagramService;

    public OnePostController(final OnePostService onePostService, final InstagramService instagramService) {
        this.onePostService = onePostService;
        this.instagramService = instagramService;
    }

    /**
     * gets the user's number of followers.
     * @return returns the number of followers the user has.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/one-posts/get/{userId}")
    public List<OnePosts> getOnePosts(@PathVariable String userId)  {
        System.out.println("ONE POST CONTROLLER GET");
        return onePostService.getUsersOnePosts(Integer.valueOf(userId));
    }

    /**
     * Gets the current status as a status json object.
     * @return returns the user's tweet.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/one-posts/save")
    public OnePosts saveOnePosts(@RequestBody OnePosts onePost) {
        System.out.println("ONE POST CONTROLLER POST");
        System.out.println(onePost.getUserId());
        System.out.println(onePost.getTextContent());
        return onePostService.saveOnePost(onePost);

    }

    /**
     * Gets the current status as a status json object.
     * @return returns the user's tweet.
     * @throws TwitterException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/one-posts/save/form-data")
    public OnePosts saveOnePostsAsFormData(@RequestParam("file") MultipartFile mPFile, @RequestParam("textContent")  String textContent,
                                           @RequestParam("userId")  String userId,
                                           @RequestParam("socialMedia")  String socialMedia,
                                           @RequestParam("createdAt")  String createdAt
                                           ) throws IOException, ParseException {
        System.out.println("ONE POST CONTROLLER POST");
        OnePosts newOnePost = new OnePosts();
        newOnePost.setTextContent(textContent);
        newOnePost.setImage(mPFile.getBytes());

        newOnePost.setUserId(Integer.valueOf(userId));
        newOnePost.setSocialMedia(socialMedia);




        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//        java.util.Date date = sdf1.parse(createdAt); // Returns a Date format object with the pattern

//        newOnePost.setCreatedAt(date);
        return onePostService.saveOnePost(newOnePost);

    }


}
