
package com.example.controller;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.pojo.Auser;
import com.example.pojo.Game;
import com.example.service.Auserservice;
import com.example.service.CommentService;
import com.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gamefront")//商店页面
public class GamefrontController {

    @Resource
    GameService gameService;
    @Autowired
    Auserservice auserservice;
    @Autowired
    CommentService commentService;

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
    @GetMapping("/myGames")
    // 获取当前登录的用户
    public String myGames(@RequestParam("id") int id, Model model){
        System.out.println("aaa"+id);
        List<Game> game = gameService.getGamesByUserId(id);
        System.out.println("bbb"+game);
        model.addAttribute("myGames", game);
        return "gamefront/mygames";
    }
    @GetMapping("/gamePurchaseSuccess")
    public String gamePurchaseSuccess() {
        return "gamefront/gamePurchaseSuccess"; // 返回购买成功的HTML模板名称
    }
    @PostMapping("/addGameToCart")
    @ResponseBody
    public Map<String, Object> addGameToCart(@RequestParam("gameId") int gameId, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 从数据库中获取游戏信息
            Game game = gameService.getgameById(gameId);
            if (game != null) {
                // 从session中获取购物车列表
                Map<Integer, Game> cartItems = (Map<Integer, Game>) session.getAttribute("cartItems");

                // 如果购物车列表为空，则创建一个新的购物车列表
                if (cartItems == null) {
                    cartItems = new HashMap<>();
                }

                // 将游戏对象存储到购物车列表中，使用游戏ID作为键
                cartItems.put(gameId, game);

                // 将购物车列表重新存储回session中
                session.setAttribute("cartItems", cartItems);

                map.put("success", true);
                map.put("message", "游戏已添加到用户购物车");
            } else {
                map.put("success", false);
                map.put("message", "无法找到游戏");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "服务器错误");
        }
        return map;
    }


    @GetMapping("/Cart")
    public String viewCart(HttpSession session, Model model) {
        // 从会话中获取购物车信息
        Map<Integer, Game> cart = (Map<Integer, Game>) session.getAttribute("cartItems");

        // 将购物车信息传递给视图
        model.addAttribute("cart", cart);

        // 返回购物车页面的视图名称
        return "/gamefront/Cart";
    }
    @PostMapping("/insertcomment")
    public String insertComment(
            @RequestParam("Comment") String comment,
            @RequestParam("gameId") int gameId,
            @RequestParam("userId") int userId) {
        // 在这里调用CommentService的方法来保存评论到数据库
        commentService.insertComment(comment, gameId, userId);
        // 这里可以根据需要进行重定向或返回适当的视图
        return "redirect:/gamefront/success"; // 假设您有一个成功页面
    }










}