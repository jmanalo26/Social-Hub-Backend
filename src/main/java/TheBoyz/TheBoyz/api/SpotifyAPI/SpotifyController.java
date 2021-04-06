package TheBoyz.TheBoyz.api.SpotifyAPI;

import TheBoyz.TheBoyz.data.model.spotify.*;
import TheBoyz.TheBoyz.data.service.SpotifyService;
import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import static TheBoyz.TheBoyz.data.service.SpotifyService.*;


@RestController
@RequestMapping("spotify/")
@Slf4j
public class SpotifyController {

    // Try to order these methods

    // Authentication
    // User specific
    // Playlist/ add/ remove/ update/ reorder
    // Track
    // Artist
    // Album
    // Recommendations?
    // Search/ Query


    @GetMapping("/")
    public ResponseEntity<String> generateURL() {
        return new ResponseEntity<>(authorizationCodeUri_Sync(), HttpStatus.OK);
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

    @PostMapping("playlist/create/{name}/{description}")
    public ResponseEntity<SpotifyPlaylist> addPlaylist(@PathVariable String name, @PathVariable String description) {
//        log.info("Create Playlist Method Called!");
        authorizationCodeRefresh_Sync();
//        createNewPlaylist(name, description);
        return new ResponseEntity<>(createNewPlaylist(name, description), HttpStatus.OK);

//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("http://localhost:4200/spotify");
//        return redirectView;
    }

    // change the mapping to a PUT mapping and return a response entity of type playlist
    @PutMapping("playlist/add/track/{playlist_id}/{track_uri}")
    public ResponseEntity<SpotifyPlaylist> addTrackToPlaylist(@PathVariable String playlist_id, @PathVariable String... track_uri) {
        // "spotify:track:6rqhFgbbKwnb9MLmUQDhG6";
        // spotify:track:3lPr8ghNDBLc2uZovNyLs9
        // spotify:artist:12Chz98pHFMPJEknJQMWvI
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(addToPlaylist(playlist_id, track_uri), HttpStatus.OK);
    }

    @GetMapping("playlist/remove/playlist/{playlist_id}")
    public RedirectView removeUserPlaylist(@PathVariable String playlist_id) {
        authorizationCodeRefresh_Sync();
        removePlaylist(playlist_id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/spotify");
        return redirectView;
    }

    @PutMapping("playlist/remove/track/{playlist_id}/{track_array}")
    public ResponseEntity<SpotifyPlaylist> removeTrackFromPlaylist(@PathVariable String playlist_id, @PathVariable String track_array) {
        //7aCuS3JmM9PdKXTBxg5tl8
        //
        // {
        //  "tracks": [
        //    {
        //      "uri": "spotify:track:7eJMfftS33KTjuF7lTsMCx",
        //      "positions": [
        //        0
        //      ]
        //    }
        //  ]
        //}

        // I need to pass in this string:
        // { "uri": "spotify:track:4iV5W9uYEdYUVa79Axb7Rh" }
        // turn the above into a json array and pass that to the service

        String spotifyURI = "{\"uri\": \"" + track_array + "\"}";
        JsonArray js = new JsonArray();
        js.add(new Gson().fromJson(spotifyURI, JsonObject.class));

        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(removeTracksFromPlaylist(playlist_id, js), HttpStatus.OK);
    }

    @GetMapping("userinfo")
    public ResponseEntity<SpotifyUser> getUserProfile() {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(getCurrentUsersProfile_Sync(getSpotifyApi().getAccessToken()), HttpStatus.OK);
    }

    @GetMapping("authentication/")
    @ResponseBody
    public RedirectView generateAuthenticationToken(@RequestParam String code) {
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
//        log.info("Inside the searchByArtistMethod: " + artistName);
        authorizationCodeRefresh_Sync();
//        System.out.println("In The Controller: called searchByArtist: " + artistName);
        return new ResponseEntity<>(searchByArtist(artistName), HttpStatus.OK);
    }

    @GetMapping("/search/track/{trackName}")
    @ResponseBody
    public ResponseEntity<SpotifyTrack[]> queryTrack(@PathVariable String trackName) {
//        log.info("Inside the searchByTrack: " + trackName);
        authorizationCodeRefresh_Sync();
//        System.out.println("In The Controller: called searchByTrack: " + trackName);
        return new ResponseEntity<>(searchByTrack(trackName), HttpStatus.OK);
    }

    @GetMapping("/album/{album_id}")
    @ResponseBody
    public ResponseEntity<SpotifyAlbum> getAlbumById(@PathVariable String album_id) {
//        log.info("Inside the searchByTrack: " + album_id);
        authorizationCodeRefresh_Sync();
//        System.out.println("In The Controller: called searchByTrack: " + album_id);
        return new ResponseEntity<>(SpotifyService.getAlbumById(album_id), HttpStatus.OK);
    }

    @PutMapping("/playlist/reorder/{playlist_id}/{range_start}/{insert_before}")
    public ResponseEntity<SpotifyPlaylist> reorderPlaylist(@PathVariable String playlist_id, @PathVariable Integer range_start, @PathVariable Integer insert_before) {
        return new ResponseEntity<>(reorderPlaylistItems(playlist_id, range_start, insert_before), HttpStatus.OK);
    }

    // Create mappings for updating playlist, getting artist by ID, getting top tracks of an artist, getting albums of an artist
    // Artist id for Ariana: 66CXWjxzNUsdJxJ2JdwvnR

    @GetMapping("/artist/id/{artistId}")
    public ResponseEntity<SpotifyArtist> getArtistById(@PathVariable String artistId) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getArtistById(artistId), HttpStatus.OK);
    }

