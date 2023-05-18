package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.Collect;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/
public interface CollectMapper {
    public List<Collect> select(Collect collect);
    public int insert(Collect collect);
    public int deleteById(Integer id);
}
