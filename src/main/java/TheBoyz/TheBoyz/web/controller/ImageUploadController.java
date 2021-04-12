package TheBoyz.TheBoyz.web.controller;

import TheBoyz.TheBoyz.data.model.ImageModel;
import TheBoyz.TheBoyz.data.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
//@RequestMapping(path = "image")
public class ImageUploadController {

//    @Autowired
    private final ImageRepository imageRepository;

    public ImageUploadController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

//    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
//    @PostMapping(value = "/api/send-image")
//    public void uploadImage(@RequestParam("file")  MultipartFile file) throws IOException {
//        System.out.println("MADE IT TO THE UPLOAD CONTROLLER!");
//        System.out.println("Original Image Byte Size - " + file.getBytes().length);
//        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//                compressBytes(file.getBytes()));
//        imageRepository.save(img);
////        return ResponseEntity.status(HttpStatus.OK);
//    }
    @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
        // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
