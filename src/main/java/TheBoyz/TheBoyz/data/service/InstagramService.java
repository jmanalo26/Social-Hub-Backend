package TheBoyz.TheBoyz.data.service;

import TheBoyz.TheBoyz.data.model.InstaUser;
import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import TheBoyz.TheBoyz.data.model.OnePosts;
import TheBoyz.TheBoyz.data.repository.InstagramRepository;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsSetBiographyRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.*;
import org.springframework.stereotype.Service;
import com.github.instagram4j.instagram4j.IGClient;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class InstagramService {



    private final InstagramRepository instagramRepository;

    public InstagramService(InstagramRepository instagramRepository) {
        this.instagramRepository = instagramRepository;
    }

//    @Transactional(readOnly = true)
//    public void findByUsername(final String username, final Integer page, final Integer limit){
//        instagramRepository.findByUsername(username, PageRequest.of(page, limit));
//    }



    public InstagramUserInfo getUserAccount(@NotNull InstaUser user) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest(user.getUsername()));

        InstagramUserInfo instagramUser = new InstagramUserInfo();
        instagramUser.setFollowerCount(usernameResult.getUser().follower_count);
        instagramUser.setFollowingCount(usernameResult.getUser().following_count);
        instagramUser.setMediaCount(usernameResult.getUser().media_count);

        String userName = usernameResult.getUser().full_name+".jpg";

        instagramUser.setProfilePicUrl(saveImage(usernameResult.getUser().profile_pic_url, userName));

        instagramUser.setInstaBio(usernameResult.getUser().biography);
        instagramUser.setDisplayName(usernameResult.getUser().full_name);
        instagramUser.setUserName(usernameResult.getUser().username);



        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
        ArrayList<String> followerFeed = new ArrayList<String>();
        ArrayList<byte[]> followerProfilePic = new ArrayList<>();
        for (InstagramUserSummary account : followersResult.getUsers()) {
            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
            String followerName = account.full_name+".jpg";
            followerProfilePic.add(saveImage(account.profile_pic_url, followerName ));
        }
        System.out.println(followerFeed.size());
        instagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));
        instagramUser.setFollowerProfilePics(followerProfilePic);

        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
