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
public class TwitterRanking {

    private String rank;
    private int followerCount;
    private String name;

}
