package com.example.pojo;

public class Auser {
    private String name;

    private String pwd;

    private String userimg;
    private String userpower;
    private int id;


    public void setUserpower(String userpower) {
        this.userpower = userpower;
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
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUserimg() {
        return userimg;
    }
    public String getUserpower(){
        return userpower;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }

}