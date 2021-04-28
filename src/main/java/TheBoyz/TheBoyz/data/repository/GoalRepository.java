package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.Goal;
import TheBoyz.TheBoyz.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    public Goal findByUserId(int userId);

}
