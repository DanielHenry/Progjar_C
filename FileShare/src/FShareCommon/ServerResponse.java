/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author Ardhinata Juari <ardhinata.juari@gmail.com>
 */
public class ServerResponse extends CommunicationObject{
    private boolean onServer=false;
    private ArrayList<InetAddress> listNode=new ArrayList<>();

    public ServerResponse(int classEnum) {
        super(classEnum);
    }
    
    public ServerResponse() {
        super(5);
    }
    
    public boolean GetOnServer(){
        return this.onServer;
    }
    
    public ArrayList<InetAddress> GetListNode(){
        return this.listNode;
    }
    
    public void SetOnServer(boolean onServer){
        this.onServer=onServer;
    }
    
    public void SetListNode(ArrayList<InetAddress> listNode){
        this.listNode=listNode;
    }
    
}
