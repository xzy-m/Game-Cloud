package com.example.provider.domain;

import com.example.common.entity.Category;
import com.example.common.entity.Game;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author XRS
 * @date 2024-12-29 上午 2:04
 */
@Data
@Accessors(chain = true)
public class CategoryVo {
    private List<Category> categoryList;
    private List<Game> gameList;
}
