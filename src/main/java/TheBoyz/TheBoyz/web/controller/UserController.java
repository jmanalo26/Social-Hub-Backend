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

/**
 *
 */
@Slf4j
@RestController
/**
 * The class that calls all api and database calls from the user service.
 */
public class UserController {

    private final UserService userService;

    /**
     *The constructor for the user controller.
     * @param userService the service that makes api and database calls.
     */
    public UserController(final UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/retrieve/{email}/{password}")
    public ResponseEntity<User> getUserByLogIn(@PathVariable String email, @PathVariable String password) {
        System.out.println("getting the user by their login info");
        return new ResponseEntity<>(userService.getUserByLogin(email, password), HttpStatus.OK);
    }
    /**
     * Posts the user to the database.
     * @param user the user passed in
     * @return the posted user.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/user")
    public ResponseEntity<User> createUser(@RequestBody User user)  {
        return null;
    }

    /**
     * gets the user from the database.
     * @return returns the user
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/get-user")
    public ResponseEntity<User> getUser()  {
        System.out.println("in the tiwtter controller for get followers");
        return new ResponseEntity<>(userService.getUser("user1"), HttpStatus.OK);
    }

    /**
     * gets a user from the database by a username.
     * @param username the username passed in from the front end.
     * @return returns a user from the database.
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/retrieve/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username)  {
        System.out.println("in the user controller to get a user by username");
        System.out.println(username);
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    /**
     * Saves a user to the database.
     * @param user the user being saved to the database.
     * @param bindingResult
     * @return returns the saved user.
     * @throws ValidationException
     */
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
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUsername((user.getUsername()));
        System.out.println(user.getUsername());
        // save note instance to db
        User pushedUser = this.userService.saveUser(newUser);
        if(pushedUser.getUsername() == null){
            System.out.println("null user");
        } else {
            System.out.println(pushedUser.getUsername());
        }
        System.out.println();
        return pushedUser;
    }

}
