/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FShareCommon;

/**
 *
 * @author REMOTE
 */
public class CommunicationObject {

    private String classType;
    private int classTypeEnum;

    public CommunicationObject(int classEnum, String Type) {
        this.classTypeEnum = classEnum;
        this.classType = Type;
    }

    public String GetClassType() {
        return this.classType;
    }

    public int GetClassTypeEnum() {
        return this.classTypeEnum;
    }

    public void SetClassType(String Type) {
        this.classType = Type;
    }

    public void SetClassTypeEnum(int Type) {
        this.classTypeEnum = Type;
    }
}
