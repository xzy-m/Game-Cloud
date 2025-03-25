package com.example.provider.controller;

import com.example.common.entity.Category;
import com.example.common.entity.Game;
import com.example.common.response.Response;
import com.example.provider.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:40
 */

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/getById")
    public Category getById(BigInteger id) {
        return categoryService.getById(id);
    }

    @RequestMapping("/category/extractById")
    public Category extractById(@RequestParam("id") BigInteger id) {
        return categoryService.extractById(id);
    }

    @RequestMapping("/category/insertOrUpdate")
    public BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                                     @RequestParam("type") String type,
                                     @RequestParam("parentId") BigInteger parentId) {
        return categoryService.insertOrUpdate(id, type, parentId);
    }

    @RequestMapping("/category/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return categoryService.delete(id);
    }

    @RequestMapping("/category/getCategoryList")
    public List<Category> getCategoryList(@RequestParam("idList") ArrayList<BigInteger> idList) {
        return categoryService.getCategoryList(idList);
    }

    @RequestMapping("/category/categoryLevel1And2")
    public List<Category> categoryLevel1And2() {
        return categoryService.categoryLevel1And2();
    }

    @RequestMapping("/category/categoryLevel3AndAbove")
    public List<Category> categoryLevel3AndAbove(@RequestParam("id") BigInteger id) {
        return categoryService.categoryLevel3AndAbove(id);
    }

    @RequestMapping("/category/getGamesByCategoryId")
    public List<Game> getGamesByCategoryId(@RequestParam("ids") List<BigInteger> ids) {
        return categoryService.getGamesByCategoryId(ids);
    }

    @RequestMapping("/category/categoryTree")
    public List<Category> categoryTree() {
        return categoryService.categoryTree();
    }

    @RequestMapping("/category/recursionInCategory")
    public void recursionInCategory(@RequestParam("categoryList") List<Category> categoryList,
                                    @RequestBody Category category) {
        categoryService.recursionInCategory(categoryList, category);
    }

    @RequestMapping("/category/getChildren")
    public List<Category> getChildren(@RequestParam("categoryList") List<Category> list,
                                      @RequestBody Category goalCategory) {
        return categoryService.getChildren(list, goalCategory);
    }

    @RequestMapping("/category/ifHasChildren")
    public boolean ifHasChildren(@RequestParam("list") List<Category> list,
                                 @RequestBody Category category) {
        return categoryService.ifHasChildren(list, category);
    }

}
