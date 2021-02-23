package TheBoyz.TheBoyz.data.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyPlaylist {
    private String name;
    private SpotifyTrack[] tracks;
    private String spotifyUrl;
    private String id;
    private String imageUrl;
    private String spotifyUri;

}
