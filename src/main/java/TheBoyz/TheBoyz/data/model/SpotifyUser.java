package TheBoyz.TheBoyz.data.model;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyUser {
    private String displayName;
    private String id;
    private String birthdate;
    private String email;
    private String country;
    private String spotifyUrl;
    private String spotifyUri;
    private String imageUrl;
}

