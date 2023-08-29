package com.example.service;
import com.example.dao.AuserMapper;
import com.example.dao.AuserMapper;
import com.example.pojo.Auser;
import com.example.pojo.Game;
import com.example.pojo.Auser;
import com.example.util.MD5Util;
import com.example.util.Result;
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
    public boolean checkAdminByname(String name) {
        return auserMapper.checkAdminByname(name);
    }

    @Override
    public boolean updateUser(String name, String pwd, String userimg) {
        Auser auser=new Auser();
        auser.setName(name);
        auser.setPwd(pwd);
        auser.setUserimg(userimg);
        return auserMapper.updateByPrimaryKeySelective(auser);
    }


    @Override
    public Result getuserList(int start, int limit) {
        List<Auser> userList = auserMapper.finduserList(start,
                limit);
        int totalusers = auserMapper.getTotalusers();
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalusers);
        result.setData(userList);
        return result;
    }



    @Override
    public Result getUserListByname(String dname,int start, int limit) {
        List<Auser> userList = auserMapper.finduserListByname(dname,start,
                limit);
        int totalusers = auserMapper.getTotalusersByname(dname);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalusers);
        result.setData(userList);
        return result;
    }

    @Override
    public Auser getUserByName(String name) {
        return null;
    }


    @Override
    public Result deleteUser(String name) {
        Result result = new Result();
        if (auserMapper.deleteByPrimaryKey(name)){
            result.setCode(0);
            result.setMsg("删除成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("删除失败！");
        }
        return result;
    }

    @Override
    public Auser getUserById(String id) {
        return auserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result saveUser(Auser user) {
        Result result = new Result();
        if (auserMapper.updateByPrimaryKeySelective(user)){
            result.setCode(0);
            result.setMsg("修改成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("修改失败！");
        }
        return result;
    }



    @Override
    public List<Auser> findAllUsers() {
        return auserMapper.getAllUsers();
    }

}
