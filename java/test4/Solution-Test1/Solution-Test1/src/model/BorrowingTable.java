
package model;


import java.io.Serializable;

public class BorrowingTable implements Serializable{
    private Reader reader;
    private Book book;    
    private int nums;
    private String status;

    public BorrowingTable(Reader reader, Book book, 
            int nums,
            String status) {        
        this.reader = reader;
        this.book = book;
        this.nums = nums;
        this.status=status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getCodeBook(){
        return book.getCode();
    }
    
    public int getCodeReader(){
        return reader.getCode();
    }
    
    public String getTitleBook(){
        return book.getTitle();
    }
    
    public String getNameReader(){
        return reader.getName();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public Object[] toObject() {
        return new Object[]{getCodeReader(),getNameReader(),
            getCodeBook(),getTitleBook(),
            nums,status};
    }
    
}
