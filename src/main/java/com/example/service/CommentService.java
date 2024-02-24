package com.example.service;

import com.example.dto.CommentDetailDto;
import com.example.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CommentService {

    Comment showcomment(int gameId);
    void insertComment(String Comment,int gameId,int userId);

    void deleteCommentById(Long commentId); // 新增删除评论的方法

    List<CommentDetailDto> getAllComments();
}
