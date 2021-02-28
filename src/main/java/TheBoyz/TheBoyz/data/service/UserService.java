//package TheBoyz.TheBoyz.data.service;
//
//import TheBoyz.TheBoyz.data.model.User;
//import TheBoyz.TheBoyz.data.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(final UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    @Transactional(readOnly = true)
//    public void findByUserId(final Long userId, final Integer page, final Integer limit){
//        userRepository.findByUserIdContainingOrderByUserId(userId, PageRequest.of(page, limit));
//    }
//
//    public void saveUser(User user){
//        userRepository.save(user);
//    }
//
//}
