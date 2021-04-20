package TheBoyz.TheBoyz.web.hash;
import TheBoyz.TheBoyz.data.model.SecureTwitter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class CryptoHash {

   private final MessageDigest md;

    public CryptoHash() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("SHA-256");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("iin main");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = "hello.";

        // Change this to UTF-16 if needed
        md.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
    }

    public String hash(String input){
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        return hex;
    }

    public SecureTwitter hashObject(SecureTwitter secureTwitter){

        String input = secureTwitter.getConsumerKey();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setConsumerKey(hex);

        input = secureTwitter.getConsumerSecret();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setConsumerSecret(hex);

        input = secureTwitter.getAccessToken();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setAccessToken(hex);

        input = secureTwitter.getAccessTokenSecret();
        md.update(input.getBytes(StandardCharsets.UTF_8));
        digest = md.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
        System.out.println(hex);
        secureTwitter.setAccessTokenSecret(hex);
        System.out.println(hex.length());

        return secureTwitter;
    }
}
