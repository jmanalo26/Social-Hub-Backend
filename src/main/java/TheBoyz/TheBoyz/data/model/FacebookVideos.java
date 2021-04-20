package TheBoyz.TheBoyz.data.model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FacebookVideos {
    private ArrayList<String> sources;
    private ArrayList<String> thumbnails;
}
