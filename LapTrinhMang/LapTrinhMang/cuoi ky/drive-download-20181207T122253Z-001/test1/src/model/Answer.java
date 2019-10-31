/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Viet Nguyen
 */
public class Answer implements Serializable{
    static final long serialVersionUID = 2L;
    private Student student;
    private String reverseStringAnswer;
    private String normalizationStringAnswer;
    private int maxNumericAnswer;
    private int uclnNumericAnswer;
    private int bcnnNumericAnswer;
    
    
    private boolean isAlreadyRegistration;
    private boolean isReverseStringAnswerRiht;
    private boolean isMaxNumericAnswerRiht;
    private boolean isNormalizationStringAnswerRiht;
    private boolean isBSCNNNumericAnswerRiht;
    private boolean isUSCLNNumericAnswerRiht;

    @Override
    public String toString() {
        return "Answer{" + "student=" + student + ", reverseStringAnswer=" + reverseStringAnswer + ", normalizationStringAnswer=" + normalizationStringAnswer + ", maxNumericAnswer=" + maxNumericAnswer + ", uclnNumericAnswer=" + uclnNumericAnswer + ", bcnnNumericAnswer=" + bcnnNumericAnswer + ", isAlreadyRegistration=" + isAlreadyRegistration + ", isReverseStringAnswerRiht=" + isReverseStringAnswerRiht + ", isMaxNumericAnswerRiht=" + isMaxNumericAnswerRiht + ", isNormalizationStringAnswerRiht=" + isNormalizationStringAnswerRiht + ", isBSCNNNumericAnswerRiht=" + isBSCNNNumericAnswerRiht + ", isUSCLNNumericAnswerRiht=" + isUSCLNNumericAnswerRiht + '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getReverseStringAnswer() {
        return reverseStringAnswer;
    }

    public void setReverseStringAnswer(String reverseStringAnswer) {
        this.reverseStringAnswer = reverseStringAnswer;
    }

    public String getNormalizationStringAnswer() {
        return normalizationStringAnswer;
    }

    public void setNormalizationStringAnswer(String normalizationStringAnswer) {
        this.normalizationStringAnswer = normalizationStringAnswer;
    }

    public int getMaxNumericAnswer() {
        return maxNumericAnswer;
    }

    public void setMaxNumericAnswer(int maxNumericAnswer) {
        this.maxNumericAnswer = maxNumericAnswer;
    }

    public int getUclnNumericAnswer() {
        return uclnNumericAnswer;
    }

    public void setUclnNumericAnswer(int uclnNumericAnswer) {
        this.uclnNumericAnswer = uclnNumericAnswer;
    }

    public int getBcnnNumericAnswer() {
        return bcnnNumericAnswer;
    }

    public void setBcnnNumericAnswer(int bcnnNumericAnswer) {
        this.bcnnNumericAnswer = bcnnNumericAnswer;
    }

    public boolean isIsAlreadyRegistration() {
        return isAlreadyRegistration;
    }

    public void setIsAlreadyRegistration(boolean isAlreadyRegistration) {
        this.isAlreadyRegistration = isAlreadyRegistration;
    }

    public boolean isIsReverseStringAnswerRiht() {
        return isReverseStringAnswerRiht;
    }

    public void setIsReverseStringAnswerRiht(boolean isReverseStringAnswerRiht) {
        this.isReverseStringAnswerRiht = isReverseStringAnswerRiht;
    }

    public boolean isIsMaxNumericAnswerRiht() {
        return isMaxNumericAnswerRiht;
    }

    public void setIsMaxNumericAnswerRiht(boolean isMaxNumericAnswerRiht) {
        this.isMaxNumericAnswerRiht = isMaxNumericAnswerRiht;
    }

    public boolean isIsNormalizationStringAnswerRiht() {
        return isNormalizationStringAnswerRiht;
    }

    public void setIsNormalizationStringAnswerRiht(boolean isNormalizationStringAnswerRiht) {
        this.isNormalizationStringAnswerRiht = isNormalizationStringAnswerRiht;
    }

    public boolean isIsBSCNNNumericAnswerRiht() {
        return isBSCNNNumericAnswerRiht;
    }

    public void setIsBSCNNNumericAnswerRiht(boolean isBSCNNNumericAnswerRiht) {
        this.isBSCNNNumericAnswerRiht = isBSCNNNumericAnswerRiht;
    }

    public boolean isIsUSCLNNumericAnswerRiht() {
        return isUSCLNNumericAnswerRiht;
    }

    public void setIsUSCLNNumericAnswerRiht(boolean isUSCLNNumericAnswerRiht) {
        this.isUSCLNNumericAnswerRiht = isUSCLNNumericAnswerRiht;
    }
    
    

    
    
}
