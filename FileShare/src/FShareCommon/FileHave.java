/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.net.*;

/**
 *
 * @author REMOTE
 */
public class FileHave extends CommunicationObject {

    private String filename;
    private int size;
    private InetAddress remoteAddr;
    private byte[] MD5Hash;

    public FileHave(int classEnum, String Type) {
        super(classEnum, Type);
    }

    public String GetFilename() {
        return this.filename;
    }

    public int GetSize() {
        return this.size;
    }

    public InetAddress GetSocket() {
        return this.remoteAddr;
    }

    public byte[] GetMD5Hash() {
        return this.MD5Hash;
    }

    public void SetFilename(String filename) {
        this.filename = filename;
    }

    public void SetSize(int size) {
        this.size = size;
    }

    public void SetSocket(InetAddress socket) {
        this.remoteAddr = socket;
    }

    public void SetMD5Hash(byte[] hash) {
        this.MD5Hash = hash;
    }

    public int CompareHash(byte[] hash) {
        if (hash.length != MD5Hash.length) {
            return 0;
        } else {
            int match = 1;
            for (int i = 0; i < MD5Hash.length; i++) {
                if (hash[i] != MD5Hash[i]) {
                    match = 0;
                    break;
                }
            }
            return match;
        }
    }
}
