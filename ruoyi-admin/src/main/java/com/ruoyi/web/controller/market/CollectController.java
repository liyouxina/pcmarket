package com.ruoyi.web.controller.market;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.common.core.domain.entity.Collect;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.service.ICategoryService;
import com.ruoyi.system.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/
@RestController
@RequestMapping("/market/collect")
public class CollectController extends BaseController {
    @Autowired
    private ICollectService collectService;

    @GetMapping("/list")
    public TableDataInfo list(Collect collect)
    {
        startPage();
        List<Collect> list = collectService.select(collect);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody Collect collect) {
        return toAjax(collectService.insert(collect));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += collectService.deleteById(id);
        }
        return toAjax(count);
    }
}
