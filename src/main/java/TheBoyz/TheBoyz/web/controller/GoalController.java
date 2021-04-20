package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.Goal;
import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.data.service.GoalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
@Slf4j
@RestController
public class GoalController {

    private final GoalService goalService;

    public GoalController(final GoalService goalService) {
        this.goalService = goalService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/goals/get-goals/{userId}")
    public ResponseEntity<Goal> getGoals(@PathVariable String userId) {
        System.out.println("GOAL CONTROLLER");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("getting the goal by their login info");
        System.out.println(userId);
        return new ResponseEntity<>(goalService.findGoalByUserId(Integer.valueOf(userId)), HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/set-goals")
    public ResponseEntity<Goal> setGoals(@RequestBody Goal goal, BindingResult bindingResult) throws ValidationException {
        System.out.println("getting the goal by their login info");
        return new ResponseEntity<>(goalService.saveGoal(goal), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/api/update-goals")
    public ResponseEntity<Goal> updateGoals(@RequestBody Goal goal, BindingResult bindingResult) throws ValidationException {
        System.out.println("getting the goal by their login info");
        return new ResponseEntity<>(goalService.updateGoal(goal), HttpStatus.OK);
    }
}
