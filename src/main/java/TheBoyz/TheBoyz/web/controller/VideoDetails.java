package TheBoyz.TheBoyz.web.controller;

public class VideoDetails {
    private String duration;
    private Long views;
    private Long likes;
    private Long dislikes;
    private Long favorites;
    private Long comments;
    private String published;

    public VideoDetails(String duration, Long views, Long likes, Long dislikes, Long favorites, Long comments, String published) {
        this.duration = duration;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.favorites = favorites;
        this.comments = comments;
        this.published = published;
    }
}
