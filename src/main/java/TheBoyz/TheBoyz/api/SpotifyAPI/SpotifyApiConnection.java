package TheBoyz.TheBoyz.api.SpotifyAPI;

import TheBoyz.TheBoyz.data.model.SpotifyArtist;
import TheBoyz.TheBoyz.data.model.SpotifyTrack;
import TheBoyz.TheBoyz.data.model.SpotifyUser;
import com.google.gson.JsonArray;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import com.wrapper.spotify.requests.data.playlists.AddItemsToPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.apache.hc.core5.http.ParseException;
import twitter4j.JSONArray;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class SpotifyApiConnection {

    private static final String clientId = "0e23f91af6cb403e9f23852a496b803f";
    private static final String clientSecret = "84f1f4ab297a4a2dbb1219a2bafe75fa";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/spotify/authentication/");
    private static String userId = "";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();
    private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            .scope("user-read-private,user-read-email,user-read-recently-played,user-read-playback-state,user-top-read,playlist-modify-public,user-modify-playback-state,playlist-modify-private,user-follow-modify,user-read-currently-playing,user-follow-read,user-library-modify,user-read-playback-position,playlist-read-private,user-library-read,playlist-read-collaborative,streaming")
            .show_dialog(true)
            .build();

    public static SpotifyApi getSpotifyApi() {
        return spotifyApi;
    }


    public static String authorizationCodeUri_Sync() {
        final URI uri = authorizationCodeUriRequest.execute();
//        try {
//            java.awt.Desktop.getDesktop().browse(uri);
//        } catch (IOException e) {
//
//        }
        return uri.toString();
    }

    public static void authorizationCode_Sync(String code) {
        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                .build();
        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void authorizationCodeRefresh_Sync() {
        AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
                .build();
        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getListOfCurrentUsersPlaylists_Sync(String accessToken) {
        final GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylistsRequest = spotifyApi
                .getListOfCurrentUsersPlaylists()
                .build();
        try {
            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfCurrentUsersPlaylistsRequest.execute();
            var playlistSimplifiedPagingItems = playlistSimplifiedPaging.getItems();
            for (var playlist : playlistSimplifiedPagingItems) {
                System.out.println("External url: " + playlist.getExternalUrls());
                System.out.println("Spotify ID: " + playlist.getId());
                System.out.println("Playlist Name: " + playlist.getName());
                var tracksInformation = playlist.getTracks();
            }

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static SpotifyUser getCurrentUsersProfile_Sync(String accessToken) {
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        SpotifyUser spotify_user = null;
        try {
            final User user = getCurrentUsersProfileRequest.execute();
//            System.out.println(user);
            userId = user.getId();

//            user.getExternalUrls().getExternalUrls().get("spotify");
            System.out.println(user);
            // create and return the model
            spotify_user = new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), user.getImages()[0].getUrl());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return spotify_user;
    }

    public static void createNewPlaylist(String name) {
        CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
                .build();
        try {
            var playlist = createPlaylistRequest.execute();
            System.out.println("Playlist with name: " + playlist.getName() + " has been created!");
            System.out.println("Playlist id is: " + playlist.getId());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addToPlaylist(String playlistid, String... uri) {
//spotifyApi.unfollowPlaylist();
        AddItemsToPlaylistRequest addToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlistid, uri).build();
        try {
            var playlist = addToPlaylistRequest.execute();
            System.out.println("Added to playlist!");
//            System.out.println("Playlist with name: " + playlist.getName() + " has been created!");
//            System.out.println("Playlist id is: " + playlist.getId());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removePlaylist(String playlistid) {

        var unfollowPlaylistRequest = spotifyApi.unfollowPlaylist(playlistid).build();
        try {
            var playlist = unfollowPlaylistRequest.execute();
            System.out.println("Removed Playlist!");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeTracksFromPlaylist(String playlist_id, JsonArray tracksArray) {
        var removeFromPlaylistRequest = spotifyApi.removeItemsFromPlaylist(playlist_id, tracksArray).build();
        try {
            var playlist = removeFromPlaylistRequest.execute();
            System.out.println("Removed Track");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static SpotifyArtist[] searchByArtist(String query) {
        var searchFromApiRequest = spotifyApi.searchArtists(query).build();
        try {
            var result = searchFromApiRequest.execute();
//            user.getExternalUrls().getExternalUrls().get("spotify");
            var tempArray = result.getItems();
            List<SpotifyArtist> artistList = new ArrayList<>();
            for (var artist : tempArray) {
                System.out.println(artist);
//                System.out.println(artist.getName());
//                System.out.println(artist.getExternalUrls().getExternalUrls().get("spotify"));
//                System.out.println(artist.getFollowers().getTotal());
//                System.out.println(artist.getGenres());
//                System.out.println(artist.getId());
//                System.out.println(artist.getImages()[0].getUrl());
//                System.out.println(artist.getPopularity());
//                System.out.println(artist.getUri());

                if (artist.getImages().length > 0) {
                    artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), artist.getImages()[0].getUrl(), artist.getPopularity(), artist.getUri()));

                } else {
                    artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), null, artist.getPopularity(), artist.getUri()));

                }

            }
            System.out.println("In Connection: Got result from API!");
            System.out.println(artistList.toString());
            return artistList.toArray(SpotifyArtist[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    public static SpotifyTrack[] searchByTrack(String query) {
        var searchFromApiRequest = spotifyApi.searchTracks(query).build();
        try {
            var result = searchFromApiRequest.execute();
//            user.getExternalUrls().getExternalUrls().get("spotify");
            var tempArray = result.getItems();
            List<SpotifyTrack> trackList = new ArrayList<>();
            for (var track : tempArray) {
                var tempList = new ArrayList<String>();
                var artists = track.getArtists();
                for (var artist : artists) {
                    tempList.add(artist.getName());
                }

                trackList.add(new SpotifyTrack(track.getName(), tempList.toArray(String[]::new), track.getExternalUrls().getExternalUrls().get("spotify"), track.getDiscNumber(), track.getDurationMs(), track.getIsExplicit(), track.getPopularity()));
//                artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), artist.getImages()[0].getUrl(), artist.getPopularity(), artist.getUri()));
            }
            System.out.println("In Connection: Got result from API!");
            System.out.println(trackList.toString());
            return trackList.toArray(SpotifyTrack[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }


//    public static void main(String[] args) {
//        authorizationCodeUri_Sync();
////        authorizationCodeUri_Async();
//    }
}
