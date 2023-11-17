package com.example.javafxdemo;

public class Immigrant{
    private int immigrantID;
    private String name;
    private int dateOfDeath;

    public Immigrant(int immigrantID, String name, int dateOfDeath){
        this.immigrantID = immigrantID;
        this.name=name;
        this.dateOfDeath=dateOfDeath;
    }
    public int getImmigrantID(){
        return immigrantID;
    }
    public String getName(){
        return name;
    }
    public int getDateOfDeath(){
        return dateOfDeath;
    }


}