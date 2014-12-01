/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.io.*;


/**
 *
 * @author Jarjiet
 */
public class FileSeed extends FileHave{
    private String sPath;
    private File path=null;
    public FileSeed(){
        super(6);
    }
    
    public FileSeed(int typeEnum){
        super(typeEnum);
    }
    public String GetPathString(){
        return this.sPath;
    }
    public File GetFilePath(){
        return this.path;
    }
    public void SetPathString(String sPath){
        this.sPath=sPath;
    }
    public void SetFilePath(File path){
        this.path=path;
    }
}
