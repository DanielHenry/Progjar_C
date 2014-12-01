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
import FShareCommon.*;

/**
 *
 * @author Ardhinata Juari <ardhinata.juari@gmail.com>
 */

/**
 * ------------------------------------------------
 * Index of Method
 * 0 = Not Set
 * 1 = Create File Descriptor
 * 2 = Load file descriptor
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
            String filename;
            try {
                String path = command.substring(7);
                File file = new File(path);
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("System cannot find the file.");
                    return;
                } else {
                    size = (int) file.length();
                    filename = file.getName();
                    byte[] digest = null;
                    md = MessageDigest.getInstance("MD5");
                    InputStream is = Files.newInputStream(Paths.get(path));
                    DigestInputStream dis = new DigestInputStream(is, md);
                    digest = md.digest();
                    System.out.println("MD5 hash: " + BytePrint.bytesToHex(digest));
                    while (path.charAt(path.length() - 1) != '\\') {
                        path = path.substring(0, path.length() - 1);
                    }
                    FileHave fh = new FileHave(2);
                    fh.SetFilename(filename);
                    fh.SetSize(size);
                    fh.SetMD5Hash(digest);
                    String newdesc = path + filename + ".fsd";
                    File desc = new File(newdesc);
                    desc.createNewFile();
                    FileOutputStream fos = new FileOutputStream(desc);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(fh);
                    System.out.println("Descriptor file created in:" + newdesc);
                    return;
                }
            } catch (NoSuchAlgorithmException | IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (method == 2) {
            String desc = command.substring(5);
            String path = desc.substring(0, desc.length()-3);
            File fdesc = new File(desc);
            File fpath=new File(path);
            if(fdesc.isDirectory() || !fdesc.exists()){
                System.out.println("File descriptor not found");
                return;
            }else{
                ObjectInputStream ois = null;
                FileHave fh=null;
                try {
                    FileInputStream fis = new FileInputStream(fdesc);
                    ois = new ObjectInputStream(fis);
                    fh = (FileHave) ois.readObject();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(!fpath.exists()){
                    FileRequest fr = new FileRequest();
                    fr.SetSize(fh.GetSize());
                    fr.SetHash(fh.GetMD5Hash());
                    
                }
            }
            
        }
    }

}
