package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.model.OnePosts;
import TheBoyz.TheBoyz.data.repository.InstagramRepository;
import TheBoyz.TheBoyz.data.service.InstagramService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        InstagramUserInfo insta = instagramService.getUserAccount(user);
        return new ResponseEntity<InstagramUserInfo>(insta, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/bioChange")
    public void changeBio(@RequestBody String bio) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running bio change");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        instagramService.changeBio(user, bio);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(value = "/api/instagram/userSearch")
    public ResponseEntity<InstagramUserInfo> userSearch(@RequestParam(value = "user") String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("running user search");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        return new ResponseEntity<>(instagramService.getSearchUserAccount(user, userSearch), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/followingStatus")
    public boolean checkFollowingStatus(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("checking following status");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        boolean status = instagramService.followingStatus(user, userSearch);
        return status;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/followUserSearch")
    public void followUserSearch(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("Followed User");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        instagramService.followSearchUserAccount(user, userSearch);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/unfollowUserSearch")
    public void unfollowUserSearch(@RequestBody String userSearch) throws IOException {
        InstaUser user = new InstaUser();
        System.out.println("Unfollowed User");
        user.setInstaId(2);
        user.setUsername("hbb_disposable");
        user.setPassword("yaga186");
        instagramService.unfollowSearchUserAccount(user, userSearch);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/api/instagram/uploadImage")
    public void uploadImage(@RequestParam("file")  MultipartFile mPFile, @RequestParam("textContent")  String textContent) throws IOException {
        System.out.println("MADE IT TO THE Instagram BACKEND");
        System.out.println(mPFile.getName());
        System.out.println(mPFile.getBytes());
        System.out.println(mPFile.getContentType());
        System.out.println(textContent);


        String fileName = mPFile.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        File file = null;
        try {

            file = File.createTempFile(fileName, prefix);
            mPFile.transferTo(file);
            InstaUser user = new InstaUser();
            System.out.println("Unfollowed User");
            user.setInstaId(2);
            user.setUsername("hbb_disposable");
            user.setPassword("yaga186");
//            instagramService.postImage( user, file, textContent);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // After operating the above files, you need to delete the temporary files generated in the root directory
            File f = new File(file.toURI());
            f.delete();

//        System.out.println(response.getStatus());
//        System.out.println(response);
////        InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        IOUtils.copy(in, response.getOutputStream());

//        return new ResponseEntity<>(twitterService.captureTokensByObject(secureTwitter), HttpStatus.OK);
//                System.out.println("MADE IT TO THE UPLOAD CONTROLLER!");
//        System.out.println("Original Image Byte Size - " + file.getBytes().length);
//        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//        compressBytes(file.getBytes()));
//        imageRepository.save(img);
        }
    }

}


