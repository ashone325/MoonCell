
package com.example.dao;

import com.example.dto.CommentDetailDto;
import com.example.pojo.Game;
import com.example.pojo.GameExample;
import java.util.List;
import com.example.pojo.Comment;

import com.example.pojo.OrderRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameMapper {
    long countByExample(GameExample example);

    int deleteByExample(GameExample example);

    boolean deleteByPrimaryKey(Integer id);

    int insert(Game record);

    boolean insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer id);
    Game getgameById(@Param("Id") int id);


    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    boolean updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
    int getTotalgames();//查询总记录数
     List<Game> findgameList(int start, int limit);//分页查询表中记录
    int getTotalgamesByname(String dname);//查询包含dname的总记录数

    List<Game> findgameListByname(String dname, int start, int limit);//按dname分页查询表中记录
    @Select("select * from game") List<Game> getAllGames();
    void insertOrder(OrderRequest orderRequest);
    List<Game> getGamesByUserId(int userId);
    Comment getCommentByGameid(int gameId);
    //插入评论
    void insertComment(String Comment,int gameId,int userId);
    void deleteCommentById(Long commentId); // 新增删除评论的方法
    List<CommentDetailDto> findAllCommentsWithDetails();



}
