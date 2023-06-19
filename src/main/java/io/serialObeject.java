package io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class serialObeject implements Cloneable, Serializable {
    String name;
    Address address;
    List<String> list = new ArrayList<>();
    public serialObeject(String name ,Address address){
        this.name = name;
        this.address = address;
        list.add("yu");
        list.add("gugugu");
        list.add("wang");
    }
    @Override
    public serialObeject clone() throws CloneNotSupportedException{
        serialObeject clone = (serialObeject) super.clone();
        clone.address = address.clone();
        return  clone;
    }
}
class Address implements Cloneable, Serializable{
    private String addr;

    public Address(String addr){
        this.addr = addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }
    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
    }
}
