package com.example.console.feign;

import com.example.common.entity.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:14
 */

@FeignClient(name = "provider", contextId = "TagFeign")
public interface TagFeign {
    @RequestMapping("/tag/getById")
    Tag getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/tag/getAll")
    List<Tag> getAll();

    @RequestMapping("/tag/extractById")
    Tag extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/tag/insert")
    int insert(@RequestBody Tag tag);

    @RequestMapping("/tag/update")
    int update(@RequestBody Tag tag);

    @RequestMapping("/tag/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/tag/insertOrUpdate")
    BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                              @RequestParam("name") String name);

    @RequestMapping("/tag/insertToRelationTable")
    void insertToRelationTable(@RequestParam("gameId") BigInteger gameId,
                               @RequestParam("tagId") BigInteger tagId);

    @RequestMapping("/tag/getTagsByGameId")
    List<Tag> getTagsByGameId(@RequestParam("gameId") BigInteger gameId);

    @RequestMapping("/tag/deleteRelationRecord")
    int deleteRelationRecord(@RequestParam("gameId") BigInteger gameId,
                             @RequestParam("tagId") BigInteger tagId);

    @RequestMapping("/tag/selectGameIdByTagId")
    List<BigInteger> selectGameIdByTagId(@RequestParam("tagId") BigInteger tagId);

    @RequestMapping("/tag/selectByName")
    Tag selectByName(@RequestParam("tagName") String tagName);
}
