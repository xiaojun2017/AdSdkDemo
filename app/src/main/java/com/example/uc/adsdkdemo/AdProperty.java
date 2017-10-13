package com.example.uc.adsdkdemo;

/**
 * Created by UC on 2017/9/26.
 */

public class AdProperty {
    private int id;
    private String name;

    public AdProperty(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
