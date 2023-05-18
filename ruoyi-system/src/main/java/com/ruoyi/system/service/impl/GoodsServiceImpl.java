package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.Goods;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/19
 **/
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> select(Goods goods) {
        return goodsMapper.select(goods);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int deleteById(Integer id) {
        return goodsMapper.deleteById(id);
    }
}
