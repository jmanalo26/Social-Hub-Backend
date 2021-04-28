package TheBoyz.TheBoyz.data.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "twitter_data")
public class TwitterData {

    @Id
    @NotNull
    @Column(name = "twitter_data_id")
    private int twitterSecureId;

    @NotNull
    @Column(name = "follower_count")
    private int followerCount;
    @NotNull
    @Column(name = "twitter_handle")
    private String twitterHandle;
    @NotNull
    @Column(name = "user_id")
    private int userId;
}
