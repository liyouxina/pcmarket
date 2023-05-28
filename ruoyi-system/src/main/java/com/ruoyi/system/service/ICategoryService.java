package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.system.response.CategoryListResp;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/
public interface ICategoryService {
    public List<CategoryListResp> selectAll(Category category);
    public List<Category> select(Category category);
    public int insert(Category category);
    public int deleteById(Integer id);
    public int update(Category category);
}
