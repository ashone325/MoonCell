
package com.example.dao;

import com.example.pojo.Auser;
import com.example.pojo.AuserExample;
import java.util.List;

import com.example.pojo.Game;
import com.example.util.Result;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AuserMapper {
     List<Auser> find_user(); //查询用户

    Auser login(String username,String pwd);
    long countByExample(AuserExample example);

    int deleteByExample(AuserExample example);

    boolean deleteByPrimaryKey(String name);

    int insert(Auser record);

    int insertSelective(Auser record);

    List<Auser> selectByExample(AuserExample example);

    Auser selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Auser record, @Param("example") AuserExample example);

    int updateByExample(@Param("record") Auser record, @Param("example") AuserExample example);

    boolean updateByPrimaryKeySelective(Auser record);
    int getTotalusers();
    public Result getuserList(int start, int limit);


    int updateByPrimaryKey(Auser record);
    @Insert("insert into auser(name,pwd)values(#{name},#{password})")
    void saveInfo(@Param("name") String name, @Param("password") String password);
    boolean checkAdminByname(String name);//查看是否为管理员
     @Select("select * from auser")  List<Auser> getAllUsers();
    List<Auser> finduserList(int start, int limit);//分页查询表中记录
    List<Auser> finduserListByname(String dname, int start, int limit);//按dname分页查询表中记录
    int getTotalusersByname(String dname);//查询包含dname的总记录数
    int addGameToUser(int userid,int gameid);//将购买游戏添加到usergames表中


}

