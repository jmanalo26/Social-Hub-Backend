package TheBoyz.TheBoyz.data.model.spotify;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyTrack {
    private String id;
    private String name;
    private HashMap<String, String> artistInfo;
    private String spotifyUrl;
    private Integer diskNumber;
    private Integer duration;
    private Boolean explicit;
    private Integer popularity;
    private SpotifyAlbum album;
    private String spotifyUri;
}
