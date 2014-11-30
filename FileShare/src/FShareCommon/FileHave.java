/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.net.Socket;
/**
 *
 * @author REMOTE
 */
public class FileHave extends CommunicationObject{
    private String filename;
    private int size;
    private Socket remoteSock;
    private byte[] MD5Hash;
    public FileHave(int classEnum, String Type) {
        super(classEnum, Type);
    }
    public String GetFilename(){
        return this.filename;
    }
    public int GetSize(){
        return this.size;
    }
    public Socket GetSocket(){
        return this.remoteSock;
    }
    public byte[] GetMD5Hash(){
        return this.MD5Hash;
    }
}
