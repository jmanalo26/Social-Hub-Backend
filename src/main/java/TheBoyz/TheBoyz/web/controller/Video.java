package TheBoyz.TheBoyz.web.controller;

public class Video {
    private String videoId;
    private String videoDescription;
    private VideoDetails videoDetails;

    public Video(String videoId, String videoDescription) {
        this.videoId = videoId;
        this.videoDescription = videoDescription;
    }
    public Video(String videoId, String videoDescription, VideoDetails videoDetails) {
        this.videoId = videoId;
        this.videoDescription = videoDescription;
        this.videoDetails = videoDetails;
    }
}
