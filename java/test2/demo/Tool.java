
package demo;

public class Tool {
    //Đưa ra tổng   
    public int tong(int[] a){
        int t=0;
        for(int i:a)
            t+=i;
        return t;
    }
    //Đưa ra trung bình
    public int trungbinh(int[] a){
        int t=0;
        for(int i:a)
            t+=i;
        t=t/a.length;
        return t;
    }
    //Sawsp xeesp
    public int[] sapxep(int[] a){
        int[] t=new int[a.length];
        int x;
        for(int i=0;i<a.length;i++)
            t[i]=a[i];
        for(int i=0;i<a.length-1;i++)
            for(int j=i+1;j<a.length;j++){
                if(t[i]>t[j]){
                    x=t[i];
                    t[i]=t[j];
                    t[j]=x;
                }
            }
        return t;
    }
    
    //Đưa ra giá trị lớn nhất, nhỏ nhất 
    public String maxmin(int[] a){        
        int ma=a[0],mi=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>ma)
                ma=a[i];
            if(a[i]<mi)
                mi=a[i];
                }
        return "Max:"+ma+" Min:"+mi;
    }
}
