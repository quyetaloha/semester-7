
package model;

import java.io.Serializable;

public class Book implements Serializable{

    private String title,author,field;
    private int code,year,numbers;

    public Book(int code, String title, 
            String author, String field,
            int year, int numbers) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.field = field;        
        this.year = year;
        this.numbers = numbers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
    
    
    
    public Object[] toObject() {
        return new Object[]{code,title,author,
            field,year,numbers};        
    }   
}