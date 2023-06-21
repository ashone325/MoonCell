package com.example.service;
import com.example.pojo.Auser;
import com.example.util.Result;

import java.util.List;

public interface Auserservice {

    List<Auser> find_user(); //查询用户
     Auser login(String name,String pwd);
     void Insert(String name,String password);
        boolean checkAdminByname(String name);//查看是否为管理员

     boolean updateUser(String name,String pwd,String userimg);
    Result getuserList(int page, int limit);


}
