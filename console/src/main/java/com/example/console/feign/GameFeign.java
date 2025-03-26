package com.example.console.feign;

import com.example.common.entity.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:54
 */

@FeignClient(name = "provider", contextId = "GameFeign")
public interface GameFeign {

    @RequestMapping("/game/gameAll")
    List<Game> gameAll();

    @RequestMapping("/game/gameInfo")
    Game gameInfo(@RequestParam("id") BigInteger id);

    @RequestMapping("/game/insertOrUpdate")
    BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                              @RequestParam("pictures") String pictures,
                              @RequestParam("title") String title,
                              @RequestParam("downloadLink") String downloadLink,
                              @RequestParam("categoryId") BigInteger categoryId,
                              @RequestParam("detail") String detail,
                              @RequestParam("tags") String tags);

    @RequestMapping("/game/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/game/getPages")
    List<Game> getPages(@RequestParam("page") int page,
                        @RequestParam("pageSize") int pageSize,
                        @RequestParam("title") String title);

    @RequestMapping("/game/getTotal")
    int getTotal(@RequestParam("title") String title);

    @RequestMapping("/game/convertCategoryIdListToStringByTitle")
    String convertCategoryIdListToStringByTitle(@RequestParam("title") String title);

    @RequestMapping("/game/batchInsert")
    void batchInsert(@RequestParam("games") List<Game> games);

    @RequestMapping("/game/countGames")
    int countGames();

    @RequestMapping("/game/deleteByCategoryId")
    int deleteByCategoryId(@RequestParam("id") BigInteger id);
}
