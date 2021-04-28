package TheBoyz.TheBoyz.data.model;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FacebookPagePosts {
    private ArrayList<String> pagePosts;
    private ArrayList<String> times;
}
