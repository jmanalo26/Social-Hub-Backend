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
import java.awt.*;
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
    @GetMapping(value = "/api/user/get-username/{username}")
    public ResponseEntity<Boolean> checkUsernameExists(@PathVariable String username) {
        System.out.println("getting the user by their login info");
        return new ResponseEntity<>(userService.checkIfUsernameExists(username), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/api/user/get-email/{email}")
    public ResponseEntity<Boolean> checkEmailExists(@PathVariable String email) {
        System.out.println("getting the user by their login info");
        return new ResponseEntity<>(userService.checkIfEmailExists(email), HttpStatus.OK);
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
        System.out.println("In the save method in the user controller...");
        if (bindingResult.hasErrors()) {
            throw new ValidationException("exception thrown in the backend");
        }
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPhoneNumber());
        System.out.println(user.getUserId());
//        Optional<User> check = userRepository.findByStudentId(user.getStudentId());
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUsername((user.getUsername()));
        System.out.println(user.getUserId());
        // save note instance to db
        User pushedUser = this.userService.saveUser(newUser);
        if(pushedUser.getUsername().equals("**") || pushedUser.getEmail().equals("**") || pushedUser.getPhoneNumber().equals("**")){
            System.out.println(" user not saved ");
        } else {
            System.out.println(pushedUser.getUsername());
            System.out.println("the user id: " + pushedUser.getUserId());
        }
        System.out.println();
        return pushedUser;
//        return new ResponseEntity<>(userService.getUser("user1"), HttpStatus.OK);

    }

    /**
     * Saves a user to the database.
     * @param bindingResult
     * @return returns the saved user.
     * @throws ValidationException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/api/user/put")
    public User update(@RequestBody User updatedUser, BindingResult bindingResult) throws ValidationException {
        System.out.println("In the UPDATE method in the user controller...");
        if (bindingResult.hasErrors()) {
            throw new ValidationException("exception thrown in the backend");
        }
//        System.out.println(user.getUsername());
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        System.out.println(user.getPhoneNumber());
        System.out.println(updatedUser.getUserId());
        
        User existingUser = this.userService.findUserByUserId(updatedUser.getUserId());
        if(!updatedUser.getUsername().equals("")) {
            //check if username is taken
            existingUser.setUsername(updatedUser.getUsername());
        }
        if(!updatedUser.getEmail().equals("")){
            System.out.println("setting email..");
            System.out.println(updatedUser.getEmail());
            existingUser.setEmail(updatedUser.getEmail());
        }
        if(!updatedUser.getPassword().equals("")){
            existingUser.setPassword(updatedUser.getPassword());
        }
        if(!updatedUser.getPhoneNumber().equals("")){
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        }
        return this.userService.save(existingUser);

    }

    /**
     * Saves a user to the database.
     * @param user the user being saved to the database.
     * @param bindingResult
     * @return returns the saved user.
     * @throws ValidationException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/user/saveUser")
    public User attemptUserSave(@RequestBody User user, BindingResult bindingResult) throws ValidationException {
        System.out.println("In the attempt to save method in the user controller... line 177");
        if (bindingResult.hasErrors()) {
            throw new ValidationException("exception thrown in the backend");
        }
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPhoneNumber());
        System.out.println(user.getUserId());
//        Optional<User> check = userRepository.findByStudentId(user.getStudentId());
        User newUser = new User();

        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUsername((user.getUsername()));
        System.out.println(user.getUserId());
        // save note instance to db
//        User pushedUser = this.userService.saveUser(newUser);
        User pushedUser = this.userService.save(newUser);

        System.out.println("pushed user id: " + pushedUser.getUserId());
//        if(pushedUser.getUsername().equals("**") || pushedUser.getEmail().equals("**") || pushedUser.getPhoneNumber().equals("**")){
        if(pushedUser.getUsername().equals("**") || pushedUser.getEmail().equals("**")){

            System.out.println(" user not saved ");
        } else {
            System.out.println(pushedUser.getUsername());
            System.out.println("the user id: " + pushedUser.getUserId());
        }
        System.out.println();
        return pushedUser;
//        return new ResponseEntity<>(userService.getUser("user1"), HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/api/user/save/profileImage/{userId}")
    public ResponseEntity<User> postImage(@RequestBody Image image)  {
        System.out.println("in the post image");
        System.out.println(image == null);
        System.out.println(image.getSource());

        return null;
    }


}
