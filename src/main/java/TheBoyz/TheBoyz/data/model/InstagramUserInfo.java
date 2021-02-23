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
    private int followingCount;
    private int mediaCount;
    private String profilePicUrl;
    private String instaBio;
    private String[] imageFeed;


}
