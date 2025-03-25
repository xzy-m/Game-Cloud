package com.example.provider.controller;

import com.example.common.entity.Tag;
import com.example.common.response.Response;
import com.example.provider.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2024-09-28 下午 2:58
 */
@RestController
public class TagController {

    @Autowired
    public TagService tagService;

    @RequestMapping("/tag/getById")
    public Tag getById(@RequestParam("id") BigInteger id) {
        return tagService.getById(id);
    }

    @RequestMapping("/tag/getAll")
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @RequestMapping("/tag/extractById")
    public Tag extractById(@RequestParam("id") BigInteger id) {
        return tagService.extractById(id);
    }

    @RequestMapping("/tag/insert")
    public int insert(@RequestBody Tag tag) {
        return tagService.insert(tag);
    }

    @RequestMapping("/tag/update")
    public int update(@RequestBody Tag tag) {
        return tagService.update(tag);
    }

    @RequestMapping("/tag/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return tagService.delete(id);
    }

    @RequestMapping("/tag/insertOrUpdate")
    public BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                                     @RequestParam("name") String name) {
        return tagService.insertOrUpdate(id, name);
    }

    @RequestMapping("/tag/insertToRelationTable")
    public void insertToRelationTable(@RequestParam("gameId") BigInteger gameId,
                                      @RequestParam("tagId") BigInteger tagId) {
        tagService.insertToRelationTable(gameId, tagId);
    }

    @RequestMapping("/tag/getTagsByGameId")
    public List<Tag> getTagsByGameId(@RequestParam("gameId") BigInteger gameId) {
        return tagService.getTagsByGameId(gameId);
    }

    @RequestMapping("/tag/deleteRelationRecord")
    public int deleteRelationRecord(@RequestParam("gameId") BigInteger gameId,
                                    @RequestParam("tagId") BigInteger tagId) {
        return tagService.deleteRelationRecord(gameId, tagId);
    }

    @RequestMapping("/tag/selectGameIdByTagId")
    public List<BigInteger> selectGameIdByTagId(@RequestParam("tagId") BigInteger tagId) {
        return tagService.selectGameIdByTagId(tagId);
    }

    @RequestMapping("/tag/selectByName")
    public Tag selectByName(@RequestParam("tagName") String tagName) {
        return tagService.selectByName(tagName);
    }

}
