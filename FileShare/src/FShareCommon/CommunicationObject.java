/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

import java.io.*;

/**
 *
 * @author Ardhinata Juari <ardhinata.juari@gmail.com>
 */

/**
 * ------------------------------------------------
 * Index of Class Type Enum
 * 0 = Not Set
 * 1 = Reserved
 * 2 = FileHave
 * 3 = FileHaveIndex
 * 4 = FileRequest
 * 5 = ServerResponse
 * ------------------------------------------------
 */

public class CommunicationObject implements Serializable {

    private String classType;
    private int classTypeEnum;
    private int subClassTypeEnum;

    public CommunicationObject(int classEnum, int subClassEnum, String Type) {
        this.classTypeEnum = classEnum;
        this.subClassTypeEnum = subClassEnum;
        this.classType = Type;
    }
    
    public CommunicationObject(int classEnum, int subClassEnum){
        this.classTypeEnum = classEnum;
        this.subClassTypeEnum = subClassEnum;
        this.classType = "Refer Index of Class Type Enum for details";
    }
    public CommunicationObject(int classEnum){
        this.classTypeEnum = classEnum;
        this.subClassTypeEnum = 0;
        this.classType = "Refer Index of Class Type Enum for details";
    }

    public String GetClassType() {
        return this.classType;
    }

    public int GetClassTypeEnum() {
        return this.classTypeEnum;
    }

    public int GetSubClassTypeEnum() {
        return this.subClassTypeEnum;
    }

    public void SetClassType(String Type) {
        this.classType = Type;
    }

    public void SetClassTypeEnum(int Type) {
        this.classTypeEnum = Type;
    }

    public void SetSubClassTypeEnum(int SubType) {
        this.subClassTypeEnum = SubType;
    }
}
