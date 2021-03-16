package TheBoyz.TheBoyz.data.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "youtube")
public class Youtube {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    @NotNull
    @Column(name = "channelId")
    private String channelId;

    @NotNull
    @Column(name = "profile_pic")
    private String profile_pic;

    @NotNull
    @Column(name = "username")
    private String username;


    public Long getUser_id() {
        return userId;
    }

    public String getChannel_id() {
        return channelId;
    }

    public String getProfile_photo() {
        return profile_pic;
    }

    public String getUsername() {
        return username;
    }

}
