package TheBoyz.TheBoyz.data.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

/**
 * The Class for the Tweet Object
 */
public class Tweet {
    private String tweetText;
    private String tweetCreatedBy;
}
