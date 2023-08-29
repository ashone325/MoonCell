
package com.example.controller;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.pojo.Game;
import com.example.pojo.OrderRequest;
import com.example.service.GameService;
import com.example.service.GameServicempl;
import com.example.util.Result;
import com.example.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public String gotogameadd(){return "admin/game-add";}
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
    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        gameService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

    @ResponseBody
    @GetMapping("/reload")
    public boolean reload(HttpSession session){
        String name = session.getAttribute("name").toString();
        return  name != null;
    }
    @PostMapping({"/upload/gamelogo"})
    @ResponseBody
    public boolean upload(HttpServletRequest request, @RequestParam("file") MultipartFile file /*HttpSession session*/) throws URISyntaxException {
        String suffixName = UploadFileUtils.getSuffixName(file);
        String newFileName = UploadFileUtils.getNewFileName(suffixName);

        String path = System.getProperty("gamelogo.dir") + "/upload/";
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
            //session.setAttribute("gamelogo", sqlImg);//
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



}



