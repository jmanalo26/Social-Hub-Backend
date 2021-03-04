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
@Table(name = "twitter_secure")
public class SecureTwitter {

    @Id
    @NotNull
    @Column(name = "twitter_secure_id")
    private int twitterSecureId;

    @NotNull
    @Column(name = "api_key")
    private String consumerKey;
    @NotNull
    @Column(name = "api_secret_key")
    private String consumerSecret;
    @NotNull
    @Column(name = "access_token")
    private String accessToken;
    @NotNull
    @Column(name = "access_token_secret")
    private String  accessTokenSecret;
    @NotNull
    @Column(name = "twitter_handle")
    private String  twitterHandle;

    @NotNull
    @Column(name = "user_id")
    private int userId;

}
