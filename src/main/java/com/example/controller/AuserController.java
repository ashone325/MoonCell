package com.example.controller;

import com.example.entity.LoginRequest;
import com.example.pojo.Auser;
import com.example.service.Auserservice;
import com.example.util.MD5Util;
import com.example.util.Result;
import com.example.util.UploadFileUtils;
import org.springframework.stereotype.Controller;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:8081")
public class AuserController {
    @Resource
    Auserservice auserservice;
    @RequestMapping("/find")
    public void find(){
        List<Auser> ausers = auserservice.find_user();
        for(Auser auser:ausers){
            System.out.println(auser.getName());
        }

    }
    @GetMapping("/password")
    @ResponseBody
    public boolean validatePassword(String oldPwd, HttpSession session) {
  String pwd = session.getAttribute("pwd").toString();
  oldPwd = MD5Util.MD5Encode(oldPwd, "UTF-8");
  if (pwd.equals(oldPwd)) {
    return true;
 }
  return false;
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
            session.setAttribute("name", auser.getName());
            session.setAttribute("pwd", auser.getPwd());
            session.setAttribute("userimg", auser.getUserimg());
            session.setAttribute("userpower",auser.getUserpower());
            //return "admin/index"; //地址不变，index.html直接加载到当前页面
            if(auserservice.checkAdminByname(name)){//如果是管理员    //auserservice.checkAdminByname(name)是判断是否是管理员 1是管理员 0是普通用户
            return "/admin/index"; //地质发生变化，变为admin/sys_index}
            }
            else{//如果是普通用户
                System.out.println(auserservice.checkAdminByname(name));
                return "redirect:/gamefront/game";
            }

        }
        else {
            session.setAttribute("errorMsg","用户名或密码错误");

            return "admin/login";

        }

    }
    //课上增加学习用
    @PostMapping("/abc")
    @ResponseBody
    public com.example.entity.Result abc(@RequestBody LoginRequest loginRequest) {
        // 从请求体中获取用户名和密码
        String name = loginRequest.getUsername();
        String pwd = loginRequest.getPassword();

        // 打印用户名和密码到控制台
        System.out.println("用户名: " + name);
        System.out.println("密码: " + pwd);

        // 返回一个简单的成功消息
        return new com.example.entity.Result(200, "登录请求已接收");
    }


    @GetMapping("/signup")

    public String disp(){
        return "admin/signup";
    }

    //实现注册功能
    @RequestMapping(value = "admin/register",method = RequestMethod.POST)
    public String signUp(String name,String password){
        auserservice.Insert(name, password);
        return "admin/success";
    }
    @GetMapping("/sys_index")
    public String index(){
        return "admin/index";
    }
    @GetMapping("/userInfo")
    public String gotoUserInfo() {
        return "admin/userInfo-edit";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "admin/login";
    }

    @PostMapping({"/upload/userImg"})
    @ResponseBody
    public boolean upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpSession session) throws URISyntaxException {
        String suffixName = UploadFileUtils.getSuffixName(file);
        String newFileName = UploadFileUtils.getNewFileName(suffixName);

        String path = System.getProperty("user.dir") + "/upload/";
        String realPath = path.replace('/', '\\');
        //realPath：服务器物理存储地址

        File fileDirectory = new File(realPath);
        File destFile = new File(realPath + newFileName);  //创建文件
        try {
            if (!fileDirectory.exists() && !fileDirectory.mkdirs()) {
                throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
            }
            file.transferTo(destFile);

            URI uri = UploadFileUtils.getHost(new URI(request.getRequestURL() + ""));
            String sqlImg = uri + "/upload/" + newFileName;  //sqlImg：数据库存储地址
            session.setAttribute("userimg", sqlImg);
            auserservice.updateUser(session.getAttribute("name").toString(),
                    session.getAttribute("pwd").toString(), session.getAttribute("userimg").toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
/*    @PostMapping("/addGameToUser")
    @ResponseBody
    public Map<String, Object> addGameToUser(@RequestParam Integer gameId, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 假设您在session中存储了用户信息
            Auser currentUser = (Auser) session.getAttribute("user");
            if (currentUser != null) {
                auserservice.addGameToUser(currentUser.getId(), gameId);
                map.put("success", true);
                map.put("message", "游戏已添加到用户");
            } else {
                map.put("success", false);
                map.put("message", "用户未登录");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "服务器错误");
        }
        return map;
    }*/


}
