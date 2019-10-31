
package model;

import java.io.Serializable;

public class Reader implements Serializable{
    private int code;
    private String name,address;
    private long phone;

    public Reader() {
    }

    public Reader(int code, String name, String address, long phone) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

        
    public Object[] toObject() {
        return new Object[]{code,name,address,
            phone};
    }   
}