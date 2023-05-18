package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.Goods;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/
public interface IGoodsService {
    public List<Goods> select(Goods goods);
    public int insert(Goods goods);
    public int update(Goods goods);
    public int deleteById(Integer id);
}
