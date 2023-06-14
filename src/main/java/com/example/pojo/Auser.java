package com.example.pojo;

public class Auser {
    private String name;

    private String pwd;

    private String userimg;
    private String userpower;


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