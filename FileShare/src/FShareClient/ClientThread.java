/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareClient;

import java.io.*;
import java.util.*;
import java.net.Socket;
import java.security.*;
import FShareCommon.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ardhinata Juari <ardhinata.juari@gmail.com>
 */

/**
 * ------------------------------------------------
 * Index of Method
 * 0 = Not Set
 * 1 = Create File Descriptor
 * ------------------------------------------------
 */
public class ClientThread implements Runnable {

    private Socket sock = null;
    private int method = 0;
    private String command = null;
    private MessageDigest md = null;

    public void SetMethod(int method) {
        this.method = method;
    }

    public void SetCommand(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        if (method == 1) {
            int size;
            try {
                String path = command.substring(7);
                File file = new File(path);
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("System cannot find the file.");
                    return;
                } else {
                    size=(int) file.length();
                    System.out.println("File found");
                    byte[] digest = null;
                    md = MessageDigest.getInstance("MD5");
                    InputStream is = Files.newInputStream(Paths.get(path));
                    DigestInputStream dis = new DigestInputStream(is, md);
                    digest = md.digest();
                    System.out.println("MD5 hash: " + BytePrint.bytesToHex(digest));
                    return;
                }
            } catch (NoSuchAlgorithmException | IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
