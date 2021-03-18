package TheBoyz.TheBoyz.web.controller;

import java.util.ArrayList;

public class Channel {
    private String channelId;
    private String profilePhoto;
    private String username;
    private ArrayList<Video> videos;
    private ArrayList<String> playlists;
    private ArrayList<Video> liked;
    private String viewCount;
    private String subscriberCount;
    private String videoCount;

    public Channel(String channelId, String profilePhoto, String username, ArrayList<Video> videos, ArrayList<String> playlists, ArrayList<Video> liked, String viewCount, String subscriberCount, String videoCount) {
        this.channelId = channelId;
        this.profilePhoto = profilePhoto;
        this.username = username;
        this.videos = videos;
        this.playlists = playlists;
        this.liked = liked;
        this.viewCount = viewCount;
        this.subscriberCount = subscriberCount;
        this.videoCount = videoCount;
    }
}
