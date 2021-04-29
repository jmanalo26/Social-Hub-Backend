package TheBoyz.TheBoyz.data.model;

import lombok.*;

import java.io.File;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class InstagramUserInfo {


    private int followerCount;
    private String[] followerFeed;
    private int followingCount;
    private int mediaCount;
    private byte[] profilePicUrl;
    private String displayName;
    private String UserName;
    private String instaBio;
    private String[] imageFeed;
    private String[] imageFeedCaption;
    private String[] imageFeedComment;
    private String[] imageFeedTopLikes;
    private Integer[] imageFeedLikes;
    private ArrayList<byte[]> images;
    private ArrayList<byte[]> followerProfilePics;

    private boolean followingStatus;


}
