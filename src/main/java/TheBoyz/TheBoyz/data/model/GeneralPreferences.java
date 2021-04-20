package TheBoyz.TheBoyz.data.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "general_preferences")
public class GeneralPreferences {

    @Id
    @NotNull
    @Column(name = "general_preferences_id")
    int generalPreferencesId;

    @Column(name = "twitter_feed")
    boolean twitterFeed;

    @Column(name = "instagram_feed")
    boolean instagramFeed;

    @Column(name = "facebook_feed")
    boolean facebookFeed;

    @Column(name = "user_id")
    int userId;

    @Column(name = "on_login")
    String onLogin;

}
