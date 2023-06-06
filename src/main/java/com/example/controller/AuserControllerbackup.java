/*
package com.example.controller;

import com.example.pojo.Auser;
import com.example.service.Auserservice;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AuserControllerbackup {
    @Resource
    Auserservice auserservice;
    @RequestMapping("/find")
    public void find(){
        List<Auser> ausers = auserservice.find_user();
        for(Auser auser:ausers){
            System.out.println(auser.getName());
        }

    }

    @GetMapping("/userlogin")
    public String login(){
        return "admin/login";//打开admin文件夹之下的login.html静态文件
    }
    @PostMapping("/userlogin")
    public String login(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpSession session){ //@RequestParam 是传进来的值在html那边的名字
        if(!StringUtils.hasText(name)||!StringUtils.hasText(pwd)){
            session.setAttribute("erroMsg","用户名和密码不能为空");
            return "admin/login";
        }
        Auser auser = auserservice.login(name, pwd);
        if(auser!=null){
            //return "admin/index"; //地址不变，index.html直接加载到当前页面
            return "redirect:admin/sys_index"; //地质发生变化，变为admin/sys_index

        }
        else {
            session.setAttribute("errorMsg","用户名或密码错误");

            return "admin/login";

        }

    }

    @GetMapping("/signup")
    public String disp(){
        return "admin/signup";
    }

    //实现注册功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String name,String password){
        auserservice.Insert(name, password);
        return "admin/success";
    }
    @GetMapping("/sys_index")
    public String index(){
        return "admin/index";
    }
}
*/
