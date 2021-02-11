package TheBoyz.TheBoyz.api.SpotifyAPI;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class getUserCurrentProfile {

    public static void getCurrentUsersProfile_Sync(String accessToken) {
        final SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();

        try {
            final User user = getCurrentUsersProfileRequest.execute();

            System.out.println("Display name: " + user.getDisplayName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("External URL: " + user.getExternalUrls());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getCurrentUsersProfile_Sync("BQBiPYUiJE1t0TXjwIukkhZsMiow_DNQScO9KJkZVh_RdQZhCGAtp0MNlRWJsV5gbck1YXcuiq3PakLD-dWEO9-z0gLj1bXol-tvj5NyDSd04q41lF_0ua0FC1PmNcsOAqPwM0msARuku_ZLxyzYqsm7zGLPn2Yg_sAjjGmwsYbJVrlexX57jktculvWXGBiecsTAbDx2IuGZihm_qjYivbKFDEdoDmAUU2WvYx11Bpi9fB8fJXlEGntnSu9YF5kvd23qdzLgU5jC8RgmGBYhfix7TUMIhEm_go");
    }
}
