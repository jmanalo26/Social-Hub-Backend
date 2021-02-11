package TheBoyz.TheBoyz.api.SpotifyAPI;

import TheBoyz.TheBoyz.data.service.SpotifyService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.JSONObject;

import static TheBoyz.TheBoyz.api.SpotifyAPI.SpotifyApiConnection.*;


@RestController
@RequestMapping("spotify/")
@Slf4j
public class SpotifyController {

    @GetMapping("/")
    public void generateURL() {
        authorizationCodeUri_Sync();
    }

    @GetMapping("home")
    public void displayHomePage() {
//        SpotifyApiConnection.authorizationCodeUri_Sync();
    }

    @GetMapping("playlist")
    public void displayPlaylists() {
        authorizationCodeRefresh_Sync();
        getListOfCurrentUsersPlaylists_Sync(getSpotifyApi().getAccessToken());

    }

    @GetMapping("playlist/create/{name}")
    public void addPlaylist(@PathVariable String name) {
        authorizationCodeRefresh_Sync();
        createNewPlaylist(name);

    }

    @GetMapping("playlist/addtoplaylist/{playlist_id}/{track_id}")
    public void addTrackToPlaylist(@PathVariable String playlist_id, @PathVariable String... track_id) {
        // "spotify:track:6rqhFgbbKwnb9MLmUQDhG6";
        // spotify:track:3lPr8ghNDBLc2uZovNyLs9
        // spotify:artist:12Chz98pHFMPJEknJQMWvI
        authorizationCodeRefresh_Sync();
        addToPlaylist(playlist_id, track_id);
    }

    @GetMapping("playlist/remove/playlist/{playlist_id}")
    public void removeUserPlaylist(@PathVariable String playlist_id) {
        authorizationCodeRefresh_Sync();
        removePlaylist(playlist_id);
    }

//    @GetMapping("playlist/remove/track/{playlist_id}/{track_array}")
//    public void removeTrackFromPlaylist(@PathVariable String playlist_id, @PathVariable String track_array) {
//        JsonParser parser = new JsonParser();
//        JsonElement elem = parser.parse(track_array);
//        JsonArray elemArr = elem.getAsJsonArray();
//
//        authorizationCodeRefresh_Sync();
//        removeTracksFromPlaylist(playlist_id, elemArr);
//    }

    @GetMapping("userinfo")
    public void getUserProfile() {
        authorizationCodeRefresh_Sync();
        getCurrentUsersProfile_Sync(getSpotifyApi().getAccessToken());
    }

    @GetMapping("authentication/")
    @ResponseBody
    public String generateAuthenticationToken(@RequestParam String code) {
//        log.info(code);
//        System.out.println(code + "\n");
        authorizationCode_Sync(code);
        authorizationCodeRefresh_Sync();

        return "redirect:/home";
    }


}
