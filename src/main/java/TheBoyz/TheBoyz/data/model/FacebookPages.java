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
public class FacebookPages {
    private ArrayList<String> pageNames;
    private ArrayList<String> pageURLs;
    private ArrayList<String> pageFans;
    private ArrayList<String> likedNames;
    private ArrayList<String> likedLinks;
}
