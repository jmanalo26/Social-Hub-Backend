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
@Table(name = "facebook_secure")
public class FacebookUser {
    @Id
    @NotNull
    @Column(name = "facebook_ID")
    private int facebookID;

    @NotNull
    @Column(name = "facebook_name")
    private String facebookName;

    @NotNull
    @Column(name = "facebook_accessToken")
    private String facebookToken;

    @NotNull
    @Column(name = "facebook_email")
    private String facebookEmail;

    @NotNull
    @Column(name = "facebook_birthday")
    private String facebookDOB;

    private String photoURL;
}
