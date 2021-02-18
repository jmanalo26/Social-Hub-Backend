package TheBoyz.TheBoyz.data.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SpotifyTrack {
    private String name;
    private String[] artistNames;
    private String spotifyUrl;
    private Integer diskNumber;
    private Integer duration;
    private Boolean explicit;
    private Integer popularity;

}
