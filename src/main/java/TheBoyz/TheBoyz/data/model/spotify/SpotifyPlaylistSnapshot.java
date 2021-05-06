package TheBoyz.TheBoyz.data.model.spotify;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyPlaylistSnapshot {
    private String id;
    private String name;
    private String description;
    private String ownerId;
    private String ownerName;
    private String imageUrl;

}
