package TheBoyz.TheBoyz.api.SpotifyAPI;

import TheBoyz.TheBoyz.data.model.spotify.*;
import TheBoyz.TheBoyz.data.service.SpotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import static TheBoyz.TheBoyz.data.service.SpotifyService.*;


@RestController
@RequestMapping("spotify/")
@Slf4j
public class SpotifyController {

    @GetMapping("/")
    public ResponseEntity<String> generateURL() {
        log.info("inside generate url!");
        log.info(authorizationCodeUri_Sync());
        return new ResponseEntity<>(authorizationCodeUri_Sync(), HttpStatus.OK);
    }

    @GetMapping("home")
    public void displayHomePage() {
//        SpotifyApiConnection.authorizationCodeUri_Sync();
    }

    @GetMapping("playlist/{playlist_id}")
    public ResponseEntity<SpotifyPlaylist> getPlaylistById(@PathVariable String playlist_id) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getPlaylistById(playlist_id), HttpStatus.OK);
    }

    @GetMapping("playlist")
    public ResponseEntity<SpotifyPlaylist[]> displayPlaylists() {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(getListOfCurrentUsersPlaylists_Sync(getSpotifyApi().getAccessToken()), HttpStatus.OK);
    }

    @GetMapping("playlist/create/{name}")
    public void addPlaylist(@PathVariable String name) {
        authorizationCodeRefresh_Sync();
        createNewPlaylist(name);

    }

    @GetMapping("playlist/addtoplaylist/{playlist_id}/{track_uri}")
    public void addTrackToPlaylist(@PathVariable String playlist_id, @PathVariable String... track_uri) {
        // "spotify:track:6rqhFgbbKwnb9MLmUQDhG6";
        // spotify:track:3lPr8ghNDBLc2uZovNyLs9
        // spotify:artist:12Chz98pHFMPJEknJQMWvI
        authorizationCodeRefresh_Sync();
        addToPlaylist(playlist_id, track_uri);
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
    public ResponseEntity<SpotifyUser> getUserProfile() {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(getCurrentUsersProfile_Sync(getSpotifyApi().getAccessToken()), HttpStatus.OK);
    }

    @GetMapping("authentication/")
    @ResponseBody
    public RedirectView generateAuthenticationToken(@RequestParam String code) {
//        log.info(code);
//        System.out.println(code + "\n");
//        log.info(code);
        authorizationCode_Sync(code);
        authorizationCodeRefresh_Sync();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/spotify");
        return redirectView;
//        return new ResponseEntity<>(getCurrentUsersProfile_Sync(getSpotifyApi().getAccessToken()), HttpStatus.OK);
    }

    @GetMapping("/search/artist/{artistName}")
    @ResponseBody
    public ResponseEntity<SpotifyArtist[]> queryArtist(@PathVariable String artistName) {
        log.info("Inside the searchByArtistMethod: " + artistName);
        authorizationCodeRefresh_Sync();
        System.out.println("In The Controller: called searchByArtist: " + artistName);
        return new ResponseEntity<>(searchByArtist(artistName), HttpStatus.OK);
    }

    @GetMapping("/search/track/{trackName}")
    @ResponseBody
    public ResponseEntity<SpotifyTrack[]> queryTrack(@PathVariable String trackName) {
        log.info("Inside the searchByTrack: " + trackName);
        authorizationCodeRefresh_Sync();
        System.out.println("In The Controller: called searchByTrack: " + trackName);
        return new ResponseEntity<>(searchByTrack(trackName), HttpStatus.OK);
    }

    @GetMapping("/album/{album_id}")
    @ResponseBody
    public ResponseEntity<SpotifyAlbum> getAlbumById(@PathVariable String album_id) {
        log.info("Inside the searchByTrack: " + album_id);
        authorizationCodeRefresh_Sync();
        System.out.println("In The Controller: called searchByTrack: " + album_id);
        return new ResponseEntity<>(SpotifyService.getAlbumById(album_id), HttpStatus.OK);
    }


}
