package TheBoyz.TheBoyz.data.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyArtist {
    private String name;
    private String spotifyUrl;
    private Integer followers;
    private String[] genres;
    private String id;
    private String imageUrl;
    private Integer popularity;
    private String spotifyUri;

}
