package com.example.service;

import com.example.dao.GameMapper;
import com.example.dto.CommentDetailDto;
import com.example.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicempl implements CommentService {
    private final GameMapper gameMapper;

    @Autowired
    public CommentServicempl(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    @Override
    public Comment showcomment(int gameId) {
        return gameMapper.getCommentByGameid(gameId);
    }

    @Override
    public void insertComment(String Comment, int gameId, int userId) {
       gameMapper.insertComment(Comment,gameId,userId);

    }
    @Override
    public void deleteCommentById(Long commentId) {
        gameMapper.deleteCommentById(commentId);
    }

    @Override
    public List<CommentDetailDto> getAllComments() {
        return gameMapper.findAllCommentsWithDetails();
    }

}

