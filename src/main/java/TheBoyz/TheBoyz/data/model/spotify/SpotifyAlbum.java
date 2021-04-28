package TheBoyz.TheBoyz.data.model.spotify;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyAlbum {

    private String name;
    private String id;
    private String imageUrl;
    private String[] artistNames;
    private String spotifyUrl;
    private String spotifyUri;
    private String releaseDate;
    private String label;
    private String[] generes;

}
