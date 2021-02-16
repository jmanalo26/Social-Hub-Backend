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
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public void findByUserId(final Long userId, final Integer page, final Integer limit){
        userRepository.findByUserIdContainingOrderByUserId(userId, PageRequest.of(page, limit));
    }

    public void saveUser(User user){
        System.out.println("in the user service: ");
        System.out.println("username: " + user.getUsername());
        userRepository.save(user);
    }



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

    public User getUser(String username)  {
        User user = new User();
        System.out.println("In the get user method");
        System.out.println("************");
        System.out.println(username);
        user =  userRepository.findUserByUsername(username);
        System.out.println("USERNAME: " + user.getUsername());
        return user;
    }
    }
