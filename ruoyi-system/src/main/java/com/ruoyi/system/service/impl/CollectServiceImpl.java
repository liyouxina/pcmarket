package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.Collect;
import com.ruoyi.system.mapper.CollectMapper;
import com.ruoyi.system.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/19
 **/
@Service
public class CollectServiceImpl implements ICollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<Collect> select(Collect collect) {
        return collectMapper.select(collect);
    }

    @Override
    public int insert(Collect collect) {
        return collectMapper.insert(collect);
    }

    @Override
    public int deleteById(Integer id) {
        return collectMapper.deleteById(id);
    }
}
