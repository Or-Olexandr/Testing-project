package com.company;

public class Client extends Person  {
 private Type type;
 public Client(String name, String surname, Type type)
 {
     super(name,surname);
     this.type=type;
 }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+"\nSurname: "+getSurname()+"\nType: "+getType();
    }

    public Type getType()
 {
     return this.type;
 }
}