    @GetMapping("/artist/tracks/{artistId}")
    public ResponseEntity<SpotifyTrack[]> getArtistTopTracksById(@PathVariable String artistId) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getArtistTopTracks(artistId), HttpStatus.OK);
    }

    @GetMapping("/artist/albums/{artistId}")
    public ResponseEntity<SpotifyAlbum[]> getArtistAlbumsById(@PathVariable String artistId) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getArtistAlbums(artistId), HttpStatus.OK);
    }

    @PutMapping("/playlist/update/{playlist_id}/{playlist_name}/{playlist_description}")
    public ResponseEntity<SpotifyPlaylist> updatePlaylistDetails(@PathVariable String playlist_id, @PathVariable String playlist_name, @PathVariable String playlist_description) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.updatePlaylistDetails(playlist_id, playlist_name, playlist_description), HttpStatus.OK);
    }

    @PutMapping("/playlist/update/{playlist_id}/{playlist_name}")
    public ResponseEntity<SpotifyPlaylist> updatePlaylistDetails(@PathVariable String playlist_id, @PathVariable String playlist_name) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.updatePlaylistDetails(playlist_id, playlist_name, null), HttpStatus.OK);
    }

    @PutMapping("/artist/follow/{artist_id}")
    public ResponseEntity<Boolean> followArtist(@PathVariable String... artist_id) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.followArtist(artist_id), HttpStatus.OK);
    }

    @PutMapping("/artist/unfollow/{artist_id}")
    public ResponseEntity<Boolean> unfollowArtist(@PathVariable String... artist_id) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.unfollowArtist(artist_id), HttpStatus.OK);
    }

    @GetMapping("/artist/follow/contains/{artist_id}")
    public ResponseEntity<Boolean> checkFollowArtist(@PathVariable String... artist_id) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.checkUserFollowArtist(artist_id), HttpStatus.OK);
    }

    @GetMapping("/user/get/follow/tracks/")
    public ResponseEntity<SpotifyTrack[]> getUserFollowedTracks() {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getUserFollowedTracks(), HttpStatus.OK);
    }

    @GetMapping("/artist/related/{artist_id}")
    public ResponseEntity<SpotifyArtist[]> getRelatedArtist(@PathVariable String artist_id) {
        authorizationCodeRefresh_Sync();
        return new ResponseEntity<>(SpotifyService.getRecommendedArtists(artist_id), HttpStatus.OK);
    }


}
