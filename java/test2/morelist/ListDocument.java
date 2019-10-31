
package morelist;

import java.util.ArrayList;
import java.util.Scanner;


public class ListDocument {
    ArrayList<Document> list;
    public ListDocument(){
        list=new ArrayList<Document>();
    }
     private boolean isCode(String code){        
        for(Document d:list)
            if(d.getCode().equalsIgnoreCase(code))
                return true;
        return false;        
    }
    private Document input(){        
        Document d=null;
        String code,publisher;
        int circulation;
        
        Scanner in=new Scanner(System.in); 
        while(true){
               System.out.print("Code: ");
               code = in.nextLine();
               if(code.matches("^[A-Za-z]{2}\\d{4}$"))
                  break;
            }
        if(isCode(code))
            return null; 
        System.out.print("Publisher:");
        publisher=in.nextLine();
        System.out.print("Circulation:");
        circulation=Integer.parseInt(in.nextLine());        
        d=new Document(code, publisher, circulation);        
        return d;
    }
    public boolean inputBook(){
        String author,title;
        int pages;
        Document d=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Author:");
        author=in.nextLine();
        System.out.print("Title book:");
        title=in.nextLine();
        System.out.print("Number of pages:");
        pages=in.nextInt();
        return list.add(new Book(d.getCode(),d.getPublisher(),d.getCirculation(),
                author, title, pages));
    }
    public boolean inputMagazine(){
        int number,monthly;
        Document d=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Number:");
        number=in.nextInt();
        System.out.print("Monthly:");
        monthly=in.nextInt();        
        return list.add(new Magazine(d.getCode(),d.getPublisher(),d.getCirculation(),
                number,monthly));
    }
    public boolean inputNewspaper(){
        String date;
        Document d=input();
        Scanner in=new Scanner(System.in);
        System.out.print("Date :");
        date=in.nextLine();               
        return list.add(new Newspaper(d.getCode(),d.getPublisher(),d.getCirculation(),
                date));
    }
    public int getNumberofBook(){
        int count=0;
        for(Document i:list)
          if(i instanceof Book)
              count++;
        return count;
    }
    public int getNumberofMagazine(){
        int count=0;
        for(Document i:list)
          if(i instanceof Magazine)
              count++;
        return count;
    }
    public int getNumberofNewspaper(){
        int count=0;
        for(Document i:list)
          if(i instanceof Newspaper)
              count++;
        return count;
    }
    public void output(){
      if(getNumberofBook()>0){
        System.out.println("List of Books");
        System.out.println("Code  Publisher  Circulation  Author   Title Pages");
        for(Document i:list){
            if(i instanceof Book)
            System.out.println(i.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of books:"+getNumberofBook());
      }  
      if(getNumberofMagazine()>0){
        System.out.println("List of Magazine");
        System.out.println("Code  Publisher  Circulation  Number  Monthly");
        for(Document i:list){
            if(i instanceof Magazine)
            System.out.println(i.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of magazines:"+getNumberofMagazine());
      }
      if(getNumberofNewspaper()>0){
        System.out.println("List of Newspapers");
        System.out.println("Code  Publisher  Circulation  Date");
        for(Document i:list){
            if(i instanceof Newspaper)
            System.out.println(i.toString());
        }
        System.out.println("----------------------");
        System.out.println("Number of newspapers:"+getNumberofNewspaper());
      }
    }
    private Document searchingByCode(String code){        
        for(Document d:list)
            if(d.getCode().equalsIgnoreCase(code))
                return d;
        return null;                        
    }
    public boolean editDocument(){
        String code;
        System.out.print("input code for Document to edit:");
        Scanner in=new Scanner(System.in);
        code=in.nextLine();
        Document d=searchingByCode(code);
        if(d==null)
            return false;
        else{            
             d=list.get(list.indexOf(d));
             String publisher;
             int circulation;         
             System.out.print("Publisher:");
             publisher=in.nextLine();
             System.out.print("Circulation:");
             circulation=Integer.parseInt(in.nextLine());
             d.setPublisher(publisher);
             d.setCirculation(circulation);
             if(d instanceof Book){
                 System.out.println("Edit Book");
                 String author,title;
                 int pages;
                 System.out.print("Author:");
                 author=in.nextLine();
                 System.out.print("Title book:");
                 title=in.nextLine();
                 System.out.print("Number of pages:");
                 pages=in.nextInt();
                 ((Book) d).setAuthor(author);
                 ((Book) d).setTitle(title);
                 ((Book) d).setPages(pages);
             }
             if(d instanceof Magazine){
                 System.out.println("Edit Magazine");
                 int number,monthly;                                  
                 System.out.print("Number:");
                 number=in.nextInt();
                 System.out.print("Monthly:");
                 monthly=in.nextInt();
                 ((Magazine) d).setNumber(number);
                 ((Magazine) d).setMonthly(monthly);
             }
             if(d instanceof Newspaper){
                 System.out.println("Edit Newspaper");
                 String date;                                  
                 System.out.print("Date:");
                 date=in.nextLine();                 
                 ((Newspaper) d).setDate(date);
             }
            return true; 
         }       
    }
    public boolean delete(){
        boolean re;
        String code;
        System.out.print("input code for Document to delete:");
        Scanner in=new Scanner(System.in);
        code=in.nextLine();
        Document d=searchingByCode(code);
        if(d==null)
            re=false;
        else
            re=list.remove(d);
        return re;
    }
}
