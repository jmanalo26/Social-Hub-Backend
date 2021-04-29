package TheBoyz.TheBoyz.data.model.spotify;

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
    private String description;
    private String ownerId;
    private String ownerName;
    private String spotifyUrl;
    private String id;
    private String imageUrl;
    private String spotifyUri;
//TODO: MODIFY MODEL TO HAVE AN OWNER ID AND NAME
}
