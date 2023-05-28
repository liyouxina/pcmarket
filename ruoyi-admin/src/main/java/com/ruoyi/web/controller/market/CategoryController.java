package com.ruoyi.web.controller.market;

/**
 * @Author: ruohao
 * @Date: 2023/5/18
 **/

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Category;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.response.CategoryListResp;
import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/market/category")
public class CategoryController extends BaseController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public TableDataInfo list(Category category)
    {
        startPage();
        List<Category> list = categoryService.select(category);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public TableDataInfo listAll(Category category)
    {
        startPage();
        List<CategoryListResp> list = categoryService.selectAll(category);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody Category category) {
        return toAjax(categoryService.insert(category));
    }

    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Category category) {
        return toAjax(categoryService.update(category));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += categoryService.deleteById(id);
        }
        return toAjax(count);
    }

    @GetMapping(value = { "/", "/{id}" })
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Integer id)
    {
        AjaxResult ajax = AjaxResult.success();
        Category category = new Category();
        category.setId(id);
        ajax.put(AjaxResult.DATA_TAG, categoryService.select(category).get(0));
        return ajax;
    }
}
