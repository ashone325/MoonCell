
package com.example.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.example.pojo.Game;
import com.example.service.GameService;
import com.example.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class GameController {

  @Resource
  GameService gameService;
    @GetMapping("/game")
    public String list(){
        return "admin/game-list";
    }
    @GetMapping("/game/listall")
    @ResponseBody
    public Result listall(@RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return gameService.getgameList(start,limit);//
    }
@GetMapping("/game/listbyname")
@ResponseBody
    public Result listByName(@RequestParam("dname")String dname, @RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return gameService.getgameListByname(dname,start,limit);//
    }

    @GetMapping("/game/add")
    public String gotogameadd(){
        return "admin/game-add";
    }
    @PostMapping("/game/add")
    @ResponseBody
    public Result addgame(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description") String description){//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等
        Game game = new Game();
        game.setDname(dname);
        game.setDtel(dtel);
        game.setDescription(description);
        game.setEstablishmentdate(new Timestamp(new Date().getTime()) );
        return gameService.addgame(game);
    }
    @PostMapping("/game/delete")
    @ResponseBody
    public Result deletegame(@RequestParam("id") int id ) {//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等

        return gameService.deletegame(id);
    }
    //1.先显示被改部门的信息 get
    @GetMapping("/game/edit")
    public String gotogameedit(@RequestParam("id") int id, Model model){
        Game game =  gameService.getgameById(id);
        //对应id 信息送到前端
        model.addAttribute("gameInfo",game);
        return "admin/game-edit";
    }
    //2.修改部门信息post
@PostMapping("/game/edit")
@ResponseBody
    public Result savegame(@RequestParam("id") int id,@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description") String description){//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等
       Game game =  gameService.getgameById(id);
        game.setDname(dname);
        game.setDtel(dtel);
        game.setDescription(description);
        return gameService.savegame(game);
    }
@ResponseBody
    @GetMapping("/reload")
    public boolean reload(HttpSession session){
        String name = session.getAttribute("name").toString();
        return  name != null;
    }
}


