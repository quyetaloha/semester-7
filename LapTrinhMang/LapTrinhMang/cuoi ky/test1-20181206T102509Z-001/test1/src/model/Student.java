package model;

import java.io.Serializable;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Viet Nguyen
 */
public class Student implements Serializable{
    static final long serialVersionUID = 1L;
    private String maSV;
    private String hovaten;
    private String IP;
    private int group;
    
    private String strExamCode1;
    private String strExamCode2;
    private int numericCode3;
    private int numericCode4;
    private int[] numbericExam;
    private boolean isAlreadyRegistration;

    @Override
    public String toString() {
        return "Student{" + "maSV=" + maSV + ", hovaten=" + hovaten + ", IP=" + IP + ", group=" + group + ", strExamCode1=" + strExamCode1 + ", strExamCode2=" + strExamCode2 + ", numericCode3=" + numericCode3 + ", numericCode4=" + numericCode4 + ", numbericExam=" + Arrays.toString(numbericExam) + ", isAlreadyRegistration=" + isAlreadyRegistration + '}';
    }
    
    

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getStrExamCode1() {
        return strExamCode1;
    }

    public void setStrExamCode1(String strExamCode1) {
        this.strExamCode1 = strExamCode1;
    }

    public String getStrExamCode2() {
        return strExamCode2;
    }

    public void setStrExamCode2(String strExamCode2) {
        this.strExamCode2 = strExamCode2;
    }

    public int getNumericCode3() {
        return numericCode3;
    }

    public void setNumericCode3(int numericCode3) {
        this.numericCode3 = numericCode3;
    }

    public int getNumericCode4() {
        return numericCode4;
    }

    public void setNumericCode4(int numericCode4) {
        this.numericCode4 = numericCode4;
    }

    public int[] getNumbericExam() {
        return numbericExam;
    }

    public void setNumbericExam(int[] numbericExam) {
        this.numbericExam = numbericExam;
    }

    public boolean isIsAlreadyRegistration() {
        return isAlreadyRegistration;
    }

    public void setIsAlreadyRegistration(boolean isAlreadyRegistration) {
        this.isAlreadyRegistration = isAlreadyRegistration;
    }

   
}
