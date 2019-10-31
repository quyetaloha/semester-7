/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Viet Nguyen
 */
public class Answer implements Serializable{
    static final long serialVersionUID  = 2L;
    private Student student;
    private Object[] answer;
    private boolean isRight;
    private boolean isAlreadyRegistration;

    @Override
    public String toString() {
        return "Answer{" + "student=" + student + ", answer=" + Arrays.toString(answer) + ", isRight=" + isRight + ", isAlreadyRegistration=" + isAlreadyRegistration + '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Object[] getAnswer() {
        return answer;
    }

    public void setAnswer(Object[] answer) {
        this.answer = answer;
    }

    public boolean isIsRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public boolean isIsAlreadyRegistration() {
        return isAlreadyRegistration;
    }

    public void setIsAlreadyRegistration(boolean isAlreadyRegistration) {
        this.isAlreadyRegistration = isAlreadyRegistration;
    }
    
    
}
