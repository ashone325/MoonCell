
package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Game {
    private Integer id;

    private String dname;

    private String dtel;

    private String description;
    private String gamelogo;

    public String getPrice() {
        return description;
    }

    public void setPrice(String price) {
        this.description = price;
    }

    private String price;

    public void setGamelogo(String gamelogo) {
        this.gamelogo = gamelogo;
    }

    public String getGamelogo() {
        return gamelogo;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date establishmentdate;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel == null ? null : dtel.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(Date establishmentdate) {
        this.establishmentdate = establishmentdate;
    }
}
