//package TheBoyz.TheBoyz.data.service;
//
//import TheBoyz.TheBoyz.data.repository.FacebookRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Slf4j
//public class FacebookService {
//    private final FacebookRepository facebookRepository;
//
//    public FacebookService(final FacebookRepository facebookRepository){
//        this.facebookRepository = facebookRepository;
//    }
//
//    @Transactional(readOnly = true)
//    public void findByUserId(final Long facebookID, final Integer page, final Integer limit){
//        facebookRepository.findByFacebookIDOrderByFacebookID(facebookID, PageRequest.of(page,limit));
//    }
//
//    @Transactional(readOnly = true)
//    public void findUserByName(final String name, final Integer page, final Integer limit){
//        facebookRepository.findFacebookUserByFacebookName(name, PageRequest.of(page,limit));
//    }
//}
