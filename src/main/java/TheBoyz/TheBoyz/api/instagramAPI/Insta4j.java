package TheBoyz.TheBoyz.api.instagramAPI;

import TheBoyz.TheBoyz.data.model.InstagramUserInfo;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsSetBiographyRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.*;
import org.springframework.web.multipart.MultipartFile;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Insta4j {
    public static void main(String[] args) throws IOException {
//        OkHttpClient httpClient = new OkHttpClient.Builder().build();
//        IGClient client  = IGClient.builder()
//                .username("hbb_disposable")
//                .password("yaga186")
//                .client(httpClient)
//                .login();
//        IGResponse response = new AccountsSetBiographyRequest("Test boi!").execute(client).join();
//        System.out.println(response.getStatus());

        Instagram4j instagram = Instagram4j.builder().username("thesocialhubclub").password("Capstone2021").build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest("thesocialhubclub"));

        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
        ArrayList<byte[]> images = new ArrayList<>();
        for(InstagramFeedItem post :postList.getItems())
        {

            String imageName = post.getId()+".jpg";

            images.add(saveImage(post.image_versions2.getCandidates().toString().substring(post.image_versions2.getCandidates().toString().indexOf("url") + 4,
                    post.image_versions2.getCandidates().toString().indexOf("width") - 2), imageName));

        }



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
//
//    public static void saveImage(String imageUrl) throws IOException {
//        URL url = new URL(imageUrl);
//        String fileName = url.getFile();
////        System.out.println(fileName);
//        String destName = "./images" + fileName.substring(fileName.lastIndexOf("/"));
////        System.out.println(destName);
//
//        InputStream is = url.openStream();
//        OutputStream os = new FileOutputStream(destName);
//
//        byte[] b = new byte[2048];
//        int length;
//
//        while ((length = is.read(b)) != -1) {
//            os.write(b, 0, length);
//        }
//
//        is.close();
//        os.close();
//    }
////        System.out.println(usernameResult.getUser().getFollower_count());
//        int width = 1000;    //width of the image
//        int height = 1000;   //height of the image
//        File f = new File("test.jpg"); //image file path
//
//
//        BufferedImage in = javax.imageio.ImageIO.read(f);
//        BufferedImage out = scaleImage(in,
//                BufferedImage.TYPE_INT_RGB, width, height);
//        javax.imageio.ImageIO.write(out, "JPG", new java.io.File("testpt7.jpg"));
//        File test = new File("testpt7.jpg");
//        instagram.sendRequest(new InstagramUploadPhotoRequest(test, "new one post"));
//        System.out.println("Picture Posted");
//    }
//
//    /**
//     * @param image     The image to be scaled
//     * @param imageType Target image type, e.g. TYPE_INT_RGB
//     * @param newWidth  The required width
//     * @param newHeight The required width
//     * @return The scaled image
//     */
//    public static BufferedImage scaleImage(BufferedImage image, int imageType,
//                                           int newWidth, int newHeight) {
//        // Make sure the aspect ratio is maintained, so the image is not distorted
//        double thumbRatio = (double) newWidth / (double) newHeight;
//        int imageWidth = image.getWidth(null);
//        int imageHeight = image.getHeight(null);
//        double aspectRatio = (double) imageWidth / (double) imageHeight;
//
//        if (thumbRatio < aspectRatio) {
//            newHeight = (int) (newWidth / aspectRatio);
//        } else {
//            newWidth = (int) (newHeight * aspectRatio);
//        }
//
//        // Draw the scaled image
//        BufferedImage newImage = new BufferedImage(newWidth, newHeight,
//                imageType);
//        Graphics2D graphics2D = newImage.createGraphics();
//        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);
//
//        return newImage;
//    }
    }


//        InstagramSearchUsernameResult githubResult = instagram.sendRequest(new InstagramSearchUsernameRequest("github"));
//
////        instagram.sendRequest(new InstagramFollowRequest(githubResult.getUser().getPk()));
//        System.out.println(instagram.sendRequest(new InstagramGetFriendshipRequest(githubResult.getUser().getPk())).following);

//
//        InstagramUserInfo searchInstagramUser = new InstagramUserInfo();
//        searchInstagramUser.setFollowerCount(usernameResult.getUser().follower_count);
//        searchInstagramUser.setFollowingCount(usernameResult.getUser().following_count);
//        searchInstagramUser.setMediaCount(usernameResult.getUser().media_count);
//        searchInstagramUser.setProfilePicUrl(usernameResult.getUser().profile_pic_url);
//        searchInstagramUser.setInstaBio(usernameResult.getUser().biography);
//        searchInstagramUser.setDisplayName(usernameResult.getUser().full_name);
//        searchInstagramUser.setUserName(usernameResult.getUser().username);
//
//
//        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
//                new InstagramGetUserFollowersRequest(usernameResult.getUser().getPk()));
//        ArrayList<String> followerFeed = new ArrayList<String>();
//        for (InstagramUserSummary account : followersResult.getUsers()) {
//            followerFeed.add(account.full_name + " ProfilePic:" + account.profile_pic_url);
//        }
//        System.out.println(followerFeed.size());
//        searchInstagramUser.setFollowerFeed(followerFeed.toArray(String[]::new));

    //
//

//
//        searchInstagramUser.setImageFeed(imageFeed.toArray(String[]::new));
//        searchInstagramUser.setImageFeedCaption(imageFeedCaption.toArray(String[]::new));
//        searchInstagramUser.setImageFeedComment(imageFeedComment.toArray(String[]::new));



//        InstagramFeedResult test = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));

//
//        InstagramGetUserFollowersResult followersResult = instagram.sendRequest(
//                new InstagramGetUserFollowingRequest(usernameResult.getUser().getPk()));
//        for (InstagramUserSummary user : followersResult.getUsers()) {
//            System.out.println(user.full_name + " " + user.pk);


//        System.out.println(usernameResult.getUser().getFollower_count());
//        System.out.println(usernameResult.getUser().getBiography());
//        System.out.println(usernameResult.getUser().getMedia_count());
//        System.out.println(usernameResult.getUser().getProfile_pic_url());
//        System.out.println(usernameResult.getUser().getExternal_url());
//        System.out.println(usernameResult.getUser().hd_profile_pic_url_info.url);
//        System.out.println(usernameResult.getUser().toString());

//        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
//        for (InstagramFeedItem post : postList.getItems()) {
//            System.out.println(post.getCaption().getText());
//            System.out.println(post.image_versions2.getCandidates());
//            System.out.println(post.getComments());
//
//        }





