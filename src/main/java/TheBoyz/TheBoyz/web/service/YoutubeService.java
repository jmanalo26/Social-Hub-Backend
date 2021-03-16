package TheBoyz.TheBoyz.web.service;

import TheBoyz.TheBoyz.data.model.Youtube;
import TheBoyz.TheBoyz.data.repository.YoutubeRepository;
import TheBoyz.TheBoyz.web.controller.Channel;
import TheBoyz.TheBoyz.web.controller.Video;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.PlaylistListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
@Service
public class YoutubeService {

    private final String CLIENT_SECRETS = "src/main/resources/client_secret.json";
    private final Collection<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");
    private final String APPLICATION_NAME = "API code samples";
    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static YouTube youTube;
    private int numCalls = 0;
    private final YoutubeRepository youtubeRepository;

    public YoutubeService(final YoutubeRepository youtubeRepository) throws GeneralSecurityException, IOException {
        this.youtubeRepository = youtubeRepository;
        youTube = getService();
    }


    public Credential authorize(final NetHttpTransport httpTransport) throws IOException {
        FileInputStream fis=new FileInputStream(new File(CLIENT_SECRETS));
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(fis));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver.Builder().setHost("localhost").setPort(8080).build()).authorize("user");
        return credential;
    }

    public YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = authorize(httpTransport);

        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public ArrayList<String> getVideos() throws IOException {
        System.out.println(++numCalls);
        YouTube.Search.List request = youTube.search().list("snippet");
        SearchListResponse response = request.setForMine(true)
                .setMaxResults(25L)
                .setType("video")
                .execute();
        JSONObject object = new JSONObject(response.toString());
        JSONArray items = object.getJSONArray("items");
        System.out.println(items);
        ArrayList<String> videoArr = new ArrayList<String>();
        String youtubelink = "https://www.youtube.com/embed/";
        for(int i = 0; i < items.length(); i++) {
            String videoId = (String) items.getJSONObject(i).getJSONObject("id").get("videoId");
            String videoDescription = (String) items.getJSONObject(i).getJSONObject("snippet").get("description");
            String fullVideoId = youtubelink + videoId;
            Video video = new Video(fullVideoId, videoDescription);
            ObjectMapper o = new ObjectMapper();
            o.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            String videoString = o.writeValueAsString(video);
            videoArr.add(videoString);
        }
        return videoArr;
    }


    public String getChannelInfo() throws IOException {
        // Define and execute the API request
        System.out.println(++numCalls);
        YouTube.Channels.List request = youTube.channels()
                .list("snippet,contentDetails,statistics");
        ChannelListResponse response = request.setMine(true).execute();
        JSONObject object = new JSONObject(response.toString());
        JSONArray items = object.getJSONArray("items");
        String channelId = "https://www.youtube.com/channel/" + (String) items.getJSONObject(0).get("id");
        String profilePhoto = (String) items.getJSONObject(0).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").get("url");
        String username = (String) items.getJSONObject(0).getJSONObject("snippet").getJSONObject("localized").get("title");
        Channel c = new Channel(channelId, profilePhoto, username);
        ObjectMapper o = new ObjectMapper();
        o.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String videoString = o.writeValueAsString(c);

        return videoString;
    }

    public ArrayList<String> getUserPlaylist() throws IOException {
        System.out.println(++numCalls);
        // Define and execute the API request
        YouTube.Playlists.List request = youTube.playlists()
                .list("snippet,contentDetails");
        PlaylistListResponse response = request.setMaxResults(100L)
                .setMine(true)
                .execute();
        JSONObject object = new JSONObject(response.toString());
        JSONArray items = object.getJSONArray("items");
        ArrayList<String> playlistArr = new ArrayList<String>();
        String youtubeLink = "https://www.youtube.com/embed/videoseries?list=";
        for(int i = 0; i < items.length(); i++) {
            String playlistId = (String) items.getJSONObject(i).get("id");
            playlistArr.add(youtubeLink + playlistId);
        }
        return playlistArr;
    }

    public ArrayList<String> getLikedVideos() throws IOException {
        System.out.println(++numCalls);
        YouTube.Videos.List request = youTube.videos()
                .list("snippet,contentDetails,statistics");
        VideoListResponse response = request.setMyRating("like").execute();
        JSONObject object = new JSONObject(response.toString());
        JSONArray items = object.getJSONArray("items");
        ArrayList<String> likedVideoArr = new ArrayList<String>();
        String youtubelink = "https://www.youtube.com/embed/";
        for(int i = 0; i < items.length(); i++) {
            String videoId = (String) items.getJSONObject(i).get("id");
            String videoDescription = (String) items.getJSONObject(i).getJSONObject("snippet").get("description");
            String fullVideoId = youtubelink + videoId;
            Video video = new Video(fullVideoId, videoDescription);
            ObjectMapper o = new ObjectMapper();
            o.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            String videoString = o.writeValueAsString(video);
            likedVideoArr.add(videoString);
        }
        return likedVideoArr;
    }

    public Youtube saveUser(Youtube user) {
        Youtube chan_id = youtubeRepository.findUserByChannelId(user.getChannel_id());
        if (chan_id == null) {
            System.out.println("in save User");
            youtubeRepository.save(user);
        }
        return user;
    }


}