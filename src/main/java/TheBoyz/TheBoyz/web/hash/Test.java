package TheBoyz.TheBoyz.web.hash;

import TheBoyz.TheBoyz.data.model.SecureTwitter;
import TheBoyz.TheBoyz.web.hash.CryptoHash;

import java.security.NoSuchAlgorithmException;

public class Test {
    private static CryptoHash cryptoHash;
//    CryptoHash cryptoHash = new CryptoHash();

    public Test() throws NoSuchAlgorithmException {
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("test");
        SecureTwitter secureTwitter = new SecureTwitter();
        secureTwitter.setConsumerKey("HAHAHA");
//        92240dc25f269ae44fa36219c764294094b31367ca1c2c94bf6277c2dbe97815
        secureTwitter.setConsumerSecret("BAHAHA");
        secureTwitter.setAccessToken("LOL");
        secureTwitter.setAccessTokenSecret("Jump");
        secureTwitter.setTwitterHandle("@social");
       cryptoHash = new CryptoHash();

       cryptoHash.hashObject(secureTwitter);

    }
}
