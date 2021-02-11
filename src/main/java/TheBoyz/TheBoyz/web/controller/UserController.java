package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.data.service.UserService;
import TheBoyz.TheBoyz.web.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/user")
    public ResponseEntity<User> createUser(@RequestBody User user)  {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/get-user")
    public ResponseEntity<User> getUser()  {
        System.out.println("in the tiwtter controller for get followers");
        return new ResponseEntity<>(userService.getUser("user1"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/retrieve/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username)  {
        System.out.println("in the user controller to get a user by username");
        System.out.println(username);
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping(value = "/api/twitter/followers")
//    public ResponseEntity<User> saveUser() throws TwitterException {
//        System.out.println("in the tiwtter controller for get followers");
//        return new ResponseEntity<User>(twitterService.getFollowerCount(), HttpStatus.OK);
//
//    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/user/newUser")
    public User save(@RequestBody User user, BindingResult bindingResult) throws ValidationException {
        System.out.println("****");
        if (bindingResult.hasErrors()) {
            throw new ValidationException("exception thrown in the backend");
        }
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPhoneNumber());
        user.getUserId();
//        Optional<User> check = userRepository.findByStudentId(user.getStudentId());
        User newUser = new User();
//        newUser.setUserId(user.getUserId());
//        newUser.setFirstName(user.getFirstName());
//        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUsername((user.getUsername()));
        System.out.println(user.getUsername());
        // save note instance to db
        this.userService.saveUser(newUser);
        System.out.println("attempting save");
        return newUser;
    }

}
