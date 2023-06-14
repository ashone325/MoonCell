package com.example.entity;

import java.io.Serializable;

public class AuserBean implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private char is_admin;

    public char getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(char is_admin) {
        this.is_admin = is_admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