//        ArrayList<String> imageFeed = new ArrayList<String>();
        ArrayList<byte[]> image = new ArrayList<>();


        ArrayList<String> imageFeedCaption = new ArrayList<String>();
        ArrayList<String> imageFeedComment = new ArrayList<String>();
        ArrayList<Integer> imageFeedLikes = new ArrayList<>();
        ArrayList<String> imageFeedTopLikes = new ArrayList<>();
        System.out.println(postList.getItems().size());
        for(InstagramFeedItem post : postList.getItems()) {

//            imageFeed.add(post.image_versions2.getCandidates().toString());
            System.out.println(post.image_versions2.getCandidates().toString());
            imageFeedCaption.add(post.getCaption().getText());
            imageFeedLikes.add(post.like_count);
            imageFeedTopLikes.add(post.top_likers.toString());
            imageFeedComment.add(post.toString());
            String imageName = post.getId()+".jpg";


            image.add(saveImage(post.image_versions2.getCandidates().toString().substring(post.image_versions2.getCandidates().toString().indexOf("url") + 4,
                    post.image_versions2.getCandidates().toString().indexOf("width") - 2), imageName));
            try
            {
                Files.deleteIfExists(Paths.get(imageName));
            }
            catch(NoSuchFileException e)
            {
                System.out.println("No such file/directory exists");
            }
            catch(DirectoryNotEmptyException e)
            {
                System.out.println("Directory is not empty.");
            }
            catch(IOException e)
            {
                System.out.println("Invalid permissions.");
            }

            System.out.println("Deletion successful: " + imageName);
        }






        instagramUser.setImages(image);
        instagramUser.setImageFeedCaption(imageFeedCaption.toArray(String[]::new));
        instagramUser.setImageFeedComment(imageFeedComment.toArray(String[]::new));
        instagramUser.setImageFeedLikes(imageFeedLikes.toArray(Integer[]::new));
        instagramUser.setImageFeedTopLikes(imageFeedTopLikes.toArray(String[]::new));


        return instagramUser;
    }

    public static byte[] saveImage(String imageUrl, String imageName){

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            URL url = new URL(imageUrl);
            inputStream = url.openStream();
            outputStream = new FileOutputStream(imageName);

            byte[] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            File image = new File(imageName);


            BufferedImage bImage = ImageIO.read(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] data = bos.toByteArray();


            return data;


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException :- " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException :- " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException :- " + e.getMessage());

        } finally {
            try {

                inputStream.close();
                outputStream.close();

            } catch (IOException e) {
                System.out.println("Finally IOException :- " + e.getMessage());
            }
        }
        return null;
    }

    public void changeBio(InstaUser user, String bio) throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        IGClient client  = IGClient.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .client(httpClient)
                .login();
        IGResponse response = new AccountsSetBiographyRequest(bio).execute(client).join();
        System.out.println(response.getStatus());
    }

    public boolean followingStatus(@NotNull InstaUser user, String userSearch) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();

        InstagramSearchUsernameResult followResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));
        if (instagram.sendRequest(new InstagramGetFriendshipRequest(followResult.getUser().getPk())).following)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public void postImage(@NotNull InstaUser user, File post, String caption) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();

        int width = 1000;    //width of the image
        int height = 1000;   //height of the image


        BufferedImage in = javax.imageio.ImageIO.read(post);
        BufferedImage out = scaleImage(in,
                BufferedImage.TYPE_INT_RGB, width, height);
        javax.imageio.ImageIO.write(out, "JPG", new java.io.File("newPost.jpg"));
        File newInstaPost = new File("newPost.jpg");
        instagram.sendRequest(new InstagramUploadPhotoRequest(newInstaPost, caption));
        System.out.println("Picture Posted");
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

    public void followSearchUserAccount(@NotNull InstaUser user, String userSearch) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();

        InstagramSearchUsernameResult followResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));
        instagram.sendRequest(new InstagramFollowRequest(followResult.getUser().getPk()));
    }

    public void unfollowSearchUserAccount(@NotNull InstaUser user, String userSearch) throws IOException {
        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();

        InstagramSearchUsernameResult followResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));
        instagram.sendRequest(new InstagramUnfollowRequest(followResult.getUser().getPk()));
    }

    public InstagramUserInfo getSearchUserAccount(@NotNull InstaUser user, String userSearch) throws IOException {

        Instagram4j instagram = Instagram4j.builder().username(user.getUsername()).password(user.getPassword()).build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));

        InstagramUserInfo searchInstagramUser = new InstagramUserInfo();
        searchInstagramUser.setFollowerCount(usernameResult.getUser().follower_count);
        searchInstagramUser.setFollowingCount(usernameResult.getUser().following_count);
        searchInstagramUser.setMediaCount(usernameResult.getUser().media_count);

        String userName = usernameResult.getUser().full_name+".jpg";

        searchInstagramUser.setProfilePicUrl(saveImage(usernameResult.getUser().profile_pic_url, userName));

        searchInstagramUser.setInstaBio(usernameResult.getUser().biography);
        searchInstagramUser.setDisplayName(usernameResult.getUser().full_name);
        searchInstagramUser.setUserName(usernameResult.getUser().username);

        InstagramSearchUsernameResult followResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userSearch));
        searchInstagramUser.setFollowingStatus(instagram.sendRequest(new InstagramGetFriendshipRequest(followResult.getUser().getPk())).following);



        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
        ArrayList<String> followerFeed = new ArrayList<String>();
        for (InstagramUserSummary account : followersResult.getUsers()) {
            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
        }
        System.out.println(followerFeed.size());
        searchInstagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));



//        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
//        ArrayList<String> imageFeed = new ArrayList<String>();
//        ArrayList<String> imageFeedCaption = new ArrayList<String>();
//        ArrayList<String> imageFeedComment = new ArrayList<String>();
//        System.out.println(postList.getItems().size());
//        for(InstagramFeedItem post : postList.getItems()) {
//
//            imageFeed.add(post.image_versions2.getCandidates().toString());
//            System.out.println(post.image_versions2.getCandidates().toString());
//            imageFeedCaption.add(post.getCaption().getText());
//            imageFeedComment.add(post.toString());
//        }
//
//        searchInstagramUser.setImageFeed(imageFeed.toArray(String[]::new));
//        searchInstagramUser.setImageFeedCaption(imageFeedCaption.toArray(String[]::new));
//        searchInstagramUser.setImageFeedComment(imageFeedComment.toArray(String[]::new));



        return searchInstagramUser;
    }

    public InstaUser saveUser(InstaUser user) {
        InstaUser userSH = instagramRepository.findInstaUserByUsername(user.getUsername());
        if (userSH == null) {
            System.out.println("in save User");
            instagramRepository.save(user);
        }
        return user;
    }

    public InstaUser getUserByID(int id) {
        InstaUser userSH = instagramRepository.findInstaUserByInstaId(id);

        return userSH;
    }

}
