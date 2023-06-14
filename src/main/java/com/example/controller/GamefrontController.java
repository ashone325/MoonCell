package com.example.controller;

import com.example.dao.GameMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class GamefrontController {
    // 在你的Controller类中，定义一个方法来处理游戏列表的请求
    @Resource
    GameMapper gameMapper;
    @GetMapping("/admin/games")
    public ModelAndView showGames() {
        // 创建一个ModelAndView对象，指定要返回的视图名称为games.html
        ModelAndView mav = new ModelAndView("admin/games");
        // 调用你的数据库操作类，获取游戏列表
        int games = gameMapper.getTotalgames();
        // 把游戏列表添加到ModelAndView对象中，使用games作为键名
        mav.addObject("games", games);
        // 返回ModelAndView对象
        return mav;
    }
}
