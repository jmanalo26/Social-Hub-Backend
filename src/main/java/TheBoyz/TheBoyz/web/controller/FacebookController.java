//package TheBoyz.TheBoyz.web.controller;
//
//import TheBoyz.TheBoyz.data.model.FacebookUser;
//import TheBoyz.TheBoyz.web.service.FBService;
//import com.restfb.FacebookClient;
//import com.restfb.types.Post;
//import com.restfb.types.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.view.RedirectView;
//
//import java.util.ArrayList;
//
//@Slf4j
//@RestController
//@RequestMapping("facebook/")
//public class FacebookController {
//
//    @GetMapping(value = "username")
//    public ResponseEntity<FacebookUser> getUser(){
//        return new ResponseEntity<>(FBService.getUser(), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "feed")
//    public ResponseEntity<ArrayList<String>> getUserPosts(){
//        return new ResponseEntity<>(FBService.getPosts(), HttpStatus.OK);
//    }
//
//}
