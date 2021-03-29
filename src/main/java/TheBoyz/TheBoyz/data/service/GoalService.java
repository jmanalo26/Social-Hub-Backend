package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.Goal;
import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.data.repository.GoalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
@RestController
@Slf4j
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal findGoalByUserId(int userId) {
        return goalRepository.findByUserId(userId);
    }

    public Goal saveGoal(Goal goal) throws ValidationException {
        System.out.println("in the save goal service...");
        Goal searchedGoal = goalRepository.findByUserId(goal.getUserId());
        if(searchedGoal != null){
            System.out.println("it exists");
            goalRepository.delete(searchedGoal);
        }
//        System.out.println("the users id pulled form db: " + userWithId.getUserId());
        return goalRepository.save(goal);
    }

    public Goal updateGoal(Goal goal){
        return goalRepository.save(goal);
    }
}
