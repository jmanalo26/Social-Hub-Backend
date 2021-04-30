package TheBoyz.TheBoyz.data.model;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
/**
 * The class for only important variables from the status object.
 */
public class BriefStatus {
    private Date createdAt;
    private String text;
    private int favoriteCount;
    private int retweetCount;
    private String screenName;
    private String handle;
    private String mediaURL;

}
