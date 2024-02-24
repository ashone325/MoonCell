package com.example.dto;

public class CommentDetailDto {
    private int id;
    private String comment;
    private String gameName;
    private String userName;

    // 构造方法
    public CommentDetailDto() {}

    // Getter和Setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
