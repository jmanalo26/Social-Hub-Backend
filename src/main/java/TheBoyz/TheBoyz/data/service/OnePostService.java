package TheBoyz.TheBoyz.data.service;
import TheBoyz.TheBoyz.data.model.OnePosts;
import TheBoyz.TheBoyz.data.repository.OnePostRepository;
import lombok.extern.slf4j.Slf4j;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@Slf4j
public class OnePostService {

    final OnePostRepository onePostRepository;

    public OnePostService(final OnePostRepository onePostRepository) {
        this.onePostRepository = onePostRepository;
    }


    public OnePosts saveOnePost(OnePosts onePost) {
        OnePosts savedOnePost = onePostRepository.save(onePost);

        return savedOnePost;
    }



    public List<OnePosts> getUsersOnePosts(int userId){
        List<OnePosts> usersOnePost = onePostRepository.findByUserId(userId);
        return usersOnePost;
    }
}
