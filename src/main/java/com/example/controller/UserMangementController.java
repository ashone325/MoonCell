
package com.example.controller;

import com.example.pojo.Auser;
import com.example.pojo.Game;
import com.example.service.Auserservice;
import com.example.util.MD5Util;
import com.example.util.Result;
import com.example.util.UploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.example.util.MD5Util;

@Controller
@RequestMapping("/user")
public class UserMangementController {
    @Resource
    Auserservice auserservice;
    @GetMapping("/user")
    public String list(){
        return "admin/user-list";
    }
    @GetMapping("/listall")
    @ResponseBody
    public Result listall(@RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return auserservice.getuserList(start,limit);//
    }
    @GetMapping("/listbyname")
    @ResponseBody
    public Result listByName(@RequestParam("name")String name, @RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return auserservice.getUserListByname(name,start,limit);//
    }


    @PostMapping("/delete")
    @ResponseBody
    public Result deleteUser(@RequestParam("id") String id ) {//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等

        return auserservice.deleteUser(id);
    }
    //1.先显示被改部门的信息 get
    @GetMapping("/edit")
    public String gotogameedit(@RequestParam("id") String id, Model model){
        Auser user =  auserservice.getUserById(id);
        //对应id 信息送到前端
        model.addAttribute("userInfo",user);
        return "admin/user-edit";
    }
    //2.修改部门信息post
    @PostMapping("/edit")
    @ResponseBody
    public Result saveuser(@RequestParam(required = false) String id,@RequestParam("name") String name ,@RequestParam("pwd") String pwd,@RequestParam(required = false) String description){//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等
        Auser user =  auserservice.getUserById(id);
        user.setName(name);
        String newpwd = MD5Util.MD5Encode(pwd,"UTF-8");
        user.setPwd(newpwd);
        user.setUserimg(description);
        return auserservice.saveUser(user);
    }
    @ResponseBody
    @GetMapping("/reload")
    public boolean reload(HttpSession session){
        String name = session.getAttribute("name").toString();
        return  name != null;
    }

}

