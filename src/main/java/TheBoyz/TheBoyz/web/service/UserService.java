//package TheBoyz.TheBoyz.web.service;
//import TheBoyz.TheBoyz.data.model.Tweet;
//import TheBoyz.TheBoyz.data.model.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import twitter4j.Twitter;
//import twitter4j.TwitterFactory;
//
//import javax.xml.bind.ValidationException;
//
//@Slf4j
//@Service
//public class UserService {
//    TwitterFactory tf;
//    Twitter twitter;
//
//    public UserService(){
//
//    }
//    public void saveUser()  {
//        System.out.println("In teh get follower count method");
//    }
//
//    public User getUser()  {
//        User user = new User();
//        System.out.println("In the get user method");
//        System.out.println("************");
//        return user;
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping(value = "/api/user/newUser")
//    public User save(@RequestBody User user, BindingResult bindingResult) throws ValidationException {
//        System.out.println("****");
//        if (bindingResult.hasErrors()) {
//            throw new ValidationException("exception thrown in the backend");
//        }
//        System.out.println(user.getUsername());
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        System.out.println(user.getPhoneNumber());
//        user.getUserId();
////        Optional<User> check = userRepository.findByStudentId(user.getStudentId());
//        User newUser = new User();
////        newUser.setUserId(user.getUserId());
////        newUser.setFirstName(user.getFirstName());
////        newUser.setLastName(user.getLastName());
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(user.getPassword());
//        newUser.setPhoneNumber(user.getPhoneNumber());
//        newUser.setUsername((user.getUsername()));
//        System.out.println(user.getUsername());
//        // save note instance to db
//        System.out.println("attempting save");
//        return newUser;
//    }
//}
