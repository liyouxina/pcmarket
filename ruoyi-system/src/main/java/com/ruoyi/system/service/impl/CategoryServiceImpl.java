package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.system.mapper.CategoryMapper;
import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/19
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> select(Category category) {
        return categoryMapper.select(category);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteById(Integer id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }
}
