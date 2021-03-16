package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.Youtube;
import TheBoyz.TheBoyz.data.repository.YoutubeRepository;
import TheBoyz.TheBoyz.web.service.YoutubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class YoutubeController {

    private YoutubeRepository youtubeRepository;
    private final YoutubeService youtubeService;
    private Youtube youtube;
    private BindingResult br;


    public YoutubeController(YoutubeRepository youtubeRepository, final YoutubeService youtubeService) {
        this.youtubeRepository = youtubeRepository;
        this.youtubeService = youtubeService;
    }
    @GetMapping(value = "/api/youtube/videos")
    public ResponseEntity<List<String>> getVideos() throws IOException {
        return new ResponseEntity<List<String>>(youtubeService.getVideos(), HttpStatus.OK);
    }
    @GetMapping(value = "/api/youtube/channelId")
    public ResponseEntity<String> getChannelId() throws IOException {
        return new ResponseEntity<String> (youtubeService.getChannelInfo(), HttpStatus.OK);
    }
//    @GetMapping(value = "/api/youtube/add")
//    public @ResponseBody String addYoutube() throws IOException {
//        Youtube youtube = new Youtube();
//        //       youtube.setVideos(youtubeService.getVideos());
//        youtube.setChannel_id("Hello");
//        youtube.setProfile_photo(youtubeService.getProfilePicture());
//        youtubeRepository.save(youtube);
//        return "saved";
//    }

    @GetMapping(value = "/api/youtube/playlists")
    public ResponseEntity<ArrayList<String>> getPlaylists() throws IOException {
        return new ResponseEntity<ArrayList<String>>(youtubeService.getUserPlaylist(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/youtube/liked")
    public ResponseEntity<ArrayList<String>> getLikedVideos() throws IOException {
        return new ResponseEntity<ArrayList<String>>(youtubeService.getLikedVideos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/youtube/newUser")
    public Youtube save(@RequestBody Youtube youtube) {
        System.out.println("in post mapping");
        Youtube yt = new Youtube();
        yt.setChannelId(youtube.getChannel_id());
        yt.setProfile_pic(youtube.getProfile_photo());
        yt.setUserId(youtube.getUserId());
        yt.setUsername(youtube.getUsername());

        Youtube temp = this.youtubeService.saveUser(yt);
        return yt;
    }
    @GetMapping(value = "api/youtube/retrieve/{id}")
    public ResponseEntity<String> getUserById(@PathVariable long id){
        return new ResponseEntity<String>(youtubeRepository.findUserByUserId(id).toString(), HttpStatus.OK);
    }
}
