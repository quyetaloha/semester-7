
package morelist;


public class Book extends Document{
    //author, title and the number of pages
    private String author,title;
    private int pages;
    public Book(){
        super();
    }

    public Book(String code, String publisher, int circulation,
            String author, String title, int pages) {
        super(code, publisher, circulation);
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public String toString(){
        return super.toString()+"\t"+author+"\t"+title+"\t"+pages;
    }
}
