package TheBoyz.TheBoyz.data.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "one_posts")
public class OnePosts {

    @Id
    @NotNull
    @Column(name = "one_posts_id")
    private int onePostId;


    @Column(name = "text_content")
    private String textContent;


    @Column(name = "image")
    private byte[] image;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "social_media")
    private String socialMedia;
}
