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

    public void multipartFileToFile(
            MultipartFile multipart,
            Path dir
    ) throws IOException {
        Path filepath = Paths.get(dir.toString(), multipart.getOriginalFilename());
        multipart.transferTo(filepath);
    }

    public static BufferedImage scaleImage(BufferedImage image, int imageType,
                                           int newWidth, int newHeight) {
        // Make sure the aspect ratio is maintained, so the image is not distorted
        double thumbRatio = (double) newWidth / (double) newHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double aspectRatio = (double) imageWidth / (double) imageHeight;

        if (thumbRatio < aspectRatio) {
            newHeight = (int) (newWidth / aspectRatio);
        } else {
            newWidth = (int) (newHeight * aspectRatio);
        }

        // Draw the scaled image
        BufferedImage newImage = new BufferedImage(newWidth, newHeight,
                imageType);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);

        return newImage;
    }


    public List<OnePosts> getUsersOnePosts(int userId){
        List<OnePosts> usersOnePost = onePostRepository.findByUserId(userId);
        return usersOnePost;
    }
}
