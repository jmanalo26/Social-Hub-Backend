package TheBoyz.TheBoyz.api.SpotifyAPI;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class getAlbum {
    private static final String accessToken = "BQC_zvuFpWmEyELinD2LmZWlgwRw-XooC-YgVQ1yzUaOA8UT2HasXSipqRKhIodUSIbgijHnenFb65QZuJiXSSsVJuNR9aRd8y6VjRC6fxZcNJApJ0xcfOW9n7pNIJ9QGeV5jhcXiOIwfv6jf2SFjXbZgArBqBDNQ2H846rXyHpIzoQBZh5GGbb2Y2jOAaXBy5kNSiRCIZhDI3JiAPHZaBNbBNU8OdJwk26yoCsCmVZRvKzxaM2TVGDIPXLPNaC6DUiWwDynIfIdBpxaDpJcfIBPtT7MC_lMV8M";
    private static final String id = "5zT1JLIj9E57p3e1rFm9Uq";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken)
            .build();
    private static final GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(id)
//          .market(CountryCode.SE)
            .build();

    public static void getAlbum_Sync() {
        try {
            final Album album = getAlbumRequest.execute();

            System.out.println("Name: " + album.getName());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getAlbum_Async() {
        try {
            final CompletableFuture<Album> albumFuture = getAlbumRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final Album album = albumFuture.join();

            System.out.println("Name: " + album.getName());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
    }

    public static void main(String[] args) {
        getAlbum_Sync();
        getAlbum_Async();
    }
}
