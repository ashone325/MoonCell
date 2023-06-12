package com.example.service;
import com.example.dao.AuserMapper;
import com.example.pojo.Auser;
import com.example.service.Auserservice;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuserServiceImpl implements Auserservice {
    @Resource
    AuserMapper auserMapper;

    @Override
    public List<Auser> find_user() {
        return auserMapper.find_user();
    }

    @Override
    public Auser login(String name, String pwd) {
        String md5pwd = MD5Util.MD5Encode(pwd,"utf-8");
        return auserMapper.login(name,md5pwd);
    }
    @Override
    public void Insert(String name,String password){
        String md5pwd = MD5Util.MD5Encode(password,"utf-8");
        auserMapper.saveInfo(name, md5pwd);
    }

    @Override
    public boolean updateUser(String name, String pwd, String userimg) {
        Auser auser=new Auser();
        auser.setName(name);
        auser.setPwd(pwd);
        auser.setUserimg(userimg);
        return auserMapper.updateByPrimaryKeySelective(auser);
    }

}
