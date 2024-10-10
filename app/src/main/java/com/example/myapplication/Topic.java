package com.example.myapplication;

import java.util.ArrayList;

public class Topic {

    private String Name;
    private ArrayList<String> bookList;

    public Topic(String name, ArrayList<String> bookList) {
        Name = name;
        this.bookList = bookList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<String> bookList) {
        this.bookList = bookList;
    }


}
