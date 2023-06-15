
package com.example.controller;
import java.util.List;

import com.example.pojo.Game;
import com.example.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/gamefront")//商店页面
public class GamefrontController {

  @Resource
  GameService gameService;
    @GetMapping("game")
    public String showGames(Model model) {
        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);
        return "gamefront/game";

    }}