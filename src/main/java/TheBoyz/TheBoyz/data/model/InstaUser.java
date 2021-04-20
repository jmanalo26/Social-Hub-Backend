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
@Table(name = "instagram")

public class InstaUser {

    @Id
    @NotNull
    @Column(name = "InstaId")
    private int instaId;


    @NotNull
    @Column(name = "username")
    private String username;


    @NotNull
    @Column(name = "password")
    private String password;
}
