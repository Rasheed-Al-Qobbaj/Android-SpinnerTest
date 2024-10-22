package com.example.myapplication;

import java.util.ArrayList;

public class Brands {

    private String Name;

    private ArrayList<Glasses> glasses;

    public Brands(String name, ArrayList<Glasses> glasses) {
        Name = name;
        this.glasses = glasses;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Glasses> getGlasses() {
        return glasses;
    }

    public void setGlasses(ArrayList<Glasses> glasses) {
        this.glasses = glasses;
    }

}
