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
@Table(name = "goals")
public class Goal {

    @Id
    @NotNull
    @Column(name = "goals_id")
    private int goalId;

    @Column(name = "total_twitter_followers")
    private int totalTwitterFollowers;

    @Column(name = "goal_end_number")
    private int goalEndNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "goal_start_number")
    private int goalStartNumber;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "goal_max_number")
    private int goalMaxNumber;

    @Column(name = "goal_type")
    private String goalType;

}
