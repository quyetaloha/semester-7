package model;

import java.io.Serializable;

public class Answer implements Serializable{
    static final long serialVersionUID = 2L;
    Student student;
    
    String reverseStringAnswer;
    String normalizationStringAnswer;
    int maxNumericAnswer;
    int uclnNumericAnswer;
    int bcnnNumericAnswer;
    
    boolean isAlreadyRegistration;
    boolean isReverseStringAnswerRight;
    boolean isMaxNumericAnswerRight;
    boolean isNormalizationStringAnswerRight;
    boolean isBSCNNNumericAnswerRight;
    boolean isUCCLNNumericAnswerRight;

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Answer{" + "student=" + student + ", reverseStringAnswer=" + reverseStringAnswer + ", normalizationStringAnswer=" + normalizationStringAnswer + ", maxNumericAnswer=" + maxNumericAnswer + ", uclnNumericAnswer=" + uclnNumericAnswer + ", bcnnNumericAnswer=" + bcnnNumericAnswer + ", isAlreadyRegistration=" + isAlreadyRegistration + ", isReverseStringAnswerRight=" + isReverseStringAnswerRight + ", isMaxNumericAnswerRight=" + isMaxNumericAnswerRight + ", isNormalizationStringAnswerRight=" + isNormalizationStringAnswerRight + ", isBSCNNNumericAnswerRight=" + isBSCNNNumericAnswerRight + ", isUCCLNNumericAnswerRight=" + isUCCLNNumericAnswerRight + '}';
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

    public boolean isIsReverseStringAnswerRight() {
        return isReverseStringAnswerRight;
    }

    public void setIsReverseStringAnswerRight(boolean isReverseStringAnswerRight) {
        this.isReverseStringAnswerRight = isReverseStringAnswerRight;
    }

    public boolean isIsMaxNumericAnswerRight() {
        return isMaxNumericAnswerRight;
    }

    public void setIsMaxNumericAnswerRight(boolean isMaxNumericAnswerRight) {
        this.isMaxNumericAnswerRight = isMaxNumericAnswerRight;
    }

    public boolean isIsNormalizationStringAnswerRight() {
        return isNormalizationStringAnswerRight;
    }

    public void setIsNormalizationStringAnswerRight(boolean isNormalizationStringAnswerRight) {
        this.isNormalizationStringAnswerRight = isNormalizationStringAnswerRight;
    }

    public boolean isIsBSCNNNumericAnswerRight() {
        return isBSCNNNumericAnswerRight;
    }

    public void setIsBSCNNNumericAnswerRight(boolean isBSCNNNumericAnswerRight) {
        this.isBSCNNNumericAnswerRight = isBSCNNNumericAnswerRight;
    }

    public boolean isIsUCCLNNumericAnswerRight() {
        return isUCCLNNumericAnswerRight;
    }

    public void setIsUCCLNNumericAnswerRight(boolean isUCCLNNumericAnswerRight) {
        this.isUCCLNNumericAnswerRight = isUCCLNNumericAnswerRight;
    }
    
}
