package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.spotify.*;
import com.google.gson.JsonArray;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.enums.ModelObjectType;
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
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SpotifyService {

    private static final String clientId = "0e23f91af6cb403e9f23852a496b803f";
    private static final String clientSecret = "84f1f4ab297a4a2dbb1219a2bafe75fa";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/spotify/authentication/");
    private static String userId = "";


    // Setting up the api to make service calls

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();
    private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            .scope("user-read-private,user-read-email,user-read-recently-played,user-read-playback-state,user-top-read,playlist-modify-public,user-modify-playback-state,playlist-modify-private,user-follow-modify,user-read-currently-playing,user-follow-read,user-library-modify,user-read-playback-position,playlist-read-private,user-library-read,playlist-read-collaborative,streaming")
            .show_dialog(true)
            .build();

    // authorization

    public static String authorizationCodeUri_Sync() {
        final URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }

    public static void authorizationCode_Sync(String code) {
        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                .build();
        try {
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();
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

    // ----------------- User's Stuff Here ---------------------------------------

    public static SpotifyUser getCurrentUsersProfile_Sync() {
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        try {
            final User user = getCurrentUsersProfileRequest.execute();
            userId = user.getId();
            if (user.getImages().length == 0) {
                return new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), "https://img.favpng.com/3/7/23/login-google-account-computer-icons-user-png-favpng-ZwgqcU6LVRjJucQ9udYpX00qa.jpg");
            } else {
                return new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), user.getImages()[0].getUrl());
            }
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    public static SpotifyUser getUserProfileById(String id) {
        var getUserProfileByIdRequest = spotifyApi.getUsersProfile(id).build();
        try {
            var user = getUserProfileByIdRequest.execute();
            if (user.getImages().length == 0) {
                return new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), "https://img.favpng.com/3/7/23/login-google-account-computer-icons-user-png-favpng-ZwgqcU6LVRjJucQ9udYpX00qa.jpg");
            } else {
                return new SpotifyUser(user.getDisplayName(), user.getId(), user.getBirthdate(), user.getEmail(), user.getCountry().getName(), user.getExternalUrls().getExternalUrls().get("spotify"), user.getUri(), user.getImages()[0].getUrl());
            }

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }


    public static SpotifyPlaylistSnapshot[] getCurrentUserPlaylists() {
        final GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylistsRequest = spotifyApi
                .getListOfCurrentUsersPlaylists()
                .build();
        try {
            final var playlistSimplifiedPaging = getListOfCurrentUsersPlaylistsRequest.executeAsync();
            return Arrays.stream(playlistSimplifiedPaging.get().getItems())
                    .map(playlist -> getPlaylistSnapshotById(playlist.getId()))
                    .toArray(SpotifyPlaylistSnapshot[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyTrack[] getUserFollowedTracks() {
        var getUserFollowedTracksRequest = spotifyApi.getUsersSavedTracks().limit(50).build();
        try {
            var result = getUserFollowedTracksRequest.executeAsync();
            return Arrays.stream(result.get().getItems())
                    .map((a) -> getTrackById(a.getTrack().getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
            return null;
        }
    }

    public static SpotifyTrack[] getUserTopTracks() {
        var getUserTopTracksRequest = spotifyApi.getUsersTopTracks().limit(10).build();
        try {
            var resultTrackSet = getUserTopTracksRequest.executeAsync();
            return Arrays.stream(resultTrackSet.get().getItems())
                    .map(track -> getTrackById(track.getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyTrack[] getRecentlyPlayedTracks() {
        var getRecentlyPlayedTracksRequest = spotifyApi.getCurrentUsersRecentlyPlayedTracks().limit(10).build();
        try {
            return Arrays.stream(getRecentlyPlayedTracksRequest.executeAsync().get().getItems())
                    .map(track -> getTrackById(track.getTrack().getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyArtist[] getUserFollowedArtists() {
        var getFavouritedArtistsRequest = spotifyApi.getUsersFollowedArtists(ModelObjectType.ARTIST).limit(50).build();
        try {
            return Arrays.stream(getFavouritedArtistsRequest.executeAsync().get().getItems())
                    .map(artist -> getArtistById(artist.getId()))
                    .toArray(SpotifyArtist[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyAlbum[] getUserFollowedAlbums() {
        var getFavouritedAlbumsRequest = spotifyApi.getCurrentUsersSavedAlbums().build();
        try {
            return Arrays.stream(getFavouritedAlbumsRequest.executeAsync().get().getItems())
                    .map(album -> getAlbumById(album.getAlbum().getId())).toArray(SpotifyAlbum[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    // ----------------- Getting Playlist Details & Modifying it Here ---------------------------------------


    public static SpotifyPlaylist getPlaylistById(String playlist_id) {
        var getPlaylistRequest = spotifyApi.getPlaylist(playlist_id).build();
        try {
            var resultSet = getPlaylistRequest.executeAsync().get();
            if (resultSet.getImages().length > 0) {
                return new SpotifyPlaylist(resultSet.getName(), getTracksFromPlaylistById(playlist_id), resultSet.getDescription(), resultSet.getOwner().getId(), resultSet.getOwner().getDisplayName(), resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getId(), resultSet.getImages()[0].getUrl(), resultSet.getUri());
            } else {
                return new SpotifyPlaylist(resultSet.getName(), getTracksFromPlaylistById(playlist_id), resultSet.getDescription(), resultSet.getOwner().getId(), resultSet.getOwner().getDisplayName(), resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getId(), null, resultSet.getUri());
            }
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyPlaylistSnapshot getPlaylistSnapshotById(String playlist_id) {
        var getPlaylistRequest = spotifyApi.getPlaylist(playlist_id).build();
        try {
            var result = getPlaylistRequest.executeAsync().get();
            if (result.getImages().length > 0) {
                return new SpotifyPlaylistSnapshot(result.getId(), result.getName(), result.getDescription(), result.getOwner().getId(), result.getOwner().getDisplayName(), result.getImages()[0].getUrl());
            } else {
                return new SpotifyPlaylistSnapshot(result.getId(), result.getName(), result.getDescription(), result.getOwner().getId(), result.getOwner().getDisplayName(), null);
            }
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyTrack[] getTracksFromPlaylistById(String id) {
        var getItemsRequest = spotifyApi.getPlaylistsItems(id).build();
        try {
            return Arrays.stream(getItemsRequest.executeAsync().get().getItems())
                    .map(track -> getTrackById(track.getTrack().getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyPlaylist createNewPlaylist(String name, String description) {
        if (description != null) {
            spotifyApi.changePlaylistsDetails("").description("").build();
        }
        CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
                .build();
        try {
            var playlist = createPlaylistRequest.execute();

            if (description != null && !description.isBlank()) {
                var modifiedPlaylist = spotifyApi.changePlaylistsDetails(playlist.getId()).description(description).build().execute();
                return new SpotifyPlaylist(playlist.getName(), null, modifiedPlaylist, playlist.getOwner().getId(), playlist.getOwner().getDisplayName(), playlist.getExternalUrls().getExternalUrls().get("spotify"), playlist.getId(), null, playlist.getUri());
            }
            return new SpotifyPlaylist(playlist.getName(), null, null, playlist.getOwner().getId(), playlist.getOwner().getDisplayName(), playlist.getExternalUrls().getExternalUrls().get("spotify"), playlist.getId(), null, playlist.getUri());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // Return a playlist object -> update the front-end playlist object?
    // PUT mapping
    public static SpotifyTrack[] addToPlaylist(String playlist_id, String... uri) {
//spotifyApi.unfollowPlaylist();
        AddItemsToPlaylistRequest addToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlist_id, uri).build();
        try {
            addToPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return getTracksFromPlaylistById(playlist_id);
    }

    public static void removePlaylist(String playlistid) {
        var unfollowPlaylistRequest = spotifyApi.unfollowPlaylist(playlistid).build();
        try {
            unfollowPlaylistRequest.execute();
//            System.out.println("Removed Playlist!");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static SpotifyTrack[] removeTracksFromPlaylist(String playlist_id, JsonArray tracksArray) {
        var removeFromPlaylistRequest = spotifyApi.removeItemsFromPlaylist(playlist_id, tracksArray).build();
        try {
            removeFromPlaylistRequest.execute();
//            System.out.println("Removed Track");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return getTracksFromPlaylistById(playlist_id);
    }

    public static SpotifyPlaylist reorderPlaylistItems(String playlist_id, Integer range_start, Integer insert_before) {
        var test = spotifyApi.reorderPlaylistsItems(playlist_id, range_start, insert_before).build();
        try {
            test.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error in reorder playlist!");
        }
        return getPlaylistById(playlist_id);
    }

    public static SpotifyPlaylist updatePlaylistDetails(String playlist_id, String playlist_name, String playlist_description) {
        if (playlist_name != null) {
            var modifyPlaylistNameRequest = spotifyApi.changePlaylistsDetails(playlist_id).name(playlist_name).build();
            try {
                var a = modifyPlaylistNameRequest.execute();
                if (playlist_description != null) {
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


    // ----------------- Getting Track Details---------------------------------------


    // Tuesday at 1
    public static SpotifyTrack getTrackById(String id) {
        var getItemsRequest = spotifyApi.getTrack(id).build();
        try {
            var resultSet = getItemsRequest.executeAsync().get();
            HashMap<String, String> artistMap = Arrays.stream(resultSet.getArtists())
                    .collect(HashMap::new, (map, artist) -> map.put(artist.getId(), artist.getName()), (combiner, map) -> combiner.putAll(map));
            return new SpotifyTrack(resultSet.getId(), resultSet.getName(), artistMap, resultSet.getExternalUrls().getExternalUrls().get("spotify"), resultSet.getDiscNumber(), resultSet.getDurationMs(), resultSet.getIsExplicit(), resultSet.getPopularity(), getAlbumById(resultSet.getAlbum().getId()), resultSet.getUri());
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }

    }


    // ----------------- Getting Artist stuff ---------------------------------------

    public static SpotifyArtist getArtistById(String id) {
        var getArtistByIdRequest = spotifyApi.getArtist(id).build();
        try {
            var result = getArtistByIdRequest.executeAsync().get();

            if (result.getImages().length < 1) {
                return new SpotifyArtist(result.getName(), result.getExternalUrls().getExternalUrls().get("spotify"), result.getFollowers().getTotal(), result.getGenres(), result.getId(), "https://img.favpng.com/3/7/23/login-google-account-computer-icons-user-png-favpng-ZwgqcU6LVRjJucQ9udYpX00qa.jpg", result.getPopularity(), result.getUri());

            } else {
                return new SpotifyArtist(result.getName(), result.getExternalUrls().getExternalUrls().get("spotify"), result.getFollowers().getTotal(), result.getGenres(), result.getId(), result.getImages()[0].getUrl(), result.getPopularity(), result.getUri());
            }
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyTrack[] getArtistTopTracks(String artistId) {

        var getArtistTopTracksRequest = spotifyApi.getArtistsTopTracks(artistId, CountryCode.getByLocale(Locale.US)).build();
        try {
            var result = getArtistTopTracksRequest.executeAsync();
            return Arrays.stream(result.get()).limit(10).map(track -> getTrackById(track.getId()))
                    .toArray(SpotifyTrack[]::new);

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error in artist top tracks!");
            return null;
        }
    }

    public static SpotifyAlbum[] getArtistAlbums(String artistId) {
        var getArtistTopTracksRequest = spotifyApi.getArtistsAlbums(artistId).build();
        try {
            var result = getArtistTopTracksRequest.executeAsync();
            return Arrays.stream(result.get().getItems())
                    .map((a) -> getAlbumById(a.getId()))
                    .toArray(SpotifyAlbum[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    // ----------------- Getting Album Stuff ---------------------------------------

    public static SpotifyAlbum getAlbumById(String albumId) {
        var searchFromApiRequest = spotifyApi.getAlbum(albumId).build();
        try {
            var result = searchFromApiRequest.executeAsync().get();
            String[] artistNames = Arrays.stream(result.getArtists()).map(artist -> artist.getName()).toArray(String[]::new);
            if (result.getImages().length > 0) {
                return new SpotifyAlbum(result.getName(), result.getId(), result.getImages()[0].getUrl(), artistNames, result.getExternalUrls().getExternalUrls().get("spotify"), result.getUri(), result.getReleaseDate(), result.getLabel(), result.getGenres());
            } else {
                return new SpotifyAlbum(result.getName(), result.getId(), null, artistNames, result.getExternalUrls().getExternalUrls().get("spotify"), result.getUri(), result.getReleaseDate(), result.getLabel(), result.getGenres());
            }
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    // ----------------- Favouriting Stuff ---------------------------------------

    public static Boolean followArtist(String... artistId) {
        var followArtistRequest = spotifyApi.followArtistsOrUsers(ModelObjectType.ARTIST, artistId).build();
        try {
            followArtistRequest.execute();
            return true;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
        }
        return false;
    }

    public static Boolean unfollowArtist(String... artistId) {
        var unfollowArtistRequest = spotifyApi.unfollowArtistsOrUsers(ModelObjectType.ARTIST, artistId).build();
        try {
            unfollowArtistRequest.execute();
            return true;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
        }
        return false;
    }

    public static Boolean checkUserFollowArtist(String... artistId) {
        var checkUserFollowArtistRequest = spotifyApi.checkCurrentUserFollowsArtistsOrUsers(ModelObjectType.ARTIST, artistId).build();
        try {
            return checkUserFollowArtistRequest.executeAsync().get()[0];
        } catch (InterruptedException | ExecutionException e) {
            return false;
        }
    }

    public static Boolean favouriteTrack(String... track_ids) {
        var followTrackRequest = spotifyApi.saveTracksForUser(track_ids).build();
        try {
            followTrackRequest.execute();
            return true;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
        }
        return false;
    }

    public static Boolean unfavouriteTrack(String... track_ids) {
        var unfollowTrackRequest = spotifyApi.removeUsersSavedTracks(track_ids).build();
        try {
            unfollowTrackRequest.execute();
            return true;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
        }
        return false;
    }

    public static Boolean[] checkFavouriteTrack(String... track_ids) {
        var checkFavouriteRequest = spotifyApi.checkUsersSavedTracks(track_ids).build();
        try {
            return checkFavouriteRequest.executeAsync().get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    // ----------------- Query/ Search for stuff ---------------------------------------

    public static SpotifyArtist[] searchByArtist(String query) {

        var searchFromApiRequest = spotifyApi.searchArtists(query).build();
        try {
            return Arrays.stream(searchFromApiRequest.executeAsync().get().getItems())
                    .map(artist -> getArtistById(artist.getId()))
                    .toArray(SpotifyArtist[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }


    public static SpotifyTrack[] searchByTrack(String query) {

        var searchFromApiRequest = spotifyApi.searchTracks(query).build();
        try {
            return Arrays.stream(searchFromApiRequest.executeAsync().get().getItems())
                    .map(track -> getTrackById(track.getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    // ----------------- Recommendations ---------------------------------------

//    public static SpotifyTrack[] getRecommendations() {
//        var getRecommendationsRequest = spotifyApi.getRecommendations().build();
//
//        return null;
//    }


    public static SpotifyArtist[] getRecommendedArtists(String artist_id) {
        var getRecommendedArtistsRequest = spotifyApi.getArtistsRelatedArtists(artist_id).build();

        try {
            var resultSet = getRecommendedArtistsRequest.executeAsync();
//            System.out.println(resultSet);
            return Arrays.stream(resultSet.get()).map(artist -> getArtistById(artist.getId())).toArray(SpotifyArtist[]::new);
        } catch (InterruptedException | ExecutionException e) {
        }
        return null;
    }


    public static SpotifyAlbum[] getNewReleases() {
        var getNewReleasesRequest = spotifyApi.getListOfNewReleases().limit(15).country(CountryCode.getByLocale(Locale.US)).build();
        try {
            return Arrays.stream(getNewReleasesRequest.executeAsync().get().getItems())
                    .map(album -> getAlbumById(album.getId()))
                    .toArray(SpotifyAlbum[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyTrack[] getRecommendedTracks(String track_ids) {
        var getRecommendedTracksRequest = spotifyApi.getRecommendations().seed_tracks(track_ids).limit(10).build();
        try {
            return Arrays.stream(getRecommendedTracksRequest.executeAsync().get().getTracks())
                    .map(track -> getTrackById(track.getId()))
                    .toArray(SpotifyTrack[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static SpotifyPlaylistSnapshot[] getFeaturedPlaylists() {
        var getFeaturedPlaylistsRequest = spotifyApi.getListOfFeaturedPlaylists().country(CountryCode.getByLocale(Locale.US)).limit(10).build();

        try {
            return Arrays.stream(getFeaturedPlaylistsRequest.executeAsync().get().getPlaylists().getItems())
                    .map(playlist -> getPlaylistSnapshotById(playlist.getId()))
                    .toArray(SpotifyPlaylistSnapshot[]::new);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }


}


