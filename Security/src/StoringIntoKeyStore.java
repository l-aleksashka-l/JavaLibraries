import java.io.FileInputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class StoringIntoKeyStore {
    public static void main(String args[]) throws Exception {
        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the KeyStore object
        char[] password = "changeit".toCharArray();
        String path = "D:/Program Files/lib/security/cacerts";
        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);
        System.out.println("data stored");

        //Creating the KeyStore.SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEnt = (KeyStore.SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);

        //Creating SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : "+mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: "+mysecretKey.getFormat());
        System.out.println("Key: " + mysecretKey);
    }
}