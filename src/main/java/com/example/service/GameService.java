package com.example.service;

import com.example.pojo.Game;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface GameService {
    Result getgameList(int page, int limit);
    Result getgameListByname(String dname,int page, int limit);
    Result addgame(Game game);
Result deletegame(int id);
Game getgameById(int id);
Result savegame(Game game);

public List<Game> findAllGames();
}