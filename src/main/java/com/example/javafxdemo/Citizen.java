package com.example.javafxdemo;

public class Citizen {

    private int citizenID;
    private String name;
    private String email;

    public Citizen(int citizenID, String name, String email){
        this.citizenID=citizenID;
        this.name=name;
        this.email=email;
    }
    public int getCitizenID(){
        return citizenID;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

}
