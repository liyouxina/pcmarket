package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.common.core.domain.entity.Goods;
import com.ruoyi.system.mapper.CategoryMapper;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.response.CategoryListResp;
import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ruohao
 * @Date: 2023/5/19
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<CategoryListResp> selectAll(Category category) {
        category = new Category();
        category.setLevel(1);
        List<Category> levelOnes = categoryMapper.select(category);
        List<CategoryListResp> resps = levelOnes.stream().map(c -> {
            CategoryListResp resp = convert(c);
            Category filter = new Category();
            filter.setParent(c.getId());
            List<Category> levelTwos = categoryMapper.select(filter);
            if (CollectionUtils.isEmpty(levelTwos)) {
                return resp;
            }
            resp.setChildren(levelTwos.stream().map(cTow -> {
                CategoryListResp respTow = CategoryServiceImpl.convert(cTow);
                Goods goodsFilter = new Goods();
                goodsFilter.setCategoryId(cTow.getId());
                List<Goods> goods = goodsMapper.select(goodsFilter);
                if (CollectionUtils.isEmpty(goods)) {
                    return respTow;
                }
                respTow.setChildren(goods.stream().map(CategoryServiceImpl::convert).collect(Collectors.toList()));
                return respTow;
            }).collect(Collectors.toList()));
            return resp;
        }).collect(Collectors.toList());
        return resps;
    }

    @Override
    public List<Category> select(Category category) {
        return categoryMapper.select(category);
    }

    public static CategoryListResp convert(Category category) {
        CategoryListResp resp = new CategoryListResp();
        resp.setId(category.getId());
        resp.setName(category.getName());
        resp.setLevel(category.getLevel());
        resp.setChildren(new ArrayList<>());
        return resp;
    }

    public static CategoryListResp convert(Goods goods) {
        CategoryListResp resp = new CategoryListResp();
        resp.setName(goods.getName());
        resp.setDesc(goods.getInfo());
        resp.setImg(goods.getPictureUrl());
        resp.setChildren(new ArrayList<>());
        return resp;
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
