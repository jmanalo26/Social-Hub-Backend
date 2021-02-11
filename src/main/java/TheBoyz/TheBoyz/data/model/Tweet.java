package TheBoyz.TheBoyz.data.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Tweet {
    private String tweetText;
    private String tweetCreatedBy;
}
