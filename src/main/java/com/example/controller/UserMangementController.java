
package com.example.controller;

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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserMangementController {
    @Resource
    Auserservice auserservice;
    @GetMapping("/user")
    public String list(){
        return "admin/user-list";
    }
    @GetMapping("/game/add")
    public String gotogameadd(){return "admin/game-add";}
    @GetMapping("/listall")
    @ResponseBody
    public Result listall(@RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return auserservice.getuserList(start,limit);//
    }

}

