import javax.crypto.Cipher;
import java.security.*;
import java.util.Scanner;

public class KeyPairGeneration {
    public static void main(String args[]) throws Exception {
        //Accepting text from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String msg = sc.nextLine();

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the private key from the key pair
        PrivateKey privKey = pair.getPrivate();

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initialize the signature
        sign.initSign(privKey);
        byte[] bytes = msg.getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        byte[] signature = sign.sign();

        //Printing the signature
        System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));

        bytes = "Hello".getBytes();
        //Initializing the signature
        sign.initVerify(pair.getPublic());
        sign.update(bytes);

        KeyPairGenerator keyPairGen1 = KeyPairGenerator.getInstance("RSA");
        keyPairGen1.initialize(2048);
        KeyPair pair1 = keyPairGen1.generateKeyPair();
        PrivateKey privKey1 = pair1.getPrivate();
        PublicKey publicKey = pair1.getPublic();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(cipher.ENCRYPT_MODE, publicKey);
        byte[] input = "Welcome to Tutorialspoint".getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println( new String(cipherText, "UTF8"));

        //Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair1.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println(new String(decipheredText));
        //Verifying the signature
        boolean bool = sign.verify(signature);

        if(bool) {
            System.out.println("Signature verified");
        } else {
            System.out.println("Signature failed");
        }


    }
}