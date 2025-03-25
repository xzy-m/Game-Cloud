package com.example.console.feign;

import com.example.common.entity.Category;
import com.example.common.entity.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:38
 */

@FeignClient(name = "provider", contextId = "CategoryFeign")
public interface CategoryFeign {
    @RequestMapping("/category/getById")
    Category getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/category/extractById")
    Category extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/category/insertOrUpdate")
    BigInteger insertOrUpdate(@RequestParam("id") BigInteger id, @RequestParam("type") String type, @RequestParam("parentId") BigInteger parentId);

    @RequestMapping("/category/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/category/getCategoryList")
    List<Category> getCategoryList(@RequestParam("idList") ArrayList<BigInteger> idList);

    @RequestMapping("/category/categoryLevel1And2")
    List<Category> categoryLevel1And2();

    @RequestMapping("/category/categoryLevel3AndAbove")
    List<Category> categoryLevel3AndAbove(@RequestParam("id") BigInteger id);

    @RequestMapping("/category/getGamesByCategoryId")
    List<Game> getGamesByCategoryId(@RequestParam("ids") List<BigInteger> ids);

    @RequestMapping("/category/categoryTree")
    List<Category> categoryTree();

    @RequestMapping("/category/recursionInCategory")
    void recursionInCategory(@RequestParam("categoryList") List<Category> categoryList, @RequestBody Category category);

    @RequestMapping("/category/getChildren")
    List<Category> getChildren(@RequestParam("list") List<Category> list, @RequestBody Category goalCategory);

    @RequestMapping("/category/ifHasChildren")
    boolean ifHasChildren(@RequestParam("list") List<Category> list, @RequestBody Category category);
}
