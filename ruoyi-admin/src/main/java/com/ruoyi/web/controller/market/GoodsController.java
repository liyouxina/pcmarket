package com.ruoyi.web.controller.market;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.common.core.domain.entity.Goods;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.service.ICategoryService;
import com.ruoyi.system.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/
@RestController
@RequestMapping("/market/goods")
public class GoodsController extends BaseController {
    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.select(goods);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody Goods goods) {
        return toAjax(goodsService.insert(goods));
    }

    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Goods goods) {
        return toAjax(goodsService.update(goods));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += goodsService.deleteById(id);
        }
        return toAjax(count);
    }

    @GetMapping(value = { "/", "/{id}" })
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Integer id)
    {
        AjaxResult ajax = AjaxResult.success();
        Goods goods = new Goods();
        goods.setId(id);
        ajax.put(AjaxResult.DATA_TAG, goodsService.select(goods).get(0));
        return ajax;
    }
}
