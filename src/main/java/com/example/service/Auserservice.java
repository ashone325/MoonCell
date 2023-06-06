package com.example.service;
import com.example.dao.AuserMapper;
import com.example.pojo.Auser;

import javax.annotation.Resource;
import java.util.List;

public interface Auserservice {
     List<Auser> find_user(); //查询用户
     Auser login(String name,String pwd);
     void Insert(String name,String password);


}
