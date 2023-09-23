package com.example.service;

import com.example.pojo.Comment;
import org.springframework.stereotype.Service;

@Service

public interface CommentService {

    Comment showcomment(int gameId);
    void insertComment(String Comment,int gameId,int userId);


}
