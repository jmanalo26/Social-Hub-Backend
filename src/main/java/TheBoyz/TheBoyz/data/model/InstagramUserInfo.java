package TheBoyz.TheBoyz.data.model;

import lombok.*;

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
    private String profilePicUrl;
    private String displayName;
    private String UserName;
    private String instaBio;
    private String[] imageFeed;
    private String[] imageFeedCaption;
    private String[] imageFeedComment;
    private boolean followingStatus;


}
