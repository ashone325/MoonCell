
package com.example.service;

import com.example.dao.GameMapper;
import com.example.pojo.Game;
import com.example.pojo.OrderRequest;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GameServicempl implements GameService {
    @Resource
    GameMapper gameMapper;

    @Override
    public Result getgameList(int start, int limit) {
        List<Game> gameList = gameMapper.findgameList(start,
                limit);
        int totalgames = gameMapper.getTotalgames();
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalgames);
        result.setData(gameList);
        return result;
    }
    @Override
    public Result getgameListByname(String dname,int start, int limit) {
        List<Game> gameList = gameMapper.findgameListByname(dname,start,
                limit);
        int totalgames = gameMapper.getTotalgamesByname(dname);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalgames);
        result.setData(gameList);
        return result;
    }

    @Override
    public Result addgame(Game game) {
        Result result = new Result();
        if(gameMapper.insertSelective(game)){
            result.setCode(0);
            result.setMsg("添加成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("添加失败！");
        }
        return result;

    }

    @Override
    public Result deletegame(int id) {
        Result result = new Result();
        if (gameMapper.deleteByPrimaryKey(id)){
            result.setCode(0);
            result.setMsg("删除成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("删除失败！");
        }
        return result;
    }

    @Override
    public Game getgameById(int id) {
        return gameMapper.selectByPrimaryKey(id);
    }

    @Override
    public Game GetGameInfoById(int id) {
        Game msg;
        msg = gameMapper.getgameById(id);
        return msg;
    }

    @Override
    public Result savegame(Game game) {
        Result result = new Result();
        if (gameMapper.updateByPrimaryKeySelective(game)){
            result.setCode(0);
            result.setMsg("修改成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("修改失败！");
        }
        return result;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        gameMapper.insertOrder(orderRequest);

    }

    @Override
    public List<Game> findAllGames() {
        return gameMapper.getAllGames();
    }


}

