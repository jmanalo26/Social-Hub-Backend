package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.spotify.*;
import com.google.gson.JsonArray;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import com.wrapper.spotify.requests.data.playlists.AddItemsToPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpotifyService {

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

    public static SpotifyPlaylist[] getListOfCurrentUsersPlaylists_Sync(String accessToken) {
        final GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylistsRequest = spotifyApi
                .getListOfCurrentUsersPlaylists()
                .build();
        try {
            final var playlistSimplifiedPaging = getListOfCurrentUsersPlaylistsRequest.execute();
            var playlistSimplifiedPagingItems = playlistSimplifiedPaging.getItems();
            var playListArray = new ArrayList<SpotifyPlaylist>();
            for (var playlist : playlistSimplifiedPagingItems) {
                playListArray.add(getPlaylistById(playlist.getId()));
            }
            return playListArray.toArray(SpotifyPlaylist[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static SpotifyPlaylist getPlaylistById(String playlist_id) {
        var getPlaylistRequest = spotifyApi.getPlaylist(playlist_id).build();
        try {
            var resultSet = getPlaylistRequest.execute();
            if (resultSet.getImages().length > 0) {
                return new SpotifyPlaylist(resultSet.getName(), getTracksFromPlaylistById(playlist_id), resultSet.getDescription(), resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getId(), resultSet.getImages()[0].getUrl(), resultSet.getUri());
            } else {
                return new SpotifyPlaylist(resultSet.getName(), getTracksFromPlaylistById(playlist_id), resultSet.getDescription(), resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getId(), null, resultSet.getUri());

            }
        } catch (IOException | SpotifyWebApiException | ParseException e) {

            return null;
        }

    }

    public static SpotifyTrack[] getTracksFromPlaylistById(String id) {
        var getItemsRequest = spotifyApi.getPlaylistsItems(id).build();
        try {
            var resultSet = getItemsRequest.execute();
            List<SpotifyTrack> trackList = new ArrayList<>();
            for (var track : resultSet.getItems()) {
                trackList.add(getTrackById(track.getTrack().getId()));
            }
//            System.out.println(trackList.toString());
            return trackList.toArray(SpotifyTrack[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {

        }
        return null;
    }

    // Modify Track to hold a Spotify Artist Object
    // Modify Front-end Model
    // Make appropriate changes to other back-end methods

    public static SpotifyTrack getTrackById(String id) {
        var getItemsRequest = spotifyApi.getTrack(id).build();
        try {
            var resultSet = getItemsRequest.execute();
            var artistMap = new HashMap<String, String>();
            for (var artist : resultSet.getArtists()) {
                artistMap.put(artist.getId(), artist.getName());
            }
            return new SpotifyTrack(resultSet.getId(), resultSet.getName(), artistMap, resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getDiscNumber(), resultSet.getDurationMs(), resultSet.getIsExplicit(), resultSet.getPopularity(), getAlbumById(resultSet.getAlbum().getId()), resultSet.getUri());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
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
//            System.out.println(user);
            // create and return the model
            spotify_user = new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), user.getImages()[0].getUrl());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return spotify_user;
    }

    public static SpotifyPlaylist createNewPlaylist(String name, String description) {
        if (description != null) {
            spotifyApi.changePlaylistsDetails("").description("").build();
        }
        CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
                .build();
        try {
//            System.out.println("In Create New Playlist!");
            var playlist = createPlaylistRequest.execute();

            if (description != null && !description.isBlank()) {
                var modifiedPlaylist = spotifyApi.changePlaylistsDetails(playlist.getId()).description(description).build().execute();
                return new SpotifyPlaylist(playlist.getName(), null, modifiedPlaylist, playlist.getExternalUrls().getExternalUrls().get("spotify"), playlist.getId(), null, playlist.getUri());
            }
            return new SpotifyPlaylist(playlist.getName(), null, null, playlist.getExternalUrls().getExternalUrls().get("spotify"), playlist.getId(), null, playlist.getUri());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // Return a playlist object -> update the front-end playlist object?
    // PUT mapping
    public static SpotifyPlaylist addToPlaylist(String playlistid, String... uri) {
//spotifyApi.unfollowPlaylist();
        AddItemsToPlaylistRequest addToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlistid, uri).build();
        try {
            var playlist = addToPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return getPlaylistById(playlistid);
    }

    public static void removePlaylist(String playlistid) {

        var unfollowPlaylistRequest = spotifyApi.unfollowPlaylist(playlistid).build();
        try {
            var playlist = unfollowPlaylistRequest.execute();
//            System.out.println("Removed Playlist!");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static SpotifyPlaylist removeTracksFromPlaylist(String playlist_id, JsonArray tracksArray) {
        var removeFromPlaylistRequest = spotifyApi.removeItemsFromPlaylist(playlist_id, tracksArray).build();
        try {
            var playlist = removeFromPlaylistRequest.execute();
//            System.out.println("Removed Track");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return getPlaylistById(playlist_id);
    }

    public static SpotifyArtist[] searchByArtist(String query) {
        var searchFromApiRequest = spotifyApi.searchArtists(query).build();
        try {
            var result = searchFromApiRequest.execute();
//            user.getExternalUrls().getExternalUrls().get("spotify");
            var tempArray = result.getItems();
            List<SpotifyArtist> artistList = new ArrayList<>();
            for (var artist : tempArray) {
//                System.out.println(artist);

                if (artist.getImages().length > 0) {
                    artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), artist.getImages()[0].getUrl(), artist.getPopularity(), artist.getUri()));

                } else {
                    artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), null, artist.getPopularity(), artist.getUri()));

                }

            }
//            System.out.println("In Connection: Got result from API!");
//            System.out.println(artistList.toString());
            return artistList.toArray(SpotifyArtist[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    // add a search album by id method
    // modify the track to hold an album object
    // create album model front and back
    // Album object: name, id, uri, url, image,  artist?

    public static SpotifyAlbum getAlbumById(String albumId) {
        var searchFromApiRequest = spotifyApi.getAlbum(albumId).build();
        try {
            var result = searchFromApiRequest.execute();

            var tempList = new ArrayList<String>();
            var artists = result.getArtists();
            for (var artist : artists) {
                tempList.add(artist.getName());
            }
            if (result.getImages().length > 0) {
                return new SpotifyAlbum(result.getName(), result.getId(), result.getImages()[0].getUrl(), tempList.toArray(String[]::new), result.getExternalUrls().getExternalUrls().get("spotify"), result.getUri(), result.getReleaseDate(), result.getLabel(), result.getGenres());

            } else {
                return new SpotifyAlbum(result.getName(), result.getId(), null, tempList.toArray(String[]::new), result.getExternalUrls().getExternalUrls().get("spotify"), result.getUri(), result.getReleaseDate(), result.getLabel(), result.getGenres());

            }
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }

    }

    public static SpotifyArtist getArtistById(String id) {
        var searchFromApiRequest = spotifyApi.getArtist(id).build();
        try {
            var result = searchFromApiRequest.execute();

            if (result.getImages().length < 1) {
                return new SpotifyArtist(result.getName(), result.getExternalUrls().getExternalUrls().get("spotify"), result.getFollowers().getTotal(), result.getGenres(), result.getId(), null, result.getPopularity(), result.getUri());

            } else {
                return new SpotifyArtist(result.getName(), result.getExternalUrls().getExternalUrls().get("spotify"), result.getFollowers().getTotal(), result.getGenres(), result.getId(), result.getImages()[0].getUrl(), result.getPopularity(), result.getUri());
            }
        } catch (ParseException | SpotifyWebApiException | IOException e) {
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
                var artistHashMap = new HashMap<String, String>();
                var artists = track.getArtists();
                for (var artist : artists) {
                    artistHashMap.put(artist.getId(), artist.getName());
                }

                trackList.add(new SpotifyTrack(track.getId(), track.getName(), artistHashMap, track.getExternalUrls().getExternalUrls().get("spotify"), track.getDiscNumber(), track.getDurationMs(), track.getIsExplicit(), track.getPopularity(), getAlbumById(track.getAlbum().getId()), track.getUri()));
//                artistList.add(new SpotifyArtist(artist.getName(), artist.getExternalUrls().getExternalUrls().get("spotify"), artist.getFollowers().getTotal(), artist.getGenres(), artist.getId(), artist.getImages()[0].getUrl(), artist.getPopularity(), artist.getUri()));
            }
//            System.out.println("In Connection: Got result from API!");
//            System.out.println(trackList.toString());
            return trackList.toArray(SpotifyTrack[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    public static SpotifyPlaylist reorderPlaylistItems(String playlist_id, Integer range_start, Integer insert_before) {
        var test = spotifyApi.reorderPlaylistsItems(playlist_id, range_start, insert_before).build();
        try {
            var result = test.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error in reorder playlist!");
        }
        return getPlaylistById(playlist_id);
    }

    public static SpotifyTrack[] getArtistTopTracks(String artistId) {

        var getArtistTopTracksRequest = spotifyApi.getArtistsTopTracks(artistId, CountryCode.getByLocale(Locale.US)).build();
        var spotifyTracksArray = new ArrayList<SpotifyTrack>();

        try {
            var result = getArtistTopTracksRequest.execute();
            var topTracks = Arrays.stream(result).limit(10).collect(Collectors.toList());

            for (var track : topTracks) {
                spotifyTracksArray.add(getTrackById(track.getId()));
            }
            return spotifyTracksArray.toArray(SpotifyTrack[]::new);


        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error in reorder playlist!");
            return null;
        }
    }

    // create the call to get albums of an artist

    public static SpotifyAlbum[] getArtistAlbums(String artistId) {
        var getArtistTopTracksRequest = spotifyApi.getArtistsAlbums(artistId).build();
//        var spotifyTracksArray = new ArrayList<SpotifyAlbum>();

        try {
            var result = getArtistTopTracksRequest.execute();
            return Arrays.stream(result.getItems())
                    .map((a) -> getAlbumById(a.getId()))
                    .collect(Collectors.toList())
                    .toArray(SpotifyAlbum[]::new);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error in reorder playlist!");
            return null;
        }
    }

    public static SpotifyPlaylist updatePlaylistDetails(String playlist_id, String playlist_name, String playlist_description) {
// need some check for the description? prolly not tbh
        // gonna have front-end checks for the name, so we should be gucci
        if (playlist_name != null) {
            var modifyPlaylistNameRequest = spotifyApi.changePlaylistsDetails(playlist_id).name(playlist_name).build();
            try {
                var a = modifyPlaylistNameRequest.execute();
                System.out.println("Modified the playlist name: " + a);
                if (playlist_description != null) {
                    System.out.println("In the Yes check: " + playlist_description);
                    spotifyApi.changePlaylistsDetails(playlist_id).description(playlist_description).build().execute();
                } else {
//                spotifyApi.changePlaylistsDetails(playlist_id).description(" ").build().execute();
                }
            } catch (IOException | SpotifyWebApiException | ParseException e) {
                System.out.println("Error in update playlist!");
            }
        }

        return getPlaylistById(playlist_id);
    }


}


