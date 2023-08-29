
package com.example.dao;

import com.example.pojo.Game;
import com.example.pojo.GameExample;
import java.util.List;

import com.example.pojo.OrderRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Mapper
public interface GameMapper {
    long countByExample(GameExample example);

    int deleteByExample(GameExample example);

    boolean deleteByPrimaryKey(Integer id);

    int insert(Game record);

    boolean insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer id);

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




}
