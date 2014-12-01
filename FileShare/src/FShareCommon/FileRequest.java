/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

/**
 *
 * @author Ardhinata Juari <ardhinata.juari@gmail.com>
 */
public class FileRequest extends CommunicationObject{
    
    private byte[] hash=null;
    private int size = 0;

    public FileRequest(int classEnum, int subClassEnum, String Type) {
        super(classEnum, subClassEnum, Type);
    }
    
    public FileRequest(int classEnum, int subClassEnum) {
        super(classEnum, subClassEnum);
    }
    
    public FileRequest(int classEnum) {
        super(classEnum);
    }
    
    public FileRequest() {
        super(4);
    }
    
    public byte[] GetHash(){
        return this.hash;
    }
    
    public int GetSize(){
        return this.size;
    }
    
    public void SetHash(byte[] hash){
        this.hash=hash;
    }
    
    public void SetSize(int size){
        this.size=size;
    }
    
}
