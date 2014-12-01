/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.net.*;
import java.util.*;

/**
 *
 * @author Ardhinata Juari
 * 5112100094
 */

/**
 * ------------------------------------------------
 * Index of SubClass Type Enum
 * 0 = Default
 * ------------------------------------------------
 */
public class FileHaveIndex extends FileHave {

    private ArrayList<InetAddress> remoteList=null;

    public FileHaveIndex(int classEnum, int subClassEnum, String Type) {
        super(classEnum, subClassEnum, Type);
    }
    
    public FileHaveIndex(int classEnum, int subClassEnum) {
        super(classEnum, subClassEnum);
    }
    
    public FileHaveIndex(int classEnum) {
        super(classEnum);
    }
    
    public FileHaveIndex() {
        super(3);
    }

    public ArrayList<InetAddress> GetAddrList() {
        return this.remoteList;
    }

    public void SetAddrList(ArrayList<InetAddress> addr) {
        this.remoteList = addr;
    }

    public void AddRemoteNode(InetAddress addr) {
        String address = addr.getHostAddress();
        int match = 0;
        for (int i = 0; i < remoteList.size(); i++) {
            String s = remoteList.get(i).getHostAddress();
            if (address.matches(s)) {
                match = 1;
                break;
            }
        }
        if (match == 0) {
            remoteList.add(addr);
        }
    }

    public void DelRemoteNode(InetAddress addr) {
        int index = -1;
        String address = addr.getHostAddress();
        for (int i = 0; i < remoteList.size(); i++) {
            String s = remoteList.get(i).getHostAddress();
            if (address.matches(s)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remoteList.remove(index);
        }
    }
}
