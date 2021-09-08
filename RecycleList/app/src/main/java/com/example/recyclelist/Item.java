package com.example.recyclelist;

public class Item {
    private String name;
    private String last_name;
    private int photo;

    public Item() {

    }

    public Item(String name, String last_name, int photo) {
        this.name = name;
        this.last_name = last_name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
