package com.example.dao;

import com.example.pojo.Auser;
import com.example.pojo.AuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AuserMapper {
     List<Auser> find_user(); //查询用户

    Auser login(String username,String pwd);
    long countByExample(AuserExample example);

    int deleteByExample(AuserExample example);

    int deleteByPrimaryKey(String name);

    int insert(Auser record);

    int insertSelective(Auser record);

    List<Auser> selectByExample(AuserExample example);

    Auser selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Auser record, @Param("example") AuserExample example);

    int updateByExample(@Param("record") Auser record, @Param("example") AuserExample example);

    int updateByPrimaryKeySelective(Auser record);

    int updateByPrimaryKey(Auser record);
    @Insert("insert into auser(name,pwd)values(#{name},#{password})")
    void saveInfo(@Param("name") String name, @Param("password") String password);
}