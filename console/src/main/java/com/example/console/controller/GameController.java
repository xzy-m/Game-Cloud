package com.example.console.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.annotation.DataSource;
import com.example.common.entity.Category;
import com.example.common.entity.Game;
import com.example.common.enums.DBTypeEnum;
import com.example.common.response.Response;
import com.example.console.domain.DetailVo;
import com.example.console.domain.GameConsolePageVo;
import com.example.console.domain.ListGameVo;
import com.example.console.feign.CategoryFeign;
import com.example.console.feign.GameFeign;
import com.example.console.tool.GameDetailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author XRS
 * @date 2024-07-13 上午 6:27
 */
@RestController
public class GameController {

    @Autowired
    private GameFeign gameFeign;

    @Autowired
    private CategoryFeign categoryFeign;

    @DataSource(type = DBTypeEnum.MASTER)
    @RequestMapping("/console/game/categoryTree")
    public Response categoryTree() {
        List<Category> tree = categoryFeign.categoryTree();
        return new Response("1001", tree);
    }

    //String.trim(),去掉前后的空格,@RequestParam让传入参数一定不为null
    @DataSource(type = DBTypeEnum.SLAVE2)
    @RequestMapping("/console/game/insert")
    public Response insert(@RequestParam("pictures") String pictures,
                           @RequestParam("title") String title,
                           @RequestParam("downloadLink") String downloadLink,
                           @RequestParam("categoryId") BigInteger categoryId,
                           @RequestParam("detail") String detail,
                           @RequestParam("tags") String tags) {
        try {
            //判断detail
            byte[] decode = Base64.getUrlDecoder().decode(detail);
            String detailJson = new String(decode);
            List<DetailVo> detailVoList = JSON.parseArray(detailJson, DetailVo.class);
            for (DetailVo detailVo : detailVoList) {
                if (!GameDetailTool.checkDetail(detailVo.getType())) {
                    return new Response("1003", "type is not allowed");
                }
            }

            String statusCode = gameFeign.insertOrUpdate(null, pictures.trim(), title.trim(), downloadLink.trim(), categoryId, detail, tags.trim()) != null ? "1001" : "1003";
            Response response = new Response(statusCode);
            return response;
        } catch (Exception e) {
            Response response = new Response("1004");
            return response;
        }
    }

    //Controller不抛异常，直接在catch中return
    @DataSource(type = DBTypeEnum.SLAVE1)
    @RequestMapping("/console/game/update")
    public Response update(@RequestParam("id") BigInteger id,
                           @RequestParam("pictures") String pictures,
                           @RequestParam("title") String title,
                           @RequestParam("downloadLink") String downloadLink,
                           @RequestParam("categoryId") BigInteger categoryId,
                           @RequestParam("detail") String detail,
                           @RequestParam("tags") String tags) {
        try {
            byte[] decode = Base64.getUrlDecoder().decode(detail);
            String detailJson = new String(decode);
            List<DetailVo> detailVoList = JSON.parseArray(detailJson, DetailVo.class);
            for (DetailVo detailVo : detailVoList) {
                if (!GameDetailTool.checkDetail(detailVo.getType())) {
                    return new Response("1003", "type is not allowed");
                }
            }

            String statusCode = gameFeign.insertOrUpdate(id, pictures.trim(), title.trim(), downloadLink.trim(), categoryId, detail, tags.trim()) != null ? "1001" : "1003";
            Response response = new Response(statusCode);
            return response;
        } catch (Exception e) {
            Response response = new Response("1004");
            return response;
        }
    }

    @DataSource(type = DBTypeEnum.MASTER)
    @RequestMapping("/console/game/delete")
    public Response delete(@RequestParam("id") BigInteger id) {
        String statusCode = gameFeign.delete(id) == 1 ? "1001" : "1003";
        Response response = new Response(statusCode);
        return response;
    }

    //分页 PC（管理后台） 分页， 前端传你page，你传给前端total、pageSize、list
    @DataSource(type = DBTypeEnum.SLAVE1)
    @RequestMapping("/console/game/page")
    public Response pagination(@RequestParam("page") int page,
                               @RequestParam(value = "title", required = false) String title) {

        //准备一个统一返回和所需Vo
        GameConsolePageVo pageVo = new GameConsolePageVo();

        if (title != null) {
            title = title.trim();
        }

        //vo参数:pageSize
        pageVo.setPageSize(3);

        //vo参数:list
        List<Game> pageLimit = gameFeign.getPages(page, pageVo.getPageSize(), title);
        ArrayList<ListGameVo> list = new ArrayList<>();
        for (Game game : pageLimit) {

            ListGameVo listGameVo = new ListGameVo();
            listGameVo.setGameId(game.getId());
            listGameVo.setTitle(game.getTitle());
            listGameVo.setPicture(game.getPictures().split("\\$")[0]);

            //pageVo.getPageList(),报错，不能为null
            list.add(listGameVo);
        }

        //vo参数:total,总数跟随查询的内容
        pageVo.setTotal(gameFeign.getTotal(title));
        pageVo.setPageList(list);

        //统一返回
        Response<GameConsolePageVo> response = new Response<>("1001");
        response.setData(pageVo);
        return response;
    }
}
