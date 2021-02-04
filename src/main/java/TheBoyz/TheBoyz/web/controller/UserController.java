package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.data.service.UserService;
import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;


    public UserController(final UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/api/user")
    public ResponseEntity<User> createUser(@RequestBody User user)  {
       return null;
    }

}
