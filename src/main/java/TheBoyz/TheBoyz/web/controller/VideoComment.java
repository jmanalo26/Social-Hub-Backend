package TheBoyz.TheBoyz.web.controller;

public class VideoComment {
    private String videoId;
    private String videoComment;

    public VideoComment(String videoId, String videoComment) {
        this.videoId = videoId;
        this.videoComment = videoComment;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getVideoComment() {
        return videoComment;
    }
}
