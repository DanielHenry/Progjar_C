import java.io.*;
import java.util.*;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClient{
    
    public static void main(String[] args) {
        try {
            /* Digest Initialization */
            MessageDigest md = MessageDigest.getInstance("MD5");
            /* TODO: Add initialization here */
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}