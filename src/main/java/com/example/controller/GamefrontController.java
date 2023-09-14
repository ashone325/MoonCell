
package com.example.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.pojo.Auser;
import com.example.pojo.Game;
import com.example.service.Auserservice;
import com.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gamefront")//商店页面
public class GamefrontController {

    @Resource
    GameService gameService;
    @Autowired
    Auserservice auserservice;
    @GetMapping("game")
    public String showGames(Model model) {
        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);
        return "gamefront/game";

    }
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
        // 保存图片到服务器
        String fileName = file.getOriginalFilename();
        String filePath = "D:\\TheGameStore2\\src\\main\\resources\\static\\gamelogo"; // 你可以修改这个路径
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            // 把图片的路径传给模板
            model.addAttribute("imagePath", filePath + fileName);
            return "success"; // 返回成功页面
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // 返回错误页面
        }
    }
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        // 从模板里获取图片的路径
        String imagePath = (String) model.getAttribute("imagePath");
        // 把图片的路径传给成功页面
        model.addAttribute("imagePath", imagePath);
        return "success"; // 返回成功页面的模板名
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error"; // 返回错误页面的模板名
    }




}