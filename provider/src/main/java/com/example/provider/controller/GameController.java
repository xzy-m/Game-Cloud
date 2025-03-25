package com.example.provider.controller;

import com.example.common.entity.Game;
import com.example.provider.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:52
 */
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/game/gameAll")
    public List<Game> gameAll() {
        return gameService.gameAll();
    }

    @RequestMapping("/game/gameInfo")
    public Game gameInfo(@RequestParam("id") BigInteger id) {
        return gameService.gameInfo(id);
    }

    @RequestMapping("/game/insertOrUpdate")
    public BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                                     @RequestParam("pictures") String pictures,
                                     @RequestParam("title") String title,
                                     @RequestParam("downloadLink") String downloadLink,
                                     @RequestParam("categoryId") BigInteger categoryId,
                                     @RequestParam("detail") String detail,
                                     @RequestParam("tags") String tags) {
        return gameService.insertOrUpdate(id, pictures, title, downloadLink, categoryId, detail, tags);
    }

    @RequestMapping("/game/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return gameService.delete(id);
    }

    @RequestMapping("/game/getPages")
    public List<Game> getPages(@RequestParam("page") int page,
                               @RequestParam("pageSize") int pageSize,
                               @RequestParam("title") String title) {
        return gameService.getPages(page, pageSize, title);
    }

    @RequestMapping("/game/getTotal")
    public int getTotal(@RequestParam("title") String title) {
        return gameService.getTotal(title);
    }

    @RequestMapping("/game/convertCategoryIdListToStringByTitle")
    public String convertCategoryIdListToStringByTitle(@RequestParam("title") String title) {
        return gameService.convertCategoryIdListToStringByTitle(title);
    }

    @RequestMapping("/game/batchInsert")
    public void batchInsert(@RequestParam("games") List<Game> games) {
        gameService.batchInsert(games);
    }

    @RequestMapping("/game/countGames")
    public int countGames() {
        return gameService.countGames();
    }
}
