package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.User;
import TheBoyz.TheBoyz.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@Slf4j
/**
 * The User Service
 */
public class UserService {

    private final UserRepository userRepository;

    /**
     * The constructor for the user service to make calls for the service.
     *
     * @param userRepository the repository for the user methods to the backend.
     */
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finds the user by an id.
     * @param userId the user's unique id.
     * @param page the page.
     * @param limit the number of results to show.
     */
    @Transactional(readOnly = true)
    public void findByUserId(final Long userId, final Integer page, final Integer limit) {
        userRepository.findByUserIdContainingOrderByUserId(userId, PageRequest.of(page, limit));
    }

    /**
     * Gets the user from the database.
     *
     * @param email the email created by the user.
     * @return returns the User.
     */
    public User getUserByLogin(String email, String password) {
        User searchedUser = new User();
        System.out.println("In the get user method");
        System.out.println("************");
        System.out.println(email);
        searchedUser = userRepository.findUserByEmailAndPassword(email, password);
        System.out.println("USERNAME: " + searchedUser.getUsername());
        return searchedUser;
    }

    /**
     * Saves the user to the database.
     * @param user the user being saved
     */
    public User saveUser(User user) {
        System.out.println("in the user service: ");
        System.out.println("username: " + user.getUsername());
        User searchedUser = userRepository.findUserByUsername(user.getUsername());
        User searchedUsername  = userRepository.findUserByUsername(user.getUsername());
        User searchedPhoneNumber = userRepository.findUserByPhoneNumber(user.getPhoneNumber());
//        System.out.println(searchedPhoneNumber.getPhoneNumber());
        User searchedEmail = userRepository.findUserByEmail(user.getEmail());
        User nullUser = new User();
        nullUser.setUserId(0);
        nullUser.setUsername("");
        nullUser.setEmail("");
        nullUser.setPhoneNumber("");

        if(searchedUsername == null && searchedEmail == null && searchedPhoneNumber == null) {
            System.out.println("This user does not exist, saving to the db");
            userRepository.save(user);
            return user;

        } else {
            System.out.println("the user exists");
            if (searchedUsername != null) {
                System.out.println("the user name already exists, not saving to the db");
                searchedUser.setUsername("**");
                nullUser.setUsername("**");
            }
            if (searchedEmail != null) {
                System.out.println("the email already exists, not saving to the db");
                nullUser.setEmail("**");
            }
            if (searchedPhoneNumber != null) {
                System.out.println("the phone number already exists, not saving to the db");
               nullUser.setPhoneNumber("**");
            }
        }
        return nullUser;

    }

    /**
     * Saves a user to the database.
     *
     * @param user the user being saved
     * @param bindingResult the result from the call
     * @return returns the user that was saved
     * @throws ValidationException
     */
    public User save(@RequestBody User user, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("exception thrown in the backend");
        }
        user.getUserId();
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUsername((user.getUsername()));
        System.out.println(user.getUsername());
        return newUser;
    }

    /**
     * Gets the user from the database.
     *
     * @param username the username created by the user.
     * @return returns the User.
     */
    public User getUser(String username) {
        User user = new User();
        System.out.println("In the get user method in user service");
        System.out.println("************");
        System.out.println(username);
        user = userRepository.findUserByUsername(username);
        if(user != null) {
            System.out.println("USERNAME: " + user.getUsername());
            System.out.println("id: " + user.getUserId());
        }
        return user;
    }
}
