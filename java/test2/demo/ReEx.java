
package demo;


public class ReEx {
    public boolean isPhoneValid(String phone){    
    String regex = 
    "^\\(?\\d{3}\\)?-?\\s*\\d{3}\\s*-?\\d{4}$";
    return phone.matches(regex);
    }
    public boolean isCode(String code){    
    String regex = "^[Bb]{1}\\d{2}[A-Za-z]{4}\\d{3}$";
    return code.matches(regex);
    }
    public boolean isDate(String d){    
    String regex = "\\d{2}/\\d{2}/\\d{4}";
    return d.matches(regex);
    }
    


}
